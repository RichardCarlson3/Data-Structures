/*
 * Copyright 2023 Marc Liberatore.
 */
package hashtables;

import java.util.Iterator;

/**
 * An implementation of HashTable.
 * 
 * This implementation uses "open addressing" to resolve collisions. Open
 * addressing means that the underlying array stores references to elements
 * (*not* ArrayLists of references!). when there is a collision, the hash table
 * searches forward linearly in the array until the element being sought is
 * found, or until an empty cell is found.
 * 
 * This implementation maintains a capacity equal to 2^n - 1 for some positive
 * integer n. When the load factor exceeds 0.75, the next add() triggers a
 * resize by incrementing n (by one). For example, when n=3, then capacity=7.
 * When size=6, then load factor ~=0.86. The addition of the seventh item would
 * trigger a resize, increasing the capacity of the array to 15.
 */
public class PrivateOpenHashTable<E> implements HashTable<E> {
    
    /**
     * Instantiate a new hash table. The initial capacity should be 7.
     */
    public PrivateOpenHashTable() {
    }

    /**
     * Instantiate a new hash table. The initial capacity should be 
     * at least sufficient to hold n elements, but must be one less
     * than a power of two.
     */
    public PrivateOpenHashTable(int n) {
    }

    @Override
    public int capacity() {
        return -1;
    }

    @Override
    public int size(){
        return -1;
    }

    @Override
    public double loadFactor() {
        return 0.0;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public E get(E e) {
        return null;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}