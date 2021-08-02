package com.company.logic.factories;

import com.company.logic.entities.engine.ElectricEngine;
import com.company.logic.entities.engine.FuelEngine;
import com.company.logic.entities.engine.IEngine;
import com.company.logic.entities.vehicle.Car;
import com.company.logic.entities.vehicle.Motorcycle;
import com.company.logic.entities.vehicle.Truck;
import com.company.logic.entities.vehicle.Vehicle;
import com.company.logic.entities.vehicle.VehicleLoader;
import com.company.logic.entities.wheels.Wheel;
import com.company.logic.entities.wheels.WheelInflater;
import com.company.logic.enums.EngineType;
import com.company.logic.enums.FuelType;
import com.company.logic.enums.VehicleType;
import java.util.HashSet;
import java.util.Set;

public abstract class VehicleFactory {
 
 public Vehicle createVehicle(EngineType engineType, VehicleType type,
                              String model,
                              String licenceNumber) {
  switch (engineType) {
   case ELECTRIC:
    return createElectricVehicle(type, model, licenceNumber);
   case FUEL:
    return createFuelVehicle(type, model, licenceNumber);
   default:
    throw new IllegalArgumentException("Invalid engineType: "
        + engineType);
  }
 }


  private Vehicle createElectricVehicle(
      VehicleType type, String model, String licenceNumber){
  float maxBatteryTime;
  float maxAirPressure;
  int numberOfWheels;
  IEngine engine = null;
  Set<Wheel> wheels = null;

  switch(type) {
   case CAR:
    maxBatteryTime = 2.8f;
    maxAirPressure = 32f;
    numberOfWheels = 4;
    engine = new ElectricEngine(maxBatteryTime, new VehicleLoader());
    wheels = createWheels(numberOfWheels, maxAirPressure);
    return new Car(engine, model, licenceNumber, wheels);

   case MOTORCYCLE:
    maxBatteryTime = 1.6f;
    maxAirPressure = 28f;
    numberOfWheels = 2;
    engine = new ElectricEngine(maxBatteryTime, new VehicleLoader());
    wheels = createWheels(numberOfWheels, maxAirPressure);
    return new Motorcycle(engine, model, licenceNumber, wheels);

   default:
    throw new IllegalArgumentException("Invalid fueled vehicle type: "
        + type);
  }
 }

  private Vehicle createFuelVehicle(VehicleType type, String model, String licenceNumber){
  float maxFuelAmount;
  float maxAirPressure;
  int numberOfWheels;
  IEngine engine = null;
  Set<Wheel> wheels = null;

  switch(type) {
   case CAR:
    maxFuelAmount = 50f;
    maxAirPressure = 32f;
    numberOfWheels = 4;
    engine = new FuelEngine(FuelType.OCTAN_98, maxFuelAmount, new VehicleLoader());
    wheels = createWheels(numberOfWheels, maxAirPressure);
    return new Car(engine, model, licenceNumber, wheels);

   case MOTORCYCLE:
    maxFuelAmount = 5.5f;
    maxAirPressure = 28f;
    numberOfWheels = 2;
    engine = new FuelEngine(FuelType.OCTAN_95, maxFuelAmount, new VehicleLoader());
    wheels = createWheels(numberOfWheels, maxAirPressure);
    return new Motorcycle(engine, model, licenceNumber, wheels);

   case TRUCK:
    maxFuelAmount = 130f;
    maxAirPressure = 34f;
    numberOfWheels = 12;
    engine = new FuelEngine(FuelType.SOLER, maxFuelAmount, new VehicleLoader());
    wheels = createWheels(numberOfWheels, maxAirPressure);
    return new Truck(engine, model, licenceNumber, wheels);

   default:
    throw new IllegalArgumentException("Invalid fueled vehicle type: "
        + type);
  }
 }

 private Wheel createWheel(float maxAirPressure, WheelInflater wheelInflater) {
  return new Wheel(maxAirPressure, wheelInflater);
 }

 private Set<Wheel> createWheels(int numberOfWheels,
                                 float maxAirPressure) {
  Set<Wheel> wheels = new HashSet<Wheel>();
  for(int index = 1; index <= numberOfWheels; index++) {
   wheels.add(new Wheel(maxAirPressure, new WheelInflater()));
  }
  return wheels;
 }
}
