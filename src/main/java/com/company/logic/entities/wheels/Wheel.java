package com.company.logic.entities.wheels;

import com.company.logic.interfaces.IInflate;

public class Wheel implements IInflate {
  private String manufacturer;
  private float currentAirPressure;
  private float maxAirPressure;
  private WheelInflater wheelInflater;
  
  public Wheel(float maxAirPressure, WheelInflater wheelInflater) {
    this.maxAirPressure = currentAirPressure = maxAirPressure;
    this.wheelInflater = wheelInflater;
  }
  
  @Override
  public void inflate(float airPressureToAdd) {
    wheelInflater.inflate(airPressureToAdd, this);
  }
  
  @Override
  public void inflateToMaximum(float maximumAirPressure) {
    wheelInflater.inflateToMaximum(this);
  }
  
  public String getManufacturer() {
    return manufacturer;
  }
  
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }
  
  float getCurrentAirPressure() {
    return currentAirPressure;
  }
  
  void setCurrentAirPressure(float currentAirPressure) {
    this.currentAirPressure = currentAirPressure;
  }
  
  public float getMaxAirPressure() {
    return maxAirPressure;
  }
  
  public void setMaxAirPressure(float maxAirPressure) {
    this.maxAirPressure = maxAirPressure;
  }
}
