/*
 * Copyright 2023 Marc Liberatore.
 */

package hashmaps;

import static org.junit.Assert.*;

import com.gradescope.jh61b.grader.GradedTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class SimpleHashMapTest {
  //  @Rule
  //  public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds

  @Before
  public void setup() {}

  @Test
  @GradedTest(name = "testCreation", max_score = 2)
  public void testCreation() throws Exception {
    SimpleMap<Integer, Integer> m = new SimpleHashMap<>();
    assertEquals("New map should be empty initially.", 0, m.size());
  }

  @Test
  @GradedTest(name = "testEmpty", max_score = 3)
  public void testEmpty() throws Exception {
    SimpleMap<Integer, Integer> m = new SimpleHashMap<>();
    assertEquals("Map should be empty initially.", 0, m.size());
    assertNull("Retrieving a non-existent key should return null.", m.get(1));
    assertEquals("Keys set should be empty for an empty map.", new HashSet<>(),
                 m.keys());
  }

  @Test
  @GradedTest(name = "testPutOne", max_score = 2)
  public void testPutOne() throws Exception {
    SimpleMap<Integer, Integer> m = new SimpleHashMap<>();
    m.put(1, 10);
    assertEquals("Map should have size 1 after adding one element.", 1,
                 m.size());
  }

  @Test
  @GradedTest(name = "testGetOne", max_score = 3)
  public void testGetOne() throws Exception {
    SimpleMap<Integer, Integer> m = new SimpleHashMap<>();
    m.put(1, 10);
    assertEquals("Retrieving key 1 should return 10.", Integer.valueOf(10),
                 m.get(1));
    assertNull("Retrieving a non-existent key should return null.", m.get(2));
  }

  @Test
  @GradedTest(name = "testGetOrDefaultOne", max_score = 3)
  public void testGetOrDefaultOne() throws Exception {
    SimpleMap<Integer, Integer> m = new SimpleHashMap<>();
    m.put(1, 10);
    assertEquals("Retrieving existing key 1 should return its value 10.",
                 Integer.valueOf(10), m.getOrDefault(1, 20));
    assertEquals(
        "Retrieving a non-existent key should return the default value.",
        Integer.valueOf(20), m.getOrDefault(2, 20));
  }

  @Test
  @GradedTest(name = "testSizeOne", max_score = 2)
  public void testSizeOne() throws Exception {
    SimpleMap<Integer, Integer> m = new SimpleHashMap<>();
    m.put(1, 10);
    assertEquals("Map size should be 1 after adding one element.", 1, m.size());
  }

  @Test
  @GradedTest(name = "testSizeTwo", max_score = 3)
  public void testSizeTwo() throws Exception {
    SimpleMap<Integer, Integer> m = new SimpleHashMap<>();
    m.put(1, 10);
    m.put(2, 20);
    assertEquals("Map size should be 2 after adding two elements.", 2,
                 m.size());
  }

  @Test
  @GradedTest(name = "testReplaceOne", max_score = 4)
  public void testReplaceOne() throws Exception {
    SimpleMap<Integer, Integer> m = new SimpleHashMap<>();
    m.put(1, 10);
    assertEquals("Initial value for key 1 should be 10.", Integer.valueOf(10),
                 m.get(1));
    m.put(1, 20);
    assertEquals("Value for key 1 should be updated to 20.",
                 Integer.valueOf(20), m.get(1));
    assertEquals("Replacing value should not increase map size.", 1, m.size());
  }

  @Test
  @GradedTest(name = "testRemoveOne", max_score = 4)
  public void testRemoveOne() throws Exception {
    SimpleMap<Integer, Integer> m = new SimpleHashMap<>();
    m.put(1, 10);
    assertNull("Removing a non-existent key should return null.", m.remove(2));
    assertEquals("Map size should remain the same after failed removal.", 1,
                 m.size());

    assertEquals("Removing an existing key should return its value.",
                 Integer.valueOf(10), m.remove(1));
    assertEquals("Map size should be 0 after removing the only element.", 0,
                 m.size());
  }

  @Test
  @GradedTest(name = "testManyActions", max_score = 6)
  public void testManyActions() throws Exception {
    final int ACTIONS = 1000;
    final int BOUND = 100;
    Random random = new Random(0);

    HashMap<Integer, Integer> hm = new HashMap<>();
    SimpleHashMap<Integer, Integer> m = new SimpleHashMap<>();

    for (int i = 0; i < ACTIONS; i++) {
      double d = random.nextDouble();
      if (d < 0.35) {
        // put
        int k = random.nextInt(BOUND);
        int v = random.nextInt(BOUND);
        m.put(k, v);
        hm.put(k, v);
        assertEquals(
            "Put operation: Map should contain the added key-value pair.",
            Integer.valueOf(v), m.get(k));
        assertEquals(
            "Map size should match the size of the reference HashMap after put.",
            hm.size(), m.size());
      } else if (d < 0.65) {
        // remove
        int k = random.nextInt(BOUND);
        assertEquals(
            "Remove operation: Map should return the same value as the reference HashMap.",
            hm.remove(k), m.remove(k));
      } else if (d < 0.85) {
        // get
        int k = random.nextInt(BOUND);
        assertEquals(
            "Get operation: Map should return the same value as the reference HashMap.",
            hm.get(k), m.get(k));
      } else {
        // getOrDefault
        int k = random.nextInt(BOUND);
        assertEquals(
            "getOrDefault operation: Map should return the same value as the reference HashMap.",
            hm.getOrDefault(k, BOUND), m.getOrDefault(k, BOUND));
      }
      assertEquals(
          "Map size should match the reference HashMap size after each action.",
          hm.size(), m.size());
    }
  }

  @Test
  @GradedTest(name = "testManyActions1000", max_score = 22)
  public void testManyActions1000() throws Exception {
    final int ROUNDS = 1000;
    final int ACTIONS = 1000;
    final int BOUND = 100;
    Random random = new Random(0);

    for (int round = 0; round < ROUNDS; round++) {
      HashMap<Integer, Integer> hm = new HashMap<>();
      SimpleHashMap<Integer, Integer> m = new SimpleHashMap<>();

      for (int i = 0; i < ACTIONS; i++) {
        double d = random.nextDouble();
        if (d < 0.35) {
          // put
          int k = random.nextInt(BOUND);
          int v = random.nextInt(BOUND);
          m.put(k, v);
          hm.put(k, v);
          assertEquals(
              "Put operation: Map should contain the added key-value pair.",
              Integer.valueOf(v), m.get(k));
          assertEquals(
              "Map size should match the reference HashMap size after put.",
              hm.size(), m.size());
        } else if (d < 0.65) {
          // remove
          int k = random.nextInt(BOUND);
          assertEquals(
              "Remove operation: Map should return the same value as the reference HashMap.",
              hm.remove(k), m.remove(k));
        } else if (d < 0.85) {
          // get
          int k = random.nextInt(BOUND);
          assertEquals(
              "Get operation: Map should return the same value as the reference HashMap.",
              hm.get(k), m.get(k));
        } else {
          // getOrDefault
          int k = random.nextInt(BOUND);
          assertEquals(
              "getOrDefault operation: Map should return the same value as the reference HashMap.",
              hm.getOrDefault(k, BOUND), m.getOrDefault(k, BOUND));
        }
        assertEquals(
            "Map size should match the reference HashMap size after each action.",
            hm.size(), m.size());
      }
    }
  }
}
