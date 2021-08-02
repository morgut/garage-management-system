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

public class GarageManager {
  private Set<GarageTicket> garageTickets;
  private VehicleFactory vehicleFactory;
  
  public GarageManager(VehicleFactory vehicleFactory) {
    this.vehicleFactory = vehicleFactory;
    garageTickets = new HashSet<GarageTicket>();
  }
  
  public Set<GarageTicket> getGarageTickets() {
    return garageTickets;
  }
  
  public Vehicle createVehicle(EngineType engineType, VehicleType vehicleType,
                               String model,
                               String licenceNumber) {
    return vehicleFactory.createVehicle(engineType, vehicleType, model, licenceNumber);
  }
  
  public GarageTicket createGarageTicket(String ownerName, String phoneNumber, Vehicle vehicle) {
    return new GarageTicket(ownerName, phoneNumber, vehicle);
  }
  
  public boolean isExists(String licenseNumber) {
    if(!garageTickets.isEmpty()) {
      for(GarageTicket garageTicket : garageTickets) {
        if (garageTicket.getVehicle().getLicenceNumber().equals(licenseNumber)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void updateVehicleState(String licenseNumber, VehicleGarageState state) {
    if(!garageTickets.isEmpty()) {
      for(GarageTicket garageTicket : garageTickets) {
        Vehicle vehicle = garageTicket.getVehicle();
        if (vehicle.getLicenceNumber().equals(licenseNumber)) {
          garageTicket.setState(state);
        }
      }
    }
  }
  
  public void addVehicle(GarageTicket garageTicket) {
    garageTickets.add(garageTicket);
  }
  
  public void inflateWheelsToMaximum(String licenceNumber) {
    if(!garageTickets.isEmpty()) {
      for(GarageTicket garageTicket : garageTickets) {
        Vehicle vehicle = garageTicket.getVehicle();
        if (vehicle.getLicenceNumber().equals(licenceNumber)) {
          garageTicket.getVehicle().inflateWheelsToMaximum();
        }
      }
    }
  }
  
  public void fuelVehicle(String licenceNumber, FuelType fuelType, float fuelAmount) {
    if(!garageTickets.isEmpty()) {
      for(GarageTicket garageTicket : garageTickets) {
        Vehicle vehicle = garageTicket.getVehicle();
        if (vehicle.getLicenceNumber().equals(licenceNumber)) {
          // fuel the vehicle
        }
      }
    }
  }
  
  public void ChargeVehicle(String licenceNumber, float BatteryTime) {
    if(!garageTickets.isEmpty()) {
      for(GarageTicket garageTicket : garageTickets) {
        Vehicle vehicle = garageTicket.getVehicle();
        if (vehicle.getLicenceNumber().equals(licenceNumber)) {
          // charge the vehicle
        }
      }
    }
  }
  
  public GarageTicket displayGarageTicketDetails(String licenceNumber) {
    if(!garageTickets.isEmpty()) {
      for(GarageTicket garageTicket : garageTickets) {
        Vehicle vehicle = garageTicket.getVehicle();
        if (vehicle.getLicenceNumber().equals(licenceNumber)) {
          return garageTicket;
        }
      }
    }
    return null;
  }
}
