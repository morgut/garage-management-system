package com.company.logic.entities.wheels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WheelInflatorTest {
  
  private WheelInflater wheelInflater;
  private Wheel wheel;
  
  // Denotes that the annotated method should be executed before each
  // @Test, @RepeatedTest, @ParameterizedTest, or @TestFactory
  // in the current class
  @BeforeEach
  void setUp() {
    wheelInflater = new WheelInflater();
    wheel = new Wheel(33, wheelInflater);
  }
  
  // Denotes that a method is a test method.
  @Test
  void testInflate_ExceededTheMaximumPressure() {
    wheelInflater.inflate(25, wheel);
    assertEquals(33, wheel.getCurrentAirPressure());
  }
  
  @Test
  void testInflate_NotExceededTheMaximumPressure() {
    wheel.setCurrentAirPressure(15);
    wheelInflater.inflate(5, wheel);
    assertEquals(20, wheel.getCurrentAirPressure());
  }
  
  @Test
  void testInflateToMaximum() {
    wheel.setCurrentAirPressure(15);
    wheelInflater.inflateToMaximum(wheel);
    assertEquals(33, wheel.getCurrentAirPressure());
  }
}