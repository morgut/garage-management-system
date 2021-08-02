package com.company.logic.enums;

public enum VehicleGarageState {
  IN_REPAIR,
  FIXED,
  COMPLETED;
  
  public static VehicleGarageState getByType(String vehicleState){
    for (VehicleGarageState state : VehicleGarageState.values()) {
      if (state.toString().equals(vehicleState)){
        return state;
      }
    }
    return null;
  }
}
