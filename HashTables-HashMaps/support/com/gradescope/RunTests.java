/*
 * Copyright 2021 Marc Liberatore.
 */

package com.gradescope;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import com.gradescope.jh61b.grader.GradedTestListenerJSON;

import hashmaps.SimpleHashMapTest;
import hashtables.ChainingHashTableTest;;


@RunWith(Suite.class)
@Suite.SuiteClasses({
		ChainingHashTableTest.class,
		SimpleHashMapTest.class
	})

public class RunTests {
	public static void main(String[] args) {
		JUnitCore runner = new JUnitCore();
		runner.addListener(new GradedTestListenerJSON());

		Result rr = runner.run(RunTests.class);
	}
}
