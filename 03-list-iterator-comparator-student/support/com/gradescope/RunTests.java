/*
 * Copyright 2023 Marc Liberatore.
 */

package com.gradescope;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import com.gradescope.jh61b.grader.GradedTestListenerJSON;

import comparators.ComparatorsTest;
import lists.ArrayListTest;
import lists.LinkedListTest;
import lists.ListTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ArrayListTest.class,
    LinkedListTest.class,
    ListTest.class,
    ComparatorsTest.class,
})

public class RunTests {
  public static void main(String[] args) {
    JUnitCore runner = new JUnitCore();
    runner.addListener(new GradedTestListenerJSON());

    Result r = runner.run(RunTests.class);
  }
}
