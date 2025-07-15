/*
 * Copyright 2023 Marc Liberatore.
 */

package heaps;

import java.util.Arrays;
import java.util.Random;

public class HeapUtilities {
    /**
     * Returns true iff the subtree of a starting at index i is a max-heap.
     * 
     * @param a an array representing a mostly-complete tree, possibly a heap
     * @param i an index into that array representing a subtree rooted at i
     * @return true iff the subtree of a starting at index i is a max-heap
     */
    static boolean isHeap(double[] a, int i) {
        // TASK 1: Add your implementation here.
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<a.length){
            if(a[i]<a[left]||!isHeap(a, left)){
                return false;
            }
        }
        if(right<a.length){
            if(a[i]<a[right]||!isHeap(a,right)){
                return false;
            }
        }

        return true;
    }

    /**
     * Swap the elements at indices i and j in the array a.
     * 
     * @param a the array
     * @param i the first index
     * @param j the second index
     */
    static void swap(double[] a, int i, int j) {
        // TASK 2: Add your implementation here.
        double filler = a[i];
        a[i] = a[j];
        a[j] = filler;
    }

    /**
     * Perform the heap siftdown operation on index i of the array a.
     * 
     * This method assumes the subtrees of i are already valid max-heaps.
     * 
     * This operation is bounded by n (exclusive)! In a regular heap,
     * n = a.length, but in some cases (for example, heapsort), you will
     * want to stop the sifting at a particular position in the array.
     * siftDown should stop before n, in other words, it should not
     * sift down into any index great than (n-1).
     * 
     * @param a the array being sifted
     * @param i the index of the element to sift down
     * @param n the bound on the array (that is, where to stop sifting)
     */
    static void siftDown(double[] a, int i, int n) {
        // TASK 3: Add your implementation here.
        while(true){
            int left = 2*i+1;
            int right = 2*i+2;
            int max = i;
            if(n>left && a[max]<a[left]){
                max=left;
            }
            if(n>right && a[max]<a[right]){
                max=right;
            }
            if(max == i) break;

            swap(a,i,max);
            i=max;
            
        }
    }

    /**
     * Heapify the array a in-place in linear time as a max-heap.
     * 
     * @param a an array of values
     */
    static void heapify(double[] a) {
        // TASK 4: Add your implementation here.
        for(int i = a.length/2-1; i>=0; i--){
            siftDown(a,i,a.length);
        }

    }

    /**
     * Heapsort the array a in-place, resulting in the elements of
     * a being in ascending order.
     * 
     * @param a
     */
    static void heapSort(double[] a) {
        // TASK 5: Add your implementation here.
        heapify(a);
        int size = a.length;
        while(size>0){
            swap(a,0,size-1);
            size--;
            siftDown(a,0,size);
        }

    }

    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        Random r = new Random(0);
        int length = 15;
        double[] l = new double[length];
        for (int i = 0; i < length; i++) {
            l[i] = r.nextInt(20);
        }
        System.out.println(Arrays.toString(l));
        System.out.println(Arrays.toString(l));
        heapSort(l);
        System.out.println(Arrays.toString(l));
    }
}