/*
 * Copyright 2023 Marc Liberatore.
 */

package lists;

import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    // Note: do not declare any additional instance variables
    E[] array;
    int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        size = 0;
        array = (E[]) new Object[10];
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (int i = 0; i < size; i++) {
            result = prime * result + array[i].hashCode();
        }
        result = prime * result + size;
        return result;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof List))
            return false;
        List other = (List) obj;
        if (size != other.size())
            return false;
        for(int i=0; i<size; i++){
            if(!array[i].equals(other.get(i))){
                return false;
            }
        }
        // Part 1 List Data Type and Implementations
        // TASK: Ensure that each element in both lists is identical before
        // returning true. Compare corresponding elements of each list and
        // return true only if all comparisons are equal.
        return true;
    }

    @Override
    public int size() {
        // Part 1 List Data Type and Implementations
        // TASK: Replace the return value with the correct logic to return the
        // actual number of elements in the list. 
        return size;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        // Part 1 List Data Type and Implementations
        // TASK: Implement the logic to return the element at the specified
        // index if it is within bounds. If not, throw an exception.
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    // PART 1 List Data Type and Implementations
    // TASK: Implement the `enlarge` method to automatically enlarge the array
    // when it reaches capacity. Ensure you create a new array, copy all
    // elements from the old array, and update the reference.

    @Override
    public void add(E e) {
        // Part 1 List Data Type and Implementations
        // TASK: Implement the add method to include a check for array capacity
        // and enlarge if necessary before adding a new element.
        if(size==array.length){
            enlarge();
        }
        array[size]=e;
        size++;
        }
    @SuppressWarnings("unchecked")
    private void enlarge(){
        E[] newArray = (E[]) new Object[array.length*2];
        for (int i=0; i<array.length; i++){
            newArray[i]= array[i];
        }
        array=newArray;
    }

    @Override
    public void add(int index, E e) throws IndexOutOfBoundsException {
        // Part 1 List Data Type and Implementations
        // TASK: Implement the add method to insert an element at a specific
        // index. Ensure elements are correctly shifted to accommodate the new
        // element. If the index is out of bounds, throw an exception. If the
        // list is full, automatically enlarge it.
        //
        // NOTE: In class we studied a version of this `add` method that threw
        // an exception when add(size of list, e) was called. In this version,
        // we are asking you to allow add(size of list, e) to work.
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        if(size==array.length){
            enlarge();
        }

        for(int i=size; i>index; i--){
            array[i]=array[i-1];
        }
        array[index]=e;
        size++;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        // Part 1 List Data Type and Implementations
        // TASK: Implement the remove method to delete an element at a specified
        // index, shift elements to fill the gap, and return the removed
        // element. If the index is out of bounds, throw an exception.
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        E element = array[index];

        for(int i=index; i<size-1; i++){
            array[i]=array[i+1];
        }
        size--;
        array[size]=null;
        return element;
    }

    @Override
    public E set(int index, E e) throws IndexOutOfBoundsException {
        // Part 1 List Data Type and Implementations
        // TASK: Implement the set method to replace an element at a specified
        // index with a new element and return the old element. If the index is
        // out of bounds, throw an exception.
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        E element=array[index];
        array[index]=e;
        return element;
    }

    @Override
    public int indexOf(E e) {
        // Part 1 List Data Type and Implementations
        // TASK: Implement the indexOf method to return the index of the first
        // occurrence of the specified element in the list, or -1 if the element
        // is not found.
        for(int i=0; i<size; i++){
            if(e.equals(array[i])==true){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        // PART 2 Iterators
        // TASK: Implement the iterator method to return an Iterator for the
        // current collection. Ensure that the Iterator allows sequential access
        // to elements in the correct order.
        return new ArrayListIterator<>(array, size);
    }
}