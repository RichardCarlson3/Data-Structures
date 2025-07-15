/*
 * Copyright 2023 Marc Liberatore.
 */

package hashtables;

import static org.junit.Assert.*;

import com.gradescope.jh61b.grader.GradedTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class ChainingHashTableTest {
  //  @Rule
  //  public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds

  @Before
  public void setup() {}

  @Test
  @GradedTest(name = "testNewTable", max_score = 2)
  public void testNewTable() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertEquals("New table should have size 0.", 0, t.size());
    assertEquals("Initial capacity should be 7.", 7, t.capacity());
  }

  @Test
  @GradedTest(name = "testNewTableCapacity5", max_score = 2)
  public void testNewTableCapacity5() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>(5);
    assertEquals("Capacity for new table initialized with 5 should be 7.", 7,
                 t.capacity());
  }

  @Test
  @GradedTest(name = "testNewTableCapacity15", max_score = 2)
  public void testNewTableCapacity15() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>(15);
    assertEquals("Capacity for new table initialized with 15 should be 15.", 15,
                 t.capacity());
  }

  @Test
  @GradedTest(name = "testNewTableCapacityMultiple", max_score = 2)
  public void testNewTableCapacityMultiple() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>(2);
    assertEquals("Capacity for new table initialized with 2 should be 3.", 3,
                 t.capacity());

    t = new ChainingHashTable<>(7);
    assertEquals("Capacity for new table initialized with 7 should be 7.", 7,
                 t.capacity());

    t = new ChainingHashTable<>(20);
    assertEquals("Capacity for new table initialized with 20 should be 31.", 31,
                 t.capacity());

    t = new ChainingHashTable<>(65000);
    assertEquals(
        "Capacity for new table initialized with 65000 should be 65535.", 65535,
        t.capacity());
  }

  @Test
  @GradedTest(name = "testSizeSimple", max_score = 2)
  public void testSizeSimple() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertEquals("Table should be empty initially.", 0, t.size());

    t.add(0);
    assertEquals("Table size should increase to 1 after adding one element.", 1,
                 t.size());

    t.add(1);
    assertEquals(
        "Table size should increase to 2 after adding another element.", 2,
        t.size());

    t.add(2);
    assertEquals(
        "Table size should increase to 3 after adding a third element.", 3,
        t.size());
  }

  @Test
  @GradedTest(name = "testSizeCollision", max_score = 2)
  public void testSizeCollision() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertEquals("Table should be empty initially.", 0, t.size());

    t.add(0);
    assertEquals("Table size should be 1 after adding one element.", 1,
                 t.size());

    t.add(7);
    assertEquals("Table size should increase to 2 even with a collision.", 2,
                 t.size());

    t.add(15);
    assertEquals("Table size should increase to 3 despite collisions.", 3,
                 t.size());
  }

  @Test
  @GradedTest(name = "testCapacitySimple", max_score = 2)
  public void testCapacitySimple() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertEquals("Initial capacity should be 7.", 7, t.capacity());

    t.add(0);
    assertEquals(
        "Capacity should remain 7 after adding elements below threshold.", 7,
        t.capacity());

    t.add(1);
    assertEquals("Capacity should remain 7 until resizing is necessary.", 7,
                 t.capacity());
  }

  @Test
  @GradedTest(name = "testCapacityCollision", max_score = 2)
  public void testCapacityCollision() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertEquals("Initial capacity should be 7.", 7, t.capacity());

    t.add(0);
    assertEquals(
        "Capacity should remain 7 after adding non-colliding elements.", 7,
        t.capacity());

    t.add(7);
    assertEquals("Capacity should remain 7 even with collisions.", 7,
                 t.capacity());
  }

  @Test
  @GradedTest(name = "testLoadFactorSimple", max_score = 2)
  public void testLoadFactorSimple() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertEquals("Load factor should be 0 initially.", 0, t.loadFactor(), 0);

    t.add(0);
    assertEquals("Load factor should be 1/7 after adding one element.", 1.0 / 7,
                 t.loadFactor(), 0);

    t.add(1);
    assertEquals("Load factor should be 2/7 after adding two elements.",
                 2.0 / 7, t.loadFactor(), 0);

    t.add(2);
    assertEquals("Load factor should be 3/7 after adding three elements.",
                 3.0 / 7, t.loadFactor(), 0);
  }

  @Test
  @GradedTest(name = "testLoadFactorCollision", max_score = 3)
  public void testLoadFactorCollision() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertEquals("Load factor should be 0 initially.", 0, t.loadFactor(), 0);

    t.add(0);
    assertEquals("Load factor should be 1/7 after adding one element.", 1.0 / 7,
                 t.loadFactor(), 0);

    t.add(7);
    assertEquals(
        "Load factor should be 2/7 after adding another element, even with collision.",
        2.0 / 7, t.loadFactor(), 0);
  }

  @Test
  @GradedTest(name = "testContainsSimple", max_score = 2)
  public void testContainsSimple() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertFalse("Table should not contain an element that hasn't been added.",
                t.contains(0));
    assertFalse("Table should not contain an element that hasn't been added.",
                t.contains(7));

    t.add(0);
    assertTrue("Table should contain the element that was added.",
               t.contains(0));
    assertFalse("Table should not contain an element that hasn't been added.",
                t.contains(7));
  }

  @Test
  @GradedTest(name = "testContainsCollision", max_score = 2)
  public void testContainsCollision() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertFalse("Table should not contain an element that hasn't been added.",
                t.contains(0));
    assertFalse("Table should not contain an element that hasn't been added.",
                t.contains(7));

    t.add(0);
    assertTrue("Table should contain the element that was added.",
               t.contains(0));

    t.add(7);
    assertTrue("Table should handle collisions and still find elements.",
               t.contains(7));
  }

  @Test
  @GradedTest(name = "testRemoveCollisionOffset", max_score = 3)
  public void testRemoveCollisionOffset() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    t.add(0);
    t.add(7);

    assertTrue("Table should contain 0 before removal.", t.contains(0));
    assertTrue("Table should contain 7 before removal.", t.contains(7));

    assertTrue("Removing 0 should return true.", t.remove(0));
    assertFalse("Table should no longer contain 0 after removal.",
                t.contains(0));
    assertTrue("Table should still contain 7.", t.contains(7));
  }

  @Test
  @GradedTest(name = "testIteratorEmpty", max_score = 2)
  public void testIteratorEmpty() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    for (Integer i : t) {
      fail("Iterator should not yield any elements on an empty table.");
    }
  }

  @Test
  @GradedTest(name = "testIteratorSimple", max_score = 2)
  public void testIteratorSimple() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    for (int i = 0; i < 6; i++) {
      t.add(i);
    }

    List<Integer> l = new ArrayList<>();
    for (Integer i : t) {
      l.add(i);
    }

    assertEquals("Iterator should traverse all 6 added elements.", 6, l.size());
    for (int i = 0; i < 6; i++) {
      assertTrue("Iterator should include element " + i, l.contains(i));
    }
  }

  @Test
  @GradedTest(name = "testEnlargeSimple", max_score = 3)
  public void testEnlargeSimple() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertEquals("Initial capacity should be 7.", 7, t.capacity());
    for (int i = 0; i < 6; i++) {
      t.add(i);
      assertEquals("Capacity should remain 7 until threshold is reached.", 7,
                   t.capacity());
    }
    t.add(6);
    assertEquals("Capacity should increase to 15 after resizing.", 15,
                 t.capacity());
  }

  @Test
  @GradedTest(name = "testEnlargeCollision", max_score = 3)
  public void testEnlargeCollision() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertEquals("Initial capacity should be 7.", 7, t.capacity());
    for (int i = 1; i < 7; i++) {
      t.add(i * 7);
      assertEquals("Capacity should remain 7 until resize is necessary.", 7,
                   t.capacity());
    }
    t.add(0);
    assertEquals("Capacity should increase to 15 after threshold is crossed.",
                 15, t.capacity());
  }
  @Test
  @GradedTest(name = "testAddDuplicate", max_score = 3)
  public void testAddDuplicate() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertTrue("Adding a new element should return true.", t.add(42));
    assertFalse("Adding a duplicate element should return false.", t.add(42));
    assertEquals("Size should not increase when adding a duplicate.", 1,
                 t.size());
  }

  @Test
  @GradedTest(name = "testRemoveNonExistent", max_score = 2)
  public void testRemoveNonExistent() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    assertFalse("Removing a non-existent element should return false.",
                t.remove(99));
  }

  @Test
  @GradedTest(name = "testRemoveAndReAdd", max_score = 3)
  public void testRemoveAndReAdd() throws Exception {
    ChainingHashTable<Integer> t = new ChainingHashTable<>();
    t.add(10);
    assertTrue("Element should be removable.", t.remove(10));
    assertEquals("Table should be empty after removal.", 0, t.size());
    t.add(10);
    assertEquals("Re-added element should increase the size to 1.", 1,
                 t.size());
    assertTrue("Re-added element should be in the table.", t.contains(10));
  }
}
