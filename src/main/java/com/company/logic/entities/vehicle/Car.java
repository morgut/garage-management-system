package com.company.logic.entities.vehicle;

import com.company.logic.entities.engine.IEngine;
import com.company.logic.entities.wheels.Wheel;
import com.company.logic.entities.wheels.WheelInflater;
import com.company.logic.enums.Color;
import java.util.Set;

public class Car extends Vehicle {
  private Color color;
  private int doorsNumber;
  
  public Car(IEngine engine,
             String model,
             String licenceNumber,
             Set<Wheel> wheels) {
    super(engine, model, licenceNumber, wheels);
  }
  
  public Color getColor() {
    return color;
  }
  
  public void setColor(Color color) {
    this.color = color;
  }
  
  public int getDoorsNumber() {
    return doorsNumber;
  }
  
  public void setDoorsNumber(int doorsNumber) {
    this.doorsNumber = doorsNumber;
  }
}
