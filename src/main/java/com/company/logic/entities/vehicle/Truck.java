package com.company.logic.entities.vehicle;

import com.company.logic.entities.engine.IEngine;
import com.company.logic.entities.wheels.Wheel;
import com.company.logic.entities.wheels.WheelInflater;
import java.util.Set;

public class Truck extends Vehicle {
  private boolean hasHazardousMaterials;
  private float maxCarryingWeight;
  
  public Truck(IEngine engine,
               String model,
               String licenceNumber,
               Set<Wheel> wheels) {
    super(engine, model, licenceNumber, wheels);
  }
  
  public boolean isHasHazardousMaterials() {
    return hasHazardousMaterials;
  }
  
  public void setHasHazardousMaterials(boolean hasHazardousMaterials) {
    this.hasHazardousMaterials = hasHazardousMaterials;
  }
  
  public float getMaxCarryingWeight() {
    return maxCarryingWeight;
  }
  
  public void setMaxCarryingWeight(float maxCarryingWeight) {
    this.maxCarryingWeight = maxCarryingWeight;
  }
}
