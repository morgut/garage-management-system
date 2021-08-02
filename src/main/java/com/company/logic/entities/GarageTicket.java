package com.company.logic.entities;

import com.company.logic.entities.vehicle.Vehicle;
import com.company.logic.enums.VehicleGarageState;

public class GarageTicket {
  private String ownerName;
  private String phoneNumber;
  private VehicleGarageState state;
  private Vehicle vehicle;
  
  public GarageTicket(String ownerName, String phoneNumber, Vehicle vehicle) {
    this.ownerName = ownerName;
    this.phoneNumber = phoneNumber;
    this.vehicle = vehicle;
    setState(VehicleGarageState.IN_REPAIR);
  }
  
  public void setState(VehicleGarageState state) {
    this.state = state;
  }
  
  public String getOwnerName() {
    return ownerName;
  }
  
  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }
  
  public String getPhoneNumber() {
    return phoneNumber;
  }
  
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  public VehicleGarageState getState() {
    return state;
  }
  
  public Vehicle getVehicle() {
    return vehicle;
  }
  
  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }
}
