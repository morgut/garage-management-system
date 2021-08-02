package com.company.logic.entities.vehicle;

import com.company.logic.entities.engine.IEngine;
import com.company.logic.entities.wheels.Wheel;
import com.company.logic.entities.wheels.WheelInflater;
import com.company.logic.enums.LicenceType;
import java.util.Set;

public class Motorcycle extends Vehicle {
  private LicenceType type;
  private int engineCapacity;
  
  public Motorcycle(IEngine engine,
                    String model,
                    String licenceNumber,
                    Set<Wheel> wheels) {
    super(engine, model, licenceNumber, wheels);
  }
  
  public LicenceType getType() {
    return type;
  }
  
  public void setType(LicenceType type) {
    this.type = type;
  }
  
  public int getEngineCapacity() {
    return engineCapacity;
  }
  
  public void setEngineCapacity(int engineCapacity) {
    this.engineCapacity = engineCapacity;
  }
}
