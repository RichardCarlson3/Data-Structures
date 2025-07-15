//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
/*
 * Copyright 2025 Tim Richards.
 */
package analyzer;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class CampusAnalyzerTest {

  // SECTION: 🚌 Bus Class
  
  @Test
  public void testBusConstructorAndGetters() {
    Bus bus = new Bus(34, "Campus Shuttle", 50, 60);
    assertEquals("Bus number is incorrect.", 34, bus.getBusNumber());
    assertEquals("Route name is incorrect.", "Campus Shuttle", bus.getRouteName());
    assertEquals("Current passenger count is incorrect.", 50, bus.getCurrentPassengers());
    assertEquals("Max capacity is incorrect.", 60, bus.getMaxCapacity());
  }

  @Test
  public void testBusToString() {
    Bus bus = new Bus(35, "Northbound Express", 75, 80);
    assertEquals("toString() output does not match expected format.",
        "Bus 35 (Northbound Express) - Passengers: 75, Max Capacity: 80",
        bus.toString());
  }

  @Test
  public void testBusEqualsMethod() {
    Bus bus1 = new Bus(35, "Northbound Express", 75, 80);
    Bus bus2 = new Bus(35, "Northbound Express", 75, 80);
    assertTrue("equals() method should return true for equal bus objects.", bus1.equals(bus2));
  }

  @Test
  public void testBusEqualsMethodFalse() {
    Bus bus1 = new Bus(35, "Northbound Express", 75, 80);
    Bus bus2 = new Bus(36, "Southbound Express", 75, 80);
    assertFalse("equals() method should return false for non-equal bus objects.", bus1.equals(bus2));
  }

  @Test
  public void testBusEqualsMethodFalse2() {
    Bus bus1 = new Bus(35, "Northbound Express", 75, 80);
    assertFalse("equals() method should return false for non-bus object.", bus1.equals("Hello"));
  }

  @Test
  public void testBusEqualsMethodFalse3() {
    Bus bus1 = new Bus(35, "Northbound Express", 75, 80);
    assertFalse("equals() method should return false for null bus objects.", bus1.equals(null));
  }

  // SECTION: 🏛 CampusAnalyzer - Building Analysis

  @Test
  public void testFindLongestName() {
    String[] buildings = { "Library", "Engineering Lab", "Dorm" };
    assertEquals("findLongestName() did not return the longest building name.",
        "Engineering Lab", CampusAnalyzer.findLongestName(buildings));
  }

  @Test
  public void testReverseNames() {
    String[] buildings = { "Library", "Union" };
    String[] expected = { "yrarbiL", "noinU" };
    assertArrayEquals("reverseNames() did not correctly reverse names.", expected,
        CampusAnalyzer.reverseNames(buildings));
  }

  @Test
  public void testCountLetters() {
    String[] buildings = { "Library", "Union" };
    int[] expected = new int[26];
    expected['l' - 'a'] = 1;
    expected['i' - 'a'] = 2;
    expected['b' - 'a'] = 1;
    expected['r' - 'a'] = 2;
    expected['a' - 'a'] = 1;
    expected['y' - 'a'] = 1;
    expected['u' - 'a'] = 1;
    expected['n' - 'a'] = 2;
    expected['o' - 'a'] = 1;

    assertArrayEquals("countLetters() did not correctly count letter occurrences.", expected,
        CampusAnalyzer.countLetters(buildings));
  }

  // SECTION: 📏 CampusAnalyzer - Distance Analysis

  @Test
  public void testFindMinDistance() {
    double[] distances = { 2.4, 0.5, 1.0 };
    assertEquals("findMinDistance() did not return the correct minimum distance.",
        0.5, CampusAnalyzer.findMinDistance(distances), 0.001);
  }

  @Test
  public void testFindMaxDistance() {
    double[] distances = { 2.4, 0.5, 1.0 };
    assertEquals("findMaxDistance() did not return the correct maximum distance.",
        2.4, CampusAnalyzer.findMaxDistance(distances), 0.001);
  }

  @Test
  public void testFindAverageDistance() {
    double[] distances = { 1.0, 2.0, 3.0 };
    assertEquals("findAverageDistance() did not return the correct average distance.",
        2.0, CampusAnalyzer.findAverageDistance(distances), 0.001);
  }

  @Test
  public void testSortDistances() {
    double[] distances = { 2.4, 0.5, 1.0 };
    double[] expected = { 0.5, 1.0, 2.4 };
    CampusAnalyzer.sortDistances(distances);
    assertArrayEquals("sortDistances() did not sort the distances correctly.", expected, distances, 0.001);
  }

  // SECTION: 🚍 CampusAnalyzer - Bus Analysis

  @Test
  public void testFindMostCrowdedBus() {
    Bus[] buses = {
        new Bus(10, "Route A", 30, 50),
        new Bus(20, "Route B", 45, 60),
        new Bus(30, "Route C", 25, 40)
    };
    Bus expected = buses[1];
    assertEquals("findMostCrowdedBus() did not return the correct bus.",
        expected, CampusAnalyzer.findMostCrowdedBus(buses));
  }

  @Test
  public void testFindOverloadedBuses() {
    Bus[] buses = {
        new Bus(1, "Route A", 30, 50),
        new Bus(2, "Route B", 65, 60),
        new Bus(3, "Route C", 70, 70)
    };
    Bus[] expected = { buses[1] };
    assertArrayEquals("findOverloadedBuses() did not return the correct array of overloaded buses.", expected,
        CampusAnalyzer.findOverloadedBuses(buses));
  }

  @Test
  public void testSortBusesByPassengers() {
    Bus[] buses = {
        new Bus(1, "Route A", 40, 50),
        new Bus(2, "Route B", 20, 60),
        new Bus(3, "Route C", 60, 70)
    };
    Bus[] expected = {
        new Bus(2, "Route B", 20, 60),
        new Bus(1, "Route A", 40, 50),
        new Bus(3, "Route C", 60, 70)
    };
    CampusAnalyzer.sortBusesByPassengers(buses);
    assertTrue("It appears that the Bus objects haven't been initialized properly.", buses[0].getRouteName() != null);

    assertEquals("Bus at index 0 is incorrect.", expected[0].toString(), buses[0].toString());
    assertEquals("Bus at index 1 is incorrect.", expected[1].toString(), buses[1].toString());
    assertEquals("Bus at index 2 is incorrect.", expected[2].toString(), buses[2].toString());
  }
}