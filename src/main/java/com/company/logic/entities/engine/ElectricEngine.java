package com.company.logic.entities.engine;

import com.company.logic.entities.vehicle.VehicleLoader;
import com.company.logic.interfaces.ICharge;

public class ElectricEngine implements IEngine, ICharge {
  private float batteryTimeLeft;
  private float maxBatteryTime;
  private VehicleLoader vehicleLoadence;
  
  public ElectricEngine(float maxBatteryTime, VehicleLoader vehicleLoadence) {
    this.batteryTimeLeft = this.maxBatteryTime = maxBatteryTime;
    this.vehicleLoadence = vehicleLoadence;
  }
  
  @Override
  public void chargeBattery(float hoursToAdd) {
    // Separate the behaviour from the class
    // To a much more flexible program
    vehicleLoadence.load(hoursToAdd, this);
  }
  
  @Override
  public void setCurrentAmount(float currentAmount) {
    batteryTimeLeft = currentAmount;
  }
  
  @Override
  public float getCurrentAmount() {
    return batteryTimeLeft;
  }
  
  @Override
  public float getMaxAmount() {
    return maxBatteryTime;
  }
}
