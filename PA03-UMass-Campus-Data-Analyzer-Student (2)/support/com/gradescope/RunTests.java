//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
/*
 * Copyright 2025 Tim Richards.
 * Copyright 2021 Marc Liberatore.
 */

package com.gradescope;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import com.gradescope.jh61b.grader.GradedTestListenerJSON;

import analyzer.CampusAnalyzerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CampusAnalyzerTest.class,
})

public class RunTests {
  public static void main(String[] args) {
    JUnitCore runner = new JUnitCore();
    runner.addListener(new GradedTestListenerJSON());

    Result r = runner.run(RunTests.class);
    System.exit(r.getFailureCount());
  }
}