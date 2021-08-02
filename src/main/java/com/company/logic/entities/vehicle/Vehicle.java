package com.company.logic.entities.vehicle;

import com.company.logic.entities.engine.IEngine;
import com.company.logic.entities.wheels.Wheel;
import com.company.logic.entities.wheels.WheelInflater;
import java.util.Set;

public abstract class Vehicle {
  private IEngine engine;
  private String model;
  private String licenceNumber;
  private float energyPercentageLeft;
  private Set<Wheel> wheels;
  
  
//  public Vehicle(IEngine engine, String licenceNumber, ) {
//    this.engine = engine;
//    this.licenceNumber = licenceNumber;
//  }
  
  public Vehicle(IEngine engine, String model, String licenceNumber,
                 Set<Wheel> wheels) {
    this.engine = engine;
    this.model = model;
    this.licenceNumber = licenceNumber;
    this.wheels = wheels;
  }
  
  public IEngine getEngine() {
    return engine;
  }
  
  public void setEngine(IEngine engine) {
    this.engine = engine;
  }
  
  public String getModel() {
    return model;
  }
  
  public void setModel(String model) {
    this.model = model;
  }
  
  public String getLicenceNumber() {
    return licenceNumber;
  }
  
  public void setLicenceNumber(String licenceNumber) {
    this.licenceNumber = licenceNumber;
  }
  
  public float getEnergyPercentageLeft() {
    return energyPercentageLeft;
  }
  
  public void setEnergyPercentageLeft(float energyPercentageLeft) {
    this.energyPercentageLeft = energyPercentageLeft;
  }
  
  public Set<Wheel> getWheels() {
    return wheels;
  }
  
  public void setWheels(Set<Wheel> wheels) {
    this.wheels = wheels;
  }
  
  public void inflateWheelsToMaximum() {
    for(Wheel wheel : wheels) {
      wheel.inflate(wheel.getMaxAirPressure());
    }
  }
}
