package com.company.ui.entities;

import com.company.logic.GarageSystem;
import com.company.logic.enums.EngineType;
import com.company.logic.enums.VehicleGarageState;
import com.company.logic.enums.VehicleType;
import com.company.ui.exceptions.InputValidatorException;
import com.company.ui.validators.InputValidator;
import java.util.Scanner;
import java.util.Set;

public class UILogic {
  private GarageSystem garageSystem;
  private Scanner scanner;
  
  
  public UILogic(GarageSystem garageSystem, Scanner scanner) {
    this.garageSystem = garageSystem;
    this.scanner = scanner;
  }
  
  public GarageSystem getGarageSystem() {
    return garageSystem;
  }
  
  public void addNewVehicle() {
    System.out.println("You chose to add a new vehicle to the garage");
    String licenseNumber = getLicenseNumber();
    VehicleType vehicleType = getVehicleType();
    EngineType engineType = getEngineType();
    String model = getModel();
    String ownerNumber = getOwnerNumber();
    String phoneNumber = getPhoneNumber();
    garageSystem.addVehicle(engineType, vehicleType, model, licenseNumber,
        ownerNumber, phoneNumber);
  }
  
  public void displayLicenseNumbers() {
    System.out.println("You chose to display all garage vehicles' license numbers");
    Set<String> licenseNumbers = garageSystem.displayLicenseNumbers();
    String message = licenseNumbers.size() == 0 ? "There are 0 vehicles in the garage. No license numbers to display." : "The license numbers are:";
    System.out.println(message);
    for(String licenseNumber : licenseNumbers) {
      System.out.println("license number: " + licenseNumber);
    }
  }
  
  public void updateVehicleState() {
    System.out.println("You chose to update a vehicle's state:");
    String licenseNumber = getLicenseNumber();
    VehicleGarageState state = getVehicleState();
    garageSystem.updateGarageTicketState(licenseNumber, state);
  }
  
  
  public void inflateWheel() {
  }
  
  
  public void fuelVehicle() {
  }
  
  public void chargeVehicle() {
  }
  
  public void displayVehiclesDetails() {
  }
  
  
  
  private VehicleGarageState getVehicleState() {
    String state = null;
    VehicleGarageState vehicleGarageState = null;
    boolean isValidInput = false;
    do{
      System.out.println("Choose the new vehicle's state:");
      for(VehicleGarageState type : VehicleGarageState.values()) {
        System.out.println(type);
      }
      state = scanner.nextLine();
      try {
        vehicleGarageState = InputValidator.isValidVehicleStateEnumType(state);
        isValidInput = vehicleGarageState != null;
      } catch (InputValidatorException exception) {
        System.out.println(exception);
      }
    } while(!isValidInput);
    return vehicleGarageState;
  }
  
  private String getModel() {
    return getString("Please provide the vehicle's model");
  }
  
  private String getOwnerNumber() {
    return getString("Please provide the owner number:");
  }
  
  private String getString(String instructionToPrint) {
    String input = null;
    boolean isValidInput = false;
    do{
      System.out.println(instructionToPrint);
      input = scanner.nextLine();
      try {
        isValidInput = InputValidator.isNotEmpty(input);
      }
      catch(InputValidatorException exception) {
        System.out.println(exception);
      }
    } while(!isValidInput);
    return input;
  }
  
  private EngineType getEngineType() {
    String input = null;
    EngineType engineType = null;
    boolean isValidInput = false;
    do{
      System.out.println("Choose engine type:");
      for(EngineType type : EngineType.values()) {
        System.out.println(type);
      }
      input = scanner.nextLine();
      try {
        engineType = InputValidator.isValidEngineType(input);
        isValidInput = engineType != null;
      } catch (InputValidatorException exception) {
        System.out.println(exception);
      }
    } while(!isValidInput);
    return engineType;
  }
  
  private VehicleType getVehicleType() {
    VehicleType vehicleType = null;
    do{
      System.out.println("Which vehicle would you like to add:");
      for(VehicleType type : VehicleType.values()) {
        System.out.println(type);
      }
      vehicleType = VehicleType.getByType(scanner.nextLine());
    } while(vehicleType == null);
    return vehicleType;
  }
  
  private String getPhoneNumber() {
    return getStringOfValueInteger("Please provide the owner's phone number:");
  }
  
  private String getLicenseNumber() {
    return getStringOfValueInteger("Please provide the vehicle's license number:");
  }
  
  private String getStringOfValueInteger(String instructionToPrint) {
    String input = null;
    boolean isValidInput = false;
    do {
      System.out.println(instructionToPrint);
      input = scanner.nextLine();
      try {
        isValidInput = InputValidator.canBeConvertedToInteger(input);
      }
      catch(InputValidatorException exception) {
        System.out.println(exception.getExtraMessage());
      }
    } while(!isValidInput);
    return input;
  }

}
