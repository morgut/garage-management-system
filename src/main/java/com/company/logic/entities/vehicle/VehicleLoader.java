package com.company.logic.entities.vehicle;

import com.company.logic.entities.engine.IEngine;

public class VehicleLoader {
  
  public void load(float suggestedAmountToAdd, IEngine engine) {
    float totalSuggestedAmountToAdd = engine.getCurrentAmount() + suggestedAmountToAdd;
    float amountToAdd =
      isNotExceededTheMaximumTime(totalSuggestedAmountToAdd, engine) ?
          totalSuggestedAmountToAdd : engine.getCurrentAmount();
    updateCurrent(amountToAdd, engine);
  }
  
  private boolean isNotExceededTheMaximumTime(float suggestedAmountToAdd, IEngine engine) {
    return suggestedAmountToAdd <= engine.getMaxAmount();
  }
  
  private void updateCurrent(float amountToAdd, IEngine engine) {
    engine.setCurrentAmount(amountToAdd);
  }
}
