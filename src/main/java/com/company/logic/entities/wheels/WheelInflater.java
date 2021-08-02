package com.company.logic.entities.wheels;

public class WheelInflater {
  
  void inflate(float suggestedAirPressureToAdd, Wheel wheel) {
    float totalSuggestedAirPressure = wheel.getCurrentAirPressure() + suggestedAirPressureToAdd;
    float airPressureAmountToAdd =
        isNotExceededTheMaximumPressure(totalSuggestedAirPressure, wheel) ?
            totalSuggestedAirPressure : wheel.getCurrentAirPressure();
    updateCurrentAirPressure(airPressureAmountToAdd, wheel);
  }
  
  void inflateToMaximum(Wheel wheel) {
    updateCurrentAirPressure(wheel.getMaxAirPressure(), wheel);
  }
  
  private boolean isNotExceededTheMaximumPressure(float suggestedAirPressureToAdd,
                                                  Wheel wheel) {
    return suggestedAirPressureToAdd <= wheel.getMaxAirPressure();
  }
  
  private void updateCurrentAirPressure(float airPressureAmountToAdd, Wheel wheel) {
    wheel.setCurrentAirPressure(airPressureAmountToAdd);
  }
}
