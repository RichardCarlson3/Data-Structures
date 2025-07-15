/*
 * Copyright 2023 Marc Liberatore.
 */

package lists;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.gradescope.jh61b.grader.GradedTest;

public class ListTest {
    // @Rule
    // public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds

    @Test
    @GradedTest(name = "testEqualityMany", max_score = 1)
    public void testEqualityMany() {
        List<Integer> a = new ArrayList<>();
        List<Integer> l = new LinkedList<>();

        for (int i = 0; i < 1000; i++) {
            a.add(i);
            l.add(i);
            assertTrue(a.equals(l));
            assertTrue(l.equals(a));
        }
    }

    @Test
    @GradedTest(name = "testEqualityManyWithRemoval", max_score = 1)
    public void testEqualityManyWithRemoval() {
        List<Integer> a = new ArrayList<>();
        List<Integer> l = new LinkedList<>();

        for (int i = 0; i < 1000; i++) {
            a.add(i);
            l.add(i);
            assertTrue(a.equals(l));
            assertTrue(l.equals(a));
        }

        for (int i = 999; i >= 0; i--) {
            a.remove(i);
            l.remove(i);
            assertTrue(a.equals(l));
            assertTrue(l.equals(a));
        }
    }
}
