package com.company.ui.validators;

import com.company.logic.enums.EngineType;
import com.company.logic.enums.VehicleGarageState;
import com.company.logic.enums.VehicleType;
import com.company.ui.enums.InputValidatorExceptionType;
import com.company.ui.enums.MenuOption;
import com.company.ui.exceptions.InputValidatorException;

public class InputValidator {

  public static boolean canBeConvertedToInteger(String numberAsString)
      throws InputValidatorException {
    int number;
    try {
      number = Integer.parseInt(numberAsString);
      return true;
    }
    catch(NumberFormatException e) {
      throw new InputValidatorException(InputValidatorExceptionType.STRING_CANNOT_BE_CONVERTED_TO_INTEGER);
    }
  }
  
  public static boolean isNotEmpty(String phoneNumber) throws InputValidatorException {
      if(phoneNumber.isEmpty()) {
        throw new InputValidatorException(InputValidatorExceptionType.INVALID_STRING);
      }
      return true;
    }
  
  public static VehicleGarageState isValidVehicleStateEnumType(String enumType)
      throws InputValidatorException {
    VehicleGarageState state = VehicleGarageState.getByType(enumType);
    if(state == null) {
      throw new InputValidatorException(InputValidatorExceptionType.INVALID_ENUM_TYPE);
    }
    return state;
  }
  
  public static String validateMenuOption(int option) throws InputValidatorException {
    String menuOption = MenuOption.getOptionKey(option);
    if(menuOption == null) {
      throw new InputValidatorException(InputValidatorExceptionType.INVALID_MENU_OPTION);
    }
    return menuOption;
  }
  
  public static VehicleType isValidVehicleType(String enumType) throws InputValidatorException {
    VehicleType vehicleType = VehicleType.getByType(enumType);
    if(vehicleType == null) {
      throw new InputValidatorException(InputValidatorExceptionType.INVALID_ENUM_TYPE);
    }
    return vehicleType;
  }
  
  public static EngineType isValidEngineType(String enumType) throws InputValidatorException {
    EngineType type = EngineType.getByType(enumType);
    if(type == null) {
      throw new InputValidatorException(InputValidatorExceptionType.INVALID_ENUM_TYPE);
    }
    return type;
   }
}
