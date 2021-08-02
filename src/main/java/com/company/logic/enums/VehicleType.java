package com.company.logic.enums;

public enum VehicleType {
  CAR,
  MOTORCYCLE,
  TRUCK;
  
  public static VehicleType getByType(String vehicleType){
    for (VehicleType type : VehicleType.values()) {
      if (type.toString().equals(vehicleType)){
        return type;
      }
    }
    return null;
  }
}
