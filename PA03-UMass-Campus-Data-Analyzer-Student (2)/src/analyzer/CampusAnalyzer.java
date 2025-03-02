//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
/*
 * Copyright 2025 Tim Richards.
 */
package analyzer;

/**
 * UMass Campus Data Analyzer
 * This program analyzes campus building names, distances, and bus data.
 * 
 * Students will complete the TODO sections.
 */
public class CampusAnalyzer {

  /**
   * Finds the longest building name in the array.
   * 
   * @param buildings An array of building names.
   * @return The longest building name.
   */
  public static String findLongestName(String[] buildings) {
    // TODO: Implement a loop to find the longest building name.
    if (buildings.length == 0)
      return null;
    if (buildings.length == 1)
      return buildings[0];
    String longestName = buildings[0];
    for (int i = 1; i < buildings.length; i++) {
      if (buildings[i].length() > longestName.length()) {
        longestName = buildings[i];
      }
    }
    return longestName;
  }

  /**
   * Reverses each building name and stores them in a new array.
   * 
   * @param buildings An array of building names.
   * @return A new array containing reversed names.
   */
  public static String[] reverseNames(String[] buildings) {
    // TODO: Loop through each name, reverse it, and store it in a new array.
    String reverseBuildingsNames[] = new String[buildings.length];
    int buildingArrayLength = buildings.length;

    for (int i = 0; i < buildingArrayLength; i++) {
      int nameLength = buildings[i].length();
      String buildingName = buildings[i];
      String reversedName = "";

      for (int j = nameLength - 1; j >= 0; j--) {
        reversedName = reversedName + buildingName.charAt(j);
        if (j == 0) {
          reverseBuildingsNames[i] = reversedName;
        }
      }

    }
    return reverseBuildingsNames;
  }

  /**
   * Counts how often each letter (A-Z) appears across all building names.
   * 
   * @param buildings An array of building names.
   * @return An array of 26 integers, each representing letter frequency.
   */
  public static int[] countLetters(String[] buildings) {
    // TODO: Iterate over each name and count occurrences of each letter.
    String currentBuilding = "";
    int currentBuildingLength = 0;
    int numOfLetters[] = new int[26];
    int numOfBuildings = buildings.length;
    char currentLetter = '!';
    char currentChar = '!';

    for (int i = 0; i < numOfBuildings; i++) {
      currentBuilding = buildings[i];
      currentBuilding = currentBuilding.toLowerCase();
      currentBuildingLength = currentBuilding.length();

      for (int a = 0; a < currentBuildingLength; a++) {
        currentChar = currentBuilding.charAt(a);

        for (int j = 122; j >= 97; j--) {
          currentLetter = (char) j;
          if (currentChar == currentLetter) {
            numOfLetters[j - 97] = numOfLetters[j - 97] + 1;
          }
        }
      }
    }
    return numOfLetters;
  }

  /**
   * Finds the closest building (smallest distance).
   * 
   * @param distances An array of distances from the Campus Center.
   * @return The smallest distance value.
   */
  public static double findMinDistance(double[] distances) {
    // TODO: Implement a loop to find the smallest distance.
    if (distances.length == 0) {
      return 0;
    }
    double minDistance = distances[0];
    for (int i = 0; i < distances.length; i++) {
      minDistance = Math.min(minDistance, distances[i]);
    }

    return minDistance;
  }

  /**
   * Finds the farthest building (largest distance).
   * 
   * @param distances An array of distances from the Campus Center.
   * @return The largest distance value.
   */
  public static double findMaxDistance(double[] distances) {
    // TODO: Implement a loop to find the largest distance.
    if (distances.length == 0) {
      return 0;
    }
    double maxDistance = distances[0];
    for (int i = 0; i < distances.length; i++) {
      maxDistance = Math.max(maxDistance, distances[i]);
    }

    return maxDistance;
  }

  /**
   * Computes the average distance.
   * 
   * @param distances An array of distances from the Campus Center.
   * @return The average distance.
   */
  public static double findAverageDistance(double[] distances) {
    // TODO: Compute the sum of distances and divide by the count.
    double sum = 0;
    for (double i : distances) {
      sum += i;
    }
    return sum / distances.length;
  }

  /**
   * Sorts an array of distances using Bubble Sort.
   * 
   * @param distances The array to be sorted.
   */
  public static void sortDistances(double[] distances) {
    // TODO: Implement Bubble Sort to sort distances in ascending order.
    double filler = 0;
    boolean swapped;
    for (int i = 0; i < distances.length - 1; i++) {
      swapped = false;
      for (int j = 0; j < distances.length - 1; j++) {
        if (distances[j] > distances[j + 1]) {
          filler = distances[j];
          distances[j] = distances[j + 1];
          distances[j + 1] = filler;
          swapped = true;
        }
      }
      if (!swapped)
        break;
    }
  }

  /**
   * Finds the most crowded bus.
   * 
   * @param buses An array of Bus objects.
   * @return The bus with the highest passenger count.
   */
  public static Bus findMostCrowdedBus(Bus[] buses) {
    // TODO: Implement a loop to find the bus with the most passengers.
    if (buses.length == 0) {
      return null;
    }
    Bus mostCrowdedBus = buses[0];
    Bus comparingBus;
    for (int i = 1; i < buses.length; i++) {
      comparingBus = buses[i];
      if (mostCrowdedBus.getCurrentPassengers() < comparingBus.getCurrentPassengers()) {
        mostCrowdedBus = buses[i];
      }
    }
    return mostCrowdedBus;
  }

  /**
   * Finds buses that are overloaded.
   * 
   * @param buses An array of Bus objects.
   * @return An array of overloaded buses.
   */
  public static Bus[] findOverloadedBuses(Bus[] buses) {
    // TODO: Identify buses where currentPassengers > maxCapacity.
    Bus[] overLoadedBuses = new Bus[buses.length];
    int length = 0;
    for (int i = 0; i < buses.length; i++) {
      if (buses[i].getCurrentPassengers() > buses[i].getMaxCapacity()) {
        overLoadedBuses[length] = buses[i];
        length++;
      }
    }
    Bus[] overLoadedBusesCopy = new Bus[length];
    for (int i = 0; i < length; i++) {
      overLoadedBusesCopy[i] = overLoadedBuses[i];
    }

    return overLoadedBusesCopy;
  }

  /**
   * Sorts buses by passenger count using Bubble Sort.
   * 
   * @param buses The array to be sorted.
   */
  public static void sortBusesByPassengers(Bus[] buses) {
    // TODO: Implement Bubble Sort to sort buses by passengers.
    Bus filler;
    boolean swapped;
    for (int i = 0; i < buses.length - 1; i++) {
      swapped = false;
      for (int j = 0; j < buses.length - 1; j++) {
        if (buses[j].getCurrentPassengers() > buses[j + 1].getCurrentPassengers()) {
          filler = buses[j];
          buses[j] = buses[j + 1];
          buses[j + 1] = filler;
          swapped = true;
        }
      }
      if (!swapped)
        break;
    }
  }
}
