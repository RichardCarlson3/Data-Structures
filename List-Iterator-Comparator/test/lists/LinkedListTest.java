/*
 * Copyright 2023 Marc Liberatore.
 */

package lists;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.gradescope.jh61b.grader.GradedTest;

public class LinkedListTest {
    // @Rule
    // public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds

    @Test
    @GradedTest(name = "testLinkedListConstructor", max_score = 1)
    public void testLinkedListConstructor() {
        List<Integer> l = new LinkedList<>();
    }

    @Test
    @GradedTest(name = "testLinkedListEmptyEquals", max_score = 1)
    public void testLinkedListEmptyEquals() {
        List<Integer> l = new LinkedList<>();
        List<Integer> m = new LinkedList<>();
        assertTrue(l.equals(m));
    }

    @Test
    @GradedTest(name = "testLinkedListOneEmptyUnequal", max_score = 1)
    public void testLinkedListOneEmptyUnequal() {
        List<Integer> l = new LinkedList<>();
        List<Integer> m = new LinkedList<>();
        l.add(43);
        assertFalse(l.equals(m));
    }

    @Test
    @GradedTest(name = "testLinkedListOneEqual", max_score = 1)
    public void testLinkedListOneEqual() {
        List<Integer> l = new LinkedList<>();
        List<Integer> m = new LinkedList<>();
        l.add(43);
        m.add(43);
        assertTrue(l.equals(m));
    }

    @Test
    @GradedTest(name = "testLinkedListOneUnequal", max_score = 1)
    public void testLinkedListOneUnequal() {
        List<Integer> l = new LinkedList<>();
        List<Integer> m = new LinkedList<>();
        l.add(43);
        m.add(17);
        assertFalse(l.equals(m));
    }

    @Test
    @GradedTest(name = "testLinkedListThreeEqual", max_score = 1)
    public void testLinkedListThreeEqual() {
        List<String> l = new LinkedList<>();
        List<String> m = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            l.add("testLinkedList" + i);
            m.add("testLinkedList" + i);
            assertTrue(l.equals(m));
        }
    }

    @Test
    @GradedTest(name = "testLinkedListThreeUnequal", max_score = 1)
    public void testLinkedListThreeUnequal() {
        List<String> l = new LinkedList<>();
        List<String> m = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            l.add("testLinkedList" + i);
            m.add("testLinkedList" + i);
            assertTrue(l.equals(m));
        }
        l.add("foo");
        m.add("bar");
        assertFalse(l.equals(m));
    }

    @Test
    @GradedTest(name = "testLinkedListEmptySize", max_score = 1)
    public void testLinkedListEmptySize() {
        List<Integer> l = new LinkedList<>();
        assertEquals(0, l.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @GradedTest(name = "testLinkedListAddLowerBound", max_score = 1)
    public void testLinkedListAddLowerBound() {
        List<Integer> l = new LinkedList<>();
        l.add(78);
        l.add(-1, 77);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @GradedTest(name = "testLinkedListAddEmptyUpperBound", max_score = 1)
    public void testLinkedListAddEmptyUpperBound() {
        List<Integer> l = new LinkedList<>();
        l.add(1, 77);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @GradedTest(name = "testLinkedListAddUpperBound", max_score = 1)
    public void testLinkedListAddUpperBound() {
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            l.add(i);
        }
        l.add(6, 6);
    }

    @Test
    @GradedTest(name = "testLinkedListAddToEmptySize", max_score = 1)
    public void testLinkedListAddToEmptySize() {
        List<Integer> l = new LinkedList<>();
        l.add(42);
        assertEquals(1, l.size());
    }

    @Test
    @GradedTest(name = "testLinkedListAddToEmptyThenGet", max_score = 1)
    public void testLinkedListAddToEmptyThenGet() {
        List<String> l = new LinkedList<>();
        l.add("foo");
        assertEquals("foo", l.get(0));
    }

    @Test
    @GradedTest(name = "testLinkedListAddLots", max_score = 1)
    public void testLinkedListAddLots() {
        List<String> l = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            l.add("testLinkedList" + i);
            assertEquals("testLinkedList" + i, l.get(i));
        }
    }

    @Test
    @GradedTest(name = "testLinkedListAddAtFrontEmpty", max_score = 1)
    public void testLinkedListAddAtFrontEmpty() {
        List<String> l = new LinkedList<>();
        l.add(0, "foo");
        assertEquals("foo", l.get(0));
    }

    @Test
    @GradedTest(name = "testLinkedListAddLotsAtFront", max_score = 1)
    public void testLinkedListAddLotsAtFront() {
        List<String> l = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            l.add(0, "testLinkedList" + i);
            assertEquals("testLinkedList" + i, l.get(0));
        }
    }

    @Test
    @GradedTest(name = "testLinkedListAddThenRemove", max_score = 1)
    public void testLinkedListAddThenRemove() {
        List<String> l = new LinkedList<>();
        l.add("foo");
        assertEquals("foo", l.get(0));
        assertEquals(1, l.size());

        String result = l.remove(0);
        assertEquals("foo", result);
        assertEquals(0, l.size());
    }

    @Test
    @GradedTest(name = "testLinkedListAddThenRemoveTwo", max_score = 1)
    public void testLinkedListAddThenRemoveTwo() {
        List<String> l = new LinkedList<>();
        l.add("foo");
        assertEquals("foo", l.get(0));
        assertEquals(1, l.size());

        l.add("bar");
        assertEquals("foo", l.get(0));
        assertEquals("bar", l.get(1));
        assertEquals(2, l.size());

        String result = l.remove(1);
        assertEquals("bar", result);
        assertEquals(1, l.size());

        result = l.remove(0);
        assertEquals("foo", result);
        assertEquals(0, l.size());
    }

    @Test
    @GradedTest(name = "testLinkedListAddThenRemoveTwoFrontFirst", max_score = 1)
    public void testLinkedListAddThenRemoveTwoFrontFirst() {
        List<String> l = new LinkedList<>();
        l.add("foo");
        assertEquals("foo", l.get(0));
        assertEquals(1, l.size());

        l.add("bar");
        assertEquals("foo", l.get(0));
        assertEquals("bar", l.get(1));
        assertEquals(2, l.size());

        String result = l.remove(0);
        assertEquals("foo", result);
        assertEquals(1, l.size());

        result = l.remove(0);
        assertEquals("bar", result);
        assertEquals(0, l.size());
    }

    @Test
    @GradedTest(name = "testLinkedListEqualityAfterRemove", max_score = 1)
    public void testLinkedListEqualityAfterRemove() {
        List<Integer> l = new LinkedList<>();
        List<Integer> m = new LinkedList<>();
        l.add(43);
        m.add(43);
        assertTrue(l.equals(m));

        l.add(100);
        m.add(-55);
        assertFalse(l.equals(m));

        l.remove(1);
        m.remove(1);
        assertTrue(l.equals(m));
    }

    @Test
    @GradedTest(name = "testLinkedListAddAndRemoveMany", max_score = 1)
    public void testLinkedListAddAndRemoveMany() {
        List<String> l = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            l.add("testLinkedList" + i);
            assertEquals("testLinkedList" + i, l.get(i));
        }

        assertEquals(1000, l.size());

        for (int i = 999; i >= 0; i--) {
            String removed = l.remove(i);
            assertEquals("testLinkedList" + i, removed);
        }

        assertEquals(0, l.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @GradedTest(name = "testLinkedListRemoveLowerBound", max_score = 1)
    public void testLinkedListRemoveLowerBound() {
        List<Integer> l = new LinkedList<>();
        l.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @GradedTest(name = "testLinkedListRemoveUpperBoundEmpty", max_score = 1)
    public void testLinkedListRemoveUpperBoundEmpty() {
        List<Integer> l = new LinkedList<>();
        l.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @GradedTest(name = "testLinkedListRemoveUpperBound", max_score = 1)
    public void testLinkedListRemoveUpperBound() {
        List<Integer> l = new LinkedList<>();
        l.add(1999);
        l.remove(1);
    }

    @Test
    @GradedTest(name = "testLinkedListSetOne", max_score = 1)
    public void testLinkedListSetOne() {
        List<String> l = new LinkedList<>();
        l.add("foo");
        assertEquals("foo", l.get(0));

        l.set(0, "bar");
        assertEquals("bar", l.get(0));
    }

    @Test
    @GradedTest(name = "testLinkedListSetFirst", max_score = 1)
    public void testLinkedListSetFirst() {
        List<String> l = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            l.add("testLinkedList" + i);
            assertEquals("testLinkedList" + i, l.get(i));
        }
        l.set(0, "banana");
        assertEquals("banana", l.get(0));
        for (int i = 1; i < 100; i++) {
            assertEquals("testLinkedList" + i, l.get(i));
        }
    }

    @Test
    @GradedTest(name = "testLinkedListSetMiddle", max_score = 1)
    public void testLinkedListSetMiddle() {
        List<String> l = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            l.add("testLinkedList" + i);
            assertEquals("testLinkedList" + i, l.get(i));
        }
        l.set(49, "banana");
        for (int i = 0; i < 100; i++) {
            if (i == 49) {
                assertEquals("banana", l.get(i));
            } else {
                assertEquals("testLinkedList" + i, l.get(i));
            }
        }
    }

    @Test
    @GradedTest(name = "testLinkedListSetEnd", max_score = 1)
    public void testLinkedListSetEnd() {
        List<String> l = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            l.add("testLinkedList" + i);
            assertEquals("testLinkedList" + i, l.get(i));
        }
        l.set(99, "banana");
        for (int i = 0; i < 99; i++) {
            assertEquals("testLinkedList" + i, l.get(i));
        }
        assertEquals("banana", l.get(99));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @GradedTest(name = "testLinkedListSetLowerBound", max_score = 1)
    public void testLinkedListSetLowerBound() {
        List<Integer> l = new LinkedList<>();
        l.set(-1, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @GradedTest(name = "testLinkedListSetUpperBoundEmpty", max_score = 1)
    public void testLinkedListSetUpperBoundEmpty() {
        List<Integer> l = new LinkedList<>();
        l.set(0, 20);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @GradedTest(name = "testLinkedListSetUpperBound", max_score = 1)
    public void testLinkedListSetUpperBound() {
        List<Integer> l = new LinkedList<>();
        l.add(1999);
        l.set(1, 2000);
    }

    @Test
    @GradedTest(name = "testLinkedListIndexOfEmpty", max_score = 1)
    public void testLinkedListIndexOfEmpty() {
        List<Integer> l = new LinkedList<>();
        assertEquals(-1, l.indexOf(1337));
    }

    @Test
    @GradedTest(name = "testLinkedListIndexOfFirst", max_score = 1)
    public void testLinkedListIndexOfFirst() {
        List<Integer> l = new LinkedList<>();
        l.add(1337);
        l.add(1337);
        assertEquals(0, l.indexOf(1337));
    }

    @Test
    @GradedTest(name = "testLinkedListIndexOfLast", max_score = 1)
    public void testLinkedListIndexOfLast() {
        List<Integer> l = new LinkedList<>();
        l.add(1335);
        l.add(1336);
        l.add(1337);
        assertEquals(2, l.indexOf(1337));
    }

    @Test
    @GradedTest(name = "testLinkedListIndexOfMissing", max_score = 1)
    public void testLinkedListIndexOfMissing() {
        List<Integer> l = new LinkedList<>();
        l.add(1335);
        l.add(1336);
        l.add(1337);
        assertEquals(-1, l.indexOf(1338));
    }

    @Test
    @GradedTest(name = "testLinkedListAppend", max_score = 1)
    public void testLinkedListAppend() {
        List<String> l = new LinkedList<>();
        l.add(0, "a");
        l.add(1, "b");
        l.add(2, "c");
        assertEquals("a", l.get(0));
        assertEquals("b", l.get(1));
        assertEquals("c", l.get(2));
    }

    @Test
    @GradedTest(name = "testLinkedListAddToMiddle", max_score = 1)
    public void testLinkedListAddToMiddle() {
        List<Integer> l = new LinkedList<>();
        l.add(12);
        l.add(42);
        l.add(1, 0);
        assertEquals(3, l.size());
        assertEquals(0, (int) l.get(1));
    }

    @Test
    @GradedTest(name = "testLinkedListAddBeforeEnd", max_score = 1)
    public void testLinkedListAddBeforeEnd() {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(5);
        l.add(9);
        l.add(11);
        l.add(3, -7);
        assertEquals(5, l.size());
        assertEquals(-7, (int) l.get(3));
        assertEquals(11, (int) l.get(4));
    }

    @Test
    @GradedTest(name = "testLinkedListAddAtEndIndex", max_score = 1)
    public void testLinkedListAddAtEndIndex() {
        List<Integer> l = new LinkedList<>();
        l.add(-10);
        l.add(8);
        l.add(33);
        l.add(1);
        l.add(1);
        l.add(5, 0);
        assertEquals(6, l.size());
        assertEquals(0, (int) l.get(5));
    }

    @Test
    @GradedTest(name = "testLinkedListAddAtSameIndex", max_score = 1)
    public void testLinkedListAddAtSameIndex() {
        List<Integer> l = new LinkedList<>();
        l.add(9);
        l.add(8);
        l.add(4);
        l.add(2, 10);
        l.add(2, 11);
        assertEquals(5, l.size());
        assertEquals(11, (int) l.get(2));
        assertEquals(10, (int) l.get(3));
    }

    @Test
    @GradedTest(name = "testLinkedListAddMultipleThroughout", max_score = 1)
    public void testLinkedListAddMultipleThroughout() {
        List<Integer> l = new LinkedList<>();
        l.add(12);
        l.add(1, 9);
        l.add(1, 12);
        l.add(2, 0);
        l.add(4);
        l.add(9);
        l.add(4, 8);
        l.add(2, 7);
        assertEquals(8, l.size());
        assertEquals(9, (int) l.get(4));
        assertEquals(12, (int) l.get(1));
        assertEquals(0, (int) l.get(3));
        assertEquals(8, (int) l.get(5));
        assertEquals(7, (int) l.get(2));
    }
}
