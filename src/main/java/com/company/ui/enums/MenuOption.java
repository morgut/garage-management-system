package com.company.ui.enums;

import com.company.ui.entities.UILogic;

public enum MenuOption {
  
  ADD_VEHICLE(1) {
    @Override
    public void execute(UILogic logic) {
      System.out.println("You chose to add a new vehicle");
      logic.addNewVehicle();
    }
  },
  
  DISPLAY_LICENSE_NUMBERS(2) {
    @Override
    public void execute(UILogic logic) {
      System.out.println("You chose to display all vehicles' license numbers");
      logic.displayLicenseNumbers();
    }
  },
  
  UPDATE_VEHICLE_STATUS(3) {
    @Override
    public void execute(UILogic logic) {
      System.out.println("You chose to update the vehicle's status");
      logic.updateVehicleState();
    }
  },
  
  INFLATE_WHEEL(4) {
    @Override
    public void execute(UILogic logic) {
      System.out.println("You chose to inflate a wheel");
      logic.inflateWheel();
    }
  },
  
  FUEL_VEHICLE(5) {
    @Override
    public void execute(UILogic logic) {
      System.out.println("You chose to fuel a vehicle");
      logic.fuelVehicle();
    }
  },
  
  CHARGE_VEHICLE(6) {
    @Override
    public void execute(UILogic logic) {
      System.out.println("You chose to charge a vehicle");
      logic.chargeVehicle();
    }
  },
  
  UPDATE_VEHICLES_DETAILS(7) {
    @Override
    public void execute(UILogic logic) {
      System.out.println("You chose to update vehicles details");
      logic.displayVehiclesDetails();
    }
  },
  
  EXIT(8) {
    @Override
    public void execute(UILogic logic) {
      System.out.println("You chose to exit. See you next time. Bye Bye");
    }
  };
  
  
  private int option;
  
  public abstract void execute(UILogic logic);
  
  public static String getOptionKey(int option) {
    for (MenuOption menuOption : MenuOption.values()) {
      if (menuOption.getOption() == option){
        return menuOption.toString();
      }
    }
    return null;
  }
  
  public int getOption()
  {
    return option;
  }
  
  private MenuOption(int option)
  {
    this.option = option;
  }
}
