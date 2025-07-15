//
// Copyright 2024 Tim Richards.
//
package com.gradescope;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountPoints {
  public static void main(String[] args) {
    // Get the current directory
    Path currentDirectory = Paths.get("").toAbsolutePath();
    int totalMaxScore = 0;

    try {
      totalMaxScore = searchDirectoryForGradedTests(currentDirectory.toFile());
    } catch (IOException e) {
      System.err.println("An error occurred while reading the files: " + e.getMessage());
    }

    System.out.println("Total points across all graded tests: " + totalMaxScore);
  }

  // Recursively search the directory for Java files
  private static int searchDirectoryForGradedTests(File dir) throws IOException {
    int sum = 0;

    // List all files and directories in the current directory
    File[] files = dir.listFiles();
    if (files != null) {
      for (File file : files) {
        if (file.isDirectory()) {
          // Recursively search in subdirectories
          sum += searchDirectoryForGradedTests(file);
        } else if (file.isFile() && file.getName().endsWith(".java")) {
          // Process Java files
          sum += processJavaFile(file.toPath());
        }
      }
    }

    return sum;
  }

  // Process each Java file and sum up the max_score values
  private static int processJavaFile(Path javaFilePath) throws IOException {
    int maxScoreSum = 0;

    // Define the pattern to search for @GradedTest annotations with max_score
    Pattern gradedTestPattern = Pattern
        .compile("@GradedTest\\(name\\s*=\\s*\"[^\"]+\",\\s*max_score\\s*=\\s*(\\d+)\\)");

    // Read all lines from the Java file
    List<String> lines = Files.readAllLines(javaFilePath);

    // Check each line against the pattern
    for (String line : lines) {
      Matcher matcher = gradedTestPattern.matcher(line);
      if (matcher.find()) {
        // Extract the max_score value and add it to the sum
        int maxScore = Integer.parseInt(matcher.group(1));
        maxScoreSum += maxScore;
      }
    }

    return maxScoreSum;
  }
}
