//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
/*
 * Copyright 2025 Tim Richards.
 */
package analyzer;

/**
 * Represents a UMass campus bus.
 */
public class Bus {
  private int busNumber;
  private String routeName;
  private int currentPassengers;
  private int maxCapacity;

  public Bus(int busNumber, String routeName, int currentPassengers, int maxCapacity) {
    // TODO: Implement the constructor.
    this.busNumber = busNumber;
    this.routeName = routeName;
    this.currentPassengers = currentPassengers;
    this.maxCapacity = maxCapacity;

  }

  public int getBusNumber() {
    // TODO: Return the bus number.
    return busNumber;
  }

  public String getRouteName() {
    // TODO: Return the route name.
    return routeName;
  }

  public int getCurrentPassengers() {
    // TODO: Return the current number of passengers.
    return currentPassengers;
  }

  public int getMaxCapacity() {
    // TODO: Return the maximum capacity.
    return maxCapacity;
  }

  // TODO: Implement the equals method.
  public boolean equals(Object obj) {
    // TODO: Implement the equals method.
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Bus busObj = (Bus) obj;
    return this.busNumber == busObj.busNumber && this.currentPassengers == busObj.currentPassengers
        && this.maxCapacity == busObj.maxCapacity && this.routeName.equals(busObj.routeName);
  }

  @Override
  public String toString() {
    // TODO: Return a formatted string representation of the bus.
    // You must return a string that is EXACTLY 1 line long and
    // looks like this (without the double quotes):
    // "Bus 34 (Campus Shuttle Northbound) - Passengers: 50, Max Capacity: 60"
    String stringMaxCapacity = Integer.toString(maxCapacity);
    String stringCurrentPassengers = Integer.toString(currentPassengers);
    String stringBusNumber = Integer.toString(busNumber);
    return "Bus " + stringBusNumber + " (" + routeName + ") - Passengers: " + stringCurrentPassengers
        + ", Max Capacity: " + stringMaxCapacity;
  }
}