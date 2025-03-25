/*
 * Copyright 2023 Marc Liberatore.
 */

package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayListIterator<E> implements Iterator<E> {
    // PART 2 Iterators and Comparators    
    // TASK: Complete the constructor and create and initialize the
    // ArrayListIterator fields, ensuring that the iterator starts at the
    // correct position (index
    // 0) and can track the size of the array.
    E[] array; 
    int index;
    int size;

    public ArrayListIterator(E[] array, int size) {
        this.array = array;
        this.index = 0;
        this.size = size;
    }


    @Override
    public boolean hasNext() {
        // PART 2 Iterators
        // TASK: Implement the hasNext method to return true if there are more
        // elements in the collection to iterate over, based on the current
        // index and the size of the collection.
        return size>index;
    }

    @Override
    public E next() {
        // PART 2 Iterators
        // TASK: Implement the next method to return the next element in the
        // iteration. Make sure to throw a NoSuchElementException if there are
        // no more elements to return, and update the index accordingly.
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E result = array[index];
        index++;
        return result;
    }
}