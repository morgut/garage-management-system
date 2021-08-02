package com.company.ui.exceptions;

import com.company.ui.enums.InputValidatorExceptionType;

public class InputValidatorException extends Exception{
  private InputValidatorExceptionType inputValidatorExceptionType;
  private String extraMessage = "";
  
  public InputValidatorException(InputValidatorExceptionType inputValidatorExceptionType) {
    this.inputValidatorExceptionType = inputValidatorExceptionType;
  }
  
  public InputValidatorException(InputValidatorExceptionType inputValidatorExceptionType, String extraMessage) {
    this.inputValidatorExceptionType = inputValidatorExceptionType;
    this.extraMessage = extraMessage;
  }
  
  public InputValidatorExceptionType getInputValidatorExceptionType() {
    return inputValidatorExceptionType;
  }
  
  public String getExtraMessage() {
    return extraMessage;
  }
}
