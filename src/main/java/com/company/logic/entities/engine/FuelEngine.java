package com.company.logic.entities.engine;

import com.company.logic.enums.FuelType;
import com.company.logic.entities.vehicle.VehicleLoader;
import com.company.logic.interfaces.IRefuel;

public class FuelEngine implements IEngine, IRefuel {
  private FuelType fuelType;
  private float currentFuelAmount;
  private float maxFuelAmount;
  private VehicleLoader vehicleLoadence;
  
  public FuelEngine(FuelType fuelType, float maxFuelAmount,
                     VehicleLoader vehicleLoadence) {
    this.fuelType = fuelType;
    this.currentFuelAmount = this.maxFuelAmount = maxFuelAmount;
    this.vehicleLoadence = vehicleLoadence;
  }
  
  @Override
  public void refuel(float fuelToAdd, FuelType type) {
  // Separate the behaviour from the class
  // To a much more flexible program
    if(fuelType == type) {
      vehicleLoadence.load(fuelToAdd,this);
    }
  }
  
  @Override
  public void setCurrentAmount(float currentAmount) {
    currentFuelAmount = currentAmount;
  }
  
  @Override
  public float getCurrentAmount() {
    return currentFuelAmount;
  }
  
  @Override
  public float getMaxAmount() {
    return maxFuelAmount;
  }
  
  public FuelType getFuelType() {
    return fuelType;
  }
  
}
