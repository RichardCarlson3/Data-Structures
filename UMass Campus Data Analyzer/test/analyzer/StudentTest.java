//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
package analyzer;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test class for FaultyCampusAnalyzer.
 * 
 * Students must complete the TODO sections by writing
 * appropriate test cases.
 */
public class StudentTest {

  /**
   * Test findShortestName() method.
   */
  @Test
  public void testFindShortestName() {

    // TODO: implement tests to check the correctness of the method.
    // METHOD: FaultyCampusAnalyzer.findShortestName(String[] buildings)
    String building1[] = {
        "Leach", "Mary Lyon"
    };
    String building2[] = {};
    String building3[] = { "Leach" };
    String building4[] = { "Leach", "Leach" };
    String building5[] = { "Mary LYon", "HAMLIN", "Leach", "Leach", };
    String building6[] = { "M" };
    String leach = "Leach";
    assertEquals(leach, FaultyCampusAnalyzer.findShortestName(building1));
    assertEquals("", FaultyCampusAnalyzer.findShortestName(building2));
    assertEquals(leach, FaultyCampusAnalyzer.findShortestName(building3));
    assertEquals(leach, FaultyCampusAnalyzer.findShortestName(building4));
    assertEquals(leach, FaultyCampusAnalyzer.findShortestName(building5));
    assertEquals("M", FaultyCampusAnalyzer.findShortestName(building6));
  }

  /**
   * Test findMedianDistance() method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testFindMedianDistance() {

    // TODO: implement tests to check the correctness of the method.
    // METHOD: FaultyCampusAnalyzer.findMedianDistance(double[] distances)

    double distance2[] = { 10.0, 0.0, 5.0 };
    double distance3[] = { -5.0, -6.0, 2.0, 4.0 };
    double distance4[] = { 5.0 };
    double distance1[] = {};

    assertEquals(5.0, FaultyCampusAnalyzer.findMedianDistance(distance2), 0.0001);
    assertEquals(-1.5, FaultyCampusAnalyzer.findMedianDistance(distance3), 0.0001);
    assertEquals(5.0, FaultyCampusAnalyzer.findMedianDistance(distance4), 0.0001);
    assertEquals(IllegalArgumentException.class, FaultyCampusAnalyzer.findMedianDistance(distance1));
  }

  /**
   * Test isAnyBusFull() method.
   */
  @Test
  public void testIsAnyBusFull() {
    // TODO: implement tests to check the correctness of the method.
    // METHOD: FaultyCampusAnalyzer.isAnyBusFull(Bus[] buses)
    Bus buses1[] = {};
    Bus buses2[] = {
        new Bus(10, "Route A", 30, 50),
        new Bus(20, "Route B", 45, 60),
        new Bus(30, "Route C", 25, 40)
    };
    Bus buses3[] = {
        new Bus(10, "Route A", 30, 50),
        new Bus(10, "Route A", 40, 40),
        new Bus(20, "Route B", 1, 1),
        new Bus(30, "Route C", 25, 30)
    };
    Bus buses4[] = {
        new Bus(10, "Route A", 40, 40),
    };
    Bus buses5[] = {
        new Bus(10, "Route A", 50, 40),
        new Bus(20, "Route B", 1, 2),
        new Bus(30, "Route C", 25, 30)
    };

    assertEquals(false, FaultyCampusAnalyzer.isAnyBusFull(buses1));
    assertEquals(false, FaultyCampusAnalyzer.isAnyBusFull(buses2));
    assertEquals(true, FaultyCampusAnalyzer.isAnyBusFull(buses3));
    assertEquals(true, FaultyCampusAnalyzer.isAnyBusFull(buses4));
    assertEquals(false, FaultyCampusAnalyzer.isAnyBusFull(buses5));
  }

  /**
   * Test countUnderloadedBuses() method.
   */
  @Test
  public void testCountUnderloadedBuses() {

    // TODO: implement tests to check the correctness of the method.
    // METHOD: FaultyCampusAnalyzer.countUnderloadedBuses(Bus[] buses)
    Bus buses1[] = {};
    Bus buses2[] = {
        new Bus(10, "Route A", 30, 50),
        new Bus(20, "Route B", 5, 60),
        new Bus(30, "Route C", 25, 40)
    };
    Bus buses3[] = {
        new Bus(10, "Route A", 25, 50),
        new Bus(10, "Route A", 10, 40),
        new Bus(20, "Route B", 1, 10),
        new Bus(30, "Route C", 25, 30)
    };
    Bus buses4[] = {
        new Bus(10, "Route A", 40, 40),
    };
    Bus buses5[] = {
        new Bus(10, "Route A", 50, 40),
        new Bus(20, "Route B", 1, 2),
        new Bus(30, "Route C", 25, 30)
    };
    Bus buses6[] = {
        new Bus(10, "Route A", 10, 40),
    };
    Bus buses7[] = {
        new Bus(10, "Route A", 12, 25),
    };
    Bus buses8[] = {
        new Bus(10, "Route A", 13, 25),
    };

    assertEquals(0, FaultyCampusAnalyzer.countUnderloadedBuses(buses1));
    assertEquals(1, FaultyCampusAnalyzer.countUnderloadedBuses(buses2));
    assertEquals(2, FaultyCampusAnalyzer.countUnderloadedBuses(buses3));
    assertEquals(0, FaultyCampusAnalyzer.countUnderloadedBuses(buses4));
    assertEquals(0, FaultyCampusAnalyzer.countUnderloadedBuses(buses5));
    assertEquals(1, FaultyCampusAnalyzer.countUnderloadedBuses(buses6));
    assertEquals(1, FaultyCampusAnalyzer.countUnderloadedBuses(buses7));
    assertEquals(0, FaultyCampusAnalyzer.countUnderloadedBuses(buses8));
  }
}