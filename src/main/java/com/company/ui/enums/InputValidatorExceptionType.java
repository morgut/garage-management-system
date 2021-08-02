package com.company.ui.enums;

public enum InputValidatorExceptionType {
    STRING_CANNOT_BE_CONVERTED_TO_INTEGER("The value represented by the string is not a value of type int. Please try again."),
    INVALID_STRING("Invalid String. Please try again."),
    INVALID_ENUM_TYPE("Invalid enum type. Please try again."),
    INVALID_MENU_OPTION("Invalid menu option. Please try again");
    
    private String message;
  
  InputValidatorExceptionType(String message){
    this.message = message;
  }
  
  public String getMessage() {
    return message;
  }
}
