package com.company.logic;

import com.company.logic.entities.GarageTicket;
import com.company.logic.entities.vehicle.Vehicle;
import com.company.logic.enums.EngineType;
import com.company.logic.enums.FuelType;
import com.company.logic.enums.VehicleGarageState;
import com.company.logic.enums.VehicleType;
import com.company.logic.factories.VehicleFactory;
import java.util.HashSet;
import java.util.Set;

public class GarageSystem {
  private GarageManager garageManager;
  
  public GarageSystem(GarageManager garageManager) {
    this.garageManager = garageManager;
  }
  
  public void addVehicle(EngineType engineType,
                         VehicleType vehicleType,
                         String model,
                         String licenceNumber,
                         String ownerName, String phoneNumber) {
    if(garageManager.isExists(licenceNumber)) {
      garageManager.updateVehicleState(licenceNumber, VehicleGarageState.IN_REPAIR);
      return;
    }
    Vehicle vehicle = garageManager.createVehicle(
              engineType, vehicleType, model, licenceNumber);
    GarageTicket garageTicket = garageManager.createGarageTicket(
                  ownerName, phoneNumber, vehicle);
    garageManager.addVehicle(garageTicket);
  }
  
  public Set<String> displayLicenseNumbers() {
    Set<String> licenseNumbers = new HashSet<String>();
    for(GarageTicket garageTicket : garageManager.getGarageTickets()) {
      licenseNumbers.add(garageTicket.getVehicle().getLicenceNumber());
    }
    return licenseNumbers;
  }
  
  public void updateGarageTicketState(String licenceNumber, VehicleGarageState state) {
    garageManager.updateVehicleState(licenceNumber, state);
  }
  
  public void inflateWheelsToMaximum(String licenceNumber) {
    garageManager.inflateWheelsToMaximum(licenceNumber);
  }
  
  public void fuelVehicle(String licenceNumber, FuelType fuelType,
    float fuelAmount) {
    garageManager.fuelVehicle(licenceNumber, fuelType, fuelAmount);
  }
  
  public GarageTicket displayGarageTicketDetails(String licenceNumber) {
    return garageManager.displayGarageTicketDetails(licenceNumber);
  }
}
