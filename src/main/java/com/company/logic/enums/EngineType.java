package com.company.logic.enums;

public enum EngineType {
  ELECTRIC,
  FUEL;
  
  public static EngineType getByType(String engineType){
    for (EngineType type : EngineType.values()) {
      if (type.toString().equals(engineType)){
        return type;
      }
    }
    return null;
  }
}
