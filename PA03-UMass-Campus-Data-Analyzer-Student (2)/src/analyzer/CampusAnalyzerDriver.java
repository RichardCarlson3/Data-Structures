//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
/*
 * Copyright 2025 Tim Richards.
 */
package analyzer;

import java.util.Arrays;

/**
 * Driver class to test and demonstrate all CampusAnalyzer methods.
 */
public class CampusAnalyzerDriver {
  public static void main(String[] args) {
    // Sample data
    String[] buildings = { "Library", "Engineering Lab", "Dormitory" };
    double[] distances = { 0.5, 2.4, 1.0 };
    Bus[] buses = {
        new Bus(34, "Campus Shuttle Northbound", 50, 60),
        new Bus(35, "Campus Shuttle Southbound", 75, 70),
        new Bus(31, "Sunderland/South Amherst", 40, 50)
    };

    // Part 1: Building Analysis
    System.out.println("=== Building Name Analysis ===");
    System.out.println("Longest Building Name: " + CampusAnalyzer.findLongestName(buildings));

    String[] reversedNames = CampusAnalyzer.reverseNames(buildings);
    System.out.println("Reversed Names: " + Arrays.toString(reversedNames));

    int[] letterCounts = CampusAnalyzer.countLetters(buildings);
    System.out.println("Letter Frequencies: ");
    printLetterFrequencies(letterCounts);

    // Part 2: Distance Analysis
    System.out.println("\n=== Distance Analysis ===");
    System.out.println("Closest Building Distance: " + CampusAnalyzer.findMinDistance(distances));
    System.out.println("Farthest Building Distance: " + CampusAnalyzer.findMaxDistance(distances));
    System.out.println("Average Distance: " + CampusAnalyzer.findAverageDistance(distances));

    System.out.println("Distances Before Sorting: " + Arrays.toString(distances));
    CampusAnalyzer.sortDistances(distances);
    System.out.println("Sorted Distances: " + Arrays.toString(distances));

    // Part 3: Bus Analysis
    System.out.println("\n=== Bus Analysis ===");
    System.out.println("Most Crowded Bus: " + CampusAnalyzer.findMostCrowdedBus(buses));

    Bus[] overloadedBuses = CampusAnalyzer.findOverloadedBuses(buses);
    System.out.println("Overloaded Buses: " + Arrays.toString(overloadedBuses));

    System.out.println("Buses Before Sorting: " + Arrays.toString(buses));
    CampusAnalyzer.sortBusesByPassengers(buses);
    System.out.println("Buses Sorted by Passenger Count: " + Arrays.toString(buses));
  }

  /**
   * Prints letter frequencies in a readable format.
   * 
   * @param frequencies An array where index 0 represents 'a', index 1 represents
   *                    'b', ..., index 25 represents 'z'.
   */
  private static void printLetterFrequencies(int[] frequencies) {
    for (int i = 0; i < frequencies.length; i++) {
      if (frequencies[i] > 0) {
        System.out.println((char) (i + 'a') + ": " + frequencies[i]);
      }
    }
  }
}