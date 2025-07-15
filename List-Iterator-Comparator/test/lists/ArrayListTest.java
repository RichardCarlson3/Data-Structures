/*
 * Copyright 2023 Marc Liberatore.
 */

package lists;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.gradescope.jh61b.grader.GradedTest;

public class ArrayListTest {
	// @Rule
	// public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds

	@Test
	@GradedTest(name = "testArrayListConstructor", max_score = 1)
	public void testArrayListConstructor() {
		List<Integer> l = new ArrayList<>();
	}

	@Test
	@GradedTest(name = "testArrayListEmptyEquals", max_score = 1)
	public void testArrayListEmptyEquals() {
		List<Integer> l = new ArrayList<>();
		List<Integer> m = new ArrayList<>();
		assertTrue(l.equals(m));
	}

	@Test
	@GradedTest(name = "testArrayListOneEmptyUnequal", max_score = 1)
	public void testArrayListOneEmptyUnequal() {
		List<Integer> l = new ArrayList<>();
		List<Integer> m = new ArrayList<>();
		l.add(43);
		assertFalse(l.equals(m));
	}

	@Test
	@GradedTest(name = "testArrayListOneEqual", max_score = 1)
	public void testArrayListOneEqual() {
		List<Integer> l = new ArrayList<>();
		List<Integer> m = new ArrayList<>();
		l.add(43);
		m.add(43);
		assertTrue(l.equals(m));
	}

	@Test
	@GradedTest(name = "testArrayListOneUnequal", max_score = 1)
	public void testArrayListOneUnequal() {
		List<Integer> l = new ArrayList<>();
		List<Integer> m = new ArrayList<>();
		l.add(43);
		m.add(17);
		assertFalse(l.equals(m));
	}

	@Test
	@GradedTest(name = "testArrayListThreeEqual", max_score = 1)
	public void testArrayListThreeEqual() {
		List<String> l = new ArrayList<>();
		List<String> m = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			l.add("testArrayList" + i);
			m.add("testArrayList" + i);
			assertTrue(l.equals(m));
		}
	}

	@Test
	@GradedTest(name = "testArrayListThreeUnequal", max_score = 1)
	public void testArrayListThreeUnequal() {
		List<String> l = new ArrayList<>();
		List<String> m = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			l.add("testArrayList" + i);
			m.add("testArrayList" + i);
			assertTrue(l.equals(m));
		}
		l.add("foo");
		m.add("bar");
		assertFalse(l.equals(m));
	}

	@Test
	@GradedTest(name = "testArrayListEmptySize", max_score = 1)
	public void testArrayListEmptySize() {
		List<Integer> l = new ArrayList<>();
		assertEquals(0, l.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	@GradedTest(name = "testArrayListAddLowerBound", max_score = 1)
	public void testArrayListAddLowerBound() {
		List<Integer> l = new ArrayList<>();
		l.add(78);
		l.add(-1, 77);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	@GradedTest(name = "testArrayListAddEmptyUpperBound", max_score = 1)
	public void testArrayListAddEmptyUpperBound() {
		List<Integer> l = new ArrayList<>();
		l.add(1, 77);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	@GradedTest(name = "testArrayListAddUpperBound", max_score = 1)
	public void testArrayListAddUpperBound() {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			l.add(i);
		}
		l.add(6, 6);
	}

	@Test
	@GradedTest(name = "testArrayListAddToEmptySize", max_score = 1)
	public void testArrayListAddToEmptySize() {
		List<Integer> l = new ArrayList<>();
		l.add(42);
		assertEquals(1, l.size());
	}

	@Test
	@GradedTest(name = "testArrayListAddToEmptyThenGet", max_score = 1)
	public void testArrayListAddToEmptyThenGet() {
		List<String> l = new ArrayList<>();
		l.add("foo");
		assertEquals("foo", l.get(0));
	}

	@Test
	@GradedTest(name = "testArrayListAddLots", max_score = 1)
	public void testArrayListAddLots() {
		List<String> l = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			l.add("testArrayList" + i);
			assertEquals("testArrayList" + i, l.get(i));
		}
	}

	@Test
	@GradedTest(name = "testArrayListAddAtFrontEmpty", max_score = 1)
	public void testArrayListAddAtFrontEmpty() {
		List<String> l = new ArrayList<>();
		l.add(0, "foo");
		assertEquals("foo", l.get(0));
	}

	@Test
	@GradedTest(name = "testArrayListAddLotsAtFront", max_score = 1)
	public void testArrayListAddLotsAtFront() {
		List<String> l = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			l.add(0, "testArrayList" + i);
			assertEquals("testArrayList" + i, l.get(0));
		}
	}

	@Test
	@GradedTest(name = "testArrayListAddThenRemove", max_score = 1)
	public void testArrayListAddThenRemove() {
		List<String> l = new ArrayList<>();
		l.add("foo");
		assertEquals("foo", l.get(0));
		assertEquals(1, l.size());

		String result = l.remove(0);
		assertEquals("foo", result);
		assertEquals(0, l.size());
	}

	@Test
	@GradedTest(name = "testArrayListAddThenRemoveTwo", max_score = 1)
	public void testArrayListAddThenRemoveTwo() {
		List<String> l = new ArrayList<>();
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
	@GradedTest(name = "testArrayListAddThenRemoveTwoFrontFirst", max_score = 1)
	public void testArrayListAddThenRemoveTwoFrontFirst() {
		List<String> l = new ArrayList<>();
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
	@GradedTest(name = "testArrayListEqualityAfterRemove", max_score = 1)
	public void testArrayListEqualityAfterRemove() {
		List<Integer> l = new ArrayList<>();
		List<Integer> m = new ArrayList<>();
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
	@GradedTest(name = "testArrayListAddAndRemoveMany", max_score = 1)
	public void testArrayListAddAndRemoveMany() {
		List<String> l = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			l.add("testArrayList" + i);
			assertEquals("testArrayList" + i, l.get(i));
		}

		assertEquals(1000, l.size());

		for (int i = 999; i >= 0; i--) {
			String removed = l.remove(i);
			assertEquals("testArrayList" + i, removed);
		}

		assertEquals(0, l.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	@GradedTest(name = "testArrayListRemoveLowerBound", max_score = 1)
	public void testArrayListRemoveLowerBound() {
		List<Integer> l = new ArrayList<>();
		l.remove(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	@GradedTest(name = "testArrayListRemoveUpperBoundEmpty", max_score = 1)
	public void testArrayListRemoveUpperBoundEmpty() {
		List<Integer> l = new ArrayList<>();
		l.remove(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	@GradedTest(name = "testArrayListRemoveUpperBound", max_score = 1)
	public void testArrayListRemoveUpperBound() {
		List<Integer> l = new ArrayList<>();
		l.add(1999);
		l.remove(1);
	}

	@Test
	@GradedTest(name = "testArrayListSetOne", max_score = 1)
	public void testArrayListSetOne() {
		List<String> l = new ArrayList<>();
		l.add("foo");
		assertEquals("foo", l.get(0));

		l.set(0, "bar");
		assertEquals("bar", l.get(0));
	}

	@Test
	@GradedTest(name = "testArrayListSetFirst", max_score = 1)
	public void testArrayListSetFirst() {
		List<String> l = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			l.add("testArrayList" + i);
			assertEquals("testArrayList" + i, l.get(i));
		}
		l.set(0, "banana");
		assertEquals("banana", l.get(0));
		for (int i = 1; i < 100; i++) {
			assertEquals("testArrayList" + i, l.get(i));
		}
	}

	@Test
	@GradedTest(name = "testArrayListSetMiddle", max_score = 1)
	public void testArrayListSetMiddle() {
		List<String> l = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			l.add("testArrayList" + i);
			assertEquals("testArrayList" + i, l.get(i));
		}
		l.set(49, "banana");
		for (int i = 0; i < 100; i++) {
			if (i == 49) {
				assertEquals("banana", l.get(i));
			} else {
				assertEquals("testArrayList" + i, l.get(i));
			}
		}
	}

	@Test
	@GradedTest(name = "testArrayListSetEnd", max_score = 1)
	public void testArrayListSetEnd() {
		List<String> l = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			l.add("testArrayList" + i);
			assertEquals("testArrayList" + i, l.get(i));
		}
		l.set(99, "banana");
		for (int i = 0; i < 99; i++) {
			assertEquals("testArrayList" + i, l.get(i));
		}
		assertEquals("banana", l.get(99));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	@GradedTest(name = "testArrayListSetLowerBound", max_score = 1)
	public void testArrayListSetLowerBound() {
		List<Integer> l = new ArrayList<>();
		l.set(-1, 10);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	@GradedTest(name = "testArrayListSetUpperBoundEmpty", max_score = 1)
	public void testArrayListSetUpperBoundEmpty() {
		List<Integer> l = new ArrayList<>();
		l.set(0, 20);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	@GradedTest(name = "testArrayListSetUpperBound", max_score = 1)
	public void testArrayListSetUpperBound() {
		List<Integer> l = new ArrayList<>();
		l.add(1999);
		l.set(1, 2000);
	}

	@Test
	@GradedTest(name = "testArrayListIndexOfEmpty", max_score = 1)
	public void testArrayListIndexOfEmpty() {
		List<Integer> l = new ArrayList<>();
		assertEquals(-1, l.indexOf(1337));
	}

	@Test
	@GradedTest(name = "testArrayListIndexOfFirst", max_score = 1)
	public void testArrayListIndexOfFirst() {
		List<Integer> l = new ArrayList<>();
		l.add(1337);
		l.add(1337);
		assertEquals(0, l.indexOf(1337));
	}

	@Test
	@GradedTest(name = "testArrayListIndexOfLast", max_score = 1)
	public void testArrayListIndexOfLast() {
		List<Integer> l = new ArrayList<>();
		l.add(1335);
		l.add(1336);
		l.add(1337);
		assertEquals(2, l.indexOf(1337));
	}

	@Test
	@GradedTest(name = "testArrayListIndexOfMissing", max_score = 1)
	public void testArrayListIndexOfMissing() {
		List<Integer> l = new ArrayList<>();
		l.add(1335);
		l.add(1336);
		l.add(1337);
		assertEquals(-1, l.indexOf(1338));
	}

	@Test
	@GradedTest(name = "testArrayListAppend", max_score = 1)
	public void testArrayListAppend() {
		List<String> l = new ArrayList<>();
		l.add(0, "a");
		l.add(1, "b");
		l.add(2, "c");
		assertEquals("a", l.get(0));
		assertEquals("b", l.get(1));
		assertEquals("c", l.get(2));
	}

	@Test
	@GradedTest(name = "testArrayListAddToMiddle", max_score = 1)
	public void testArrayListAddToMiddle() {
		List<Integer> l = new ArrayList<>();
		l.add(12);
		l.add(42);
		l.add(1, 0);
		assertEquals(3, l.size());
		assertEquals(0, (int) l.get(1));
	}

	@Test
	@GradedTest(name = "testArrayListAddBeforeEnd", max_score = 1)
	public void testArrayListAddBeforeEnd() {
		List<Integer> l = new ArrayList<>();
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
	@GradedTest(name = "testArrayListAddAtEndIndex", max_score = 1)
	public void testArrayListAddAtEndIndex() {
		List<Integer> l = new ArrayList<>();
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
	@GradedTest(name = "testArrayListAddAtSameIndex", max_score = 1)
	public void testArrayListAddAtSameIndex() {
		List<Integer> l = new ArrayList<>();
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
	@GradedTest(name = "testArrayListAddMultipleThroughout", max_score = 1)
	public void testArrayListAddMultipleThroughout() {
		List<Integer> l = new ArrayList<>();
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
