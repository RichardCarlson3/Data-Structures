//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
/*
 * Copyright 2025 Tim Richards.
 * 
 * This file is provided to students. Do not modify.
 * 
 * The actual "broken" implementation will be replaced by the autograder.
 */
package analyzer;

import java.util.Arrays;

public class FaultyCampusAnalyzer {

  /**
   * Finds the building with the shortest name from an array of building names.
   *
   * @param buildings an array of building names
   * @return the name of the building with the shortest name, or an empty string
   *         if the input array is null or empty
   */
  public static String findShortestName(String[] buildings) {
    if (buildings == null || buildings.length == 0) {
      return "";
    }

    String shortest = buildings[0];
    for (int i = 1; i < buildings.length; i++) {
      if (buildings[i].length() < shortest.length()) {
        shortest = buildings[i];
      }
    }
    return shortest;
  }

  /**
   * Finds the median distance from an array of distances.
   *
   * @param distances an array of double values representing distances
   * @return the median distance from the array
   * @throws IllegalArgumentException if the distances array is null or empty
   */
  public static double findMedianDistance(double[] distances) {
    if (distances == null || distances.length == 0) {
      throw new IllegalArgumentException("Distance array cannot be empty.");
    }

    double[] sorted = Arrays.copyOf(distances, distances.length);
    Arrays.sort(sorted);
    int mid = sorted.length / 2;

    if (sorted.length % 2 == 0) {
      return (sorted[mid - 1] + sorted[mid]) / 2.0;
    } else {
      return sorted[mid];
    }
  }
  
  /**
   * Checks if any bus in the given array is full.
   *
   * @param buses an array of Bus objects to be checked
   * @return {@code true} if any bus in the array has reached its maximum
   *         capacity, {@code false} otherwise. If the array is null or empty,
   *         returns {@code false}.
   */
  public static boolean isAnyBusFull(Bus[] buses) {
    if (buses == null || buses.length == 0) {
        return false;
    }

    for (Bus bus : buses) {
        if (bus.getCurrentPassengers() == bus.getMaxCapacity()) {
            return true;
        }
    }
    return false;
  }
  
  /**
   * Counts the number of buses that are underloaded, i.e., have fewer
   * passengers than half of their maximum capacity.
   *
   * @param buses an array of Bus objects to be analyzed
   * @return the number of underloaded buses, or 0 if the input array is null or
   *         empty
   */
  public static int countUnderloadedBuses(Bus[] buses) {
    if (buses == null || buses.length == 0) {
      return 0;
    }

    int count = 0;
    for (Bus bus : buses) {
      if (bus.getCurrentPassengers() < (bus.getMaxCapacity() / 2.0)) {
        count++;
      }
    }
    return count;
  }
}