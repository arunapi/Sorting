package com.arunapi.sorting;

import java.util.Arrays;

public class HeapSort {
    public Node[] nodes;
    int length;
    public HeapSort(int size) {
        this.length = 0;
        nodes = new Node[size];
        int []keys = MergeSort.generateRandomArray(size);
        for(int key: keys){
            nodes[length] = new Node(key);
            length++;
        }
    }

    public static void main(String[] args) {

        int size = 10;
        HeapSort newHeap = new HeapSort(10);

        // Print out the array before it is sorted
        System.out.println("Original Array");
        HeapSort.printHeapArray(newHeap.nodes);
        System.out.println();
        HeapSort.printTree(-1, newHeap.nodes);
        System.out.println();

    }

    public static void printHeapArray(Node[] nodes) {
        int[] intArray = new int[nodes.length];
        for(int i=0;i<nodes.length;i++){
            intArray[i] = nodes[i].key;
        }
        MergeSort.printArray(intArray,-1,-1);
    }
    /**
     * Code copied and updated from http://www.newthinktank.com/2013/04/java-heap-tutorial/
     */
    public static void printTree(int heightOfheap, Node[] nodes) {
        if(heightOfheap<0){
            heightOfheap = 0;
            int  i = nodes.length;
            while(i>0){
                i=i/2;
                heightOfheap++;
            }
        }
        // Number of spaces between items in tree
        int spaces = 0;
        int iteration = 1;
        // Generate all of the indents that are
        // needed depending on the number of rows
        // to print
        int[] indent = getIndentArray(heightOfheap);
        while (iteration <= heightOfheap) {
            // Find first Index : .5 * (-2 + 2^n)
            int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));
            // Number of Items per Row : 2^(n - 1)
            int itemsPerRow = (int) (Math.pow(2, iteration - 1));
            int maxIndexToPrint = indexToPrint + itemsPerRow;
            // Print the indents needed
            for (int j = 0; j < indent[iteration - 1]; j++)
                System.out.print(" ");
            // Print all of the index values for each row
            // indexToPrint represents the first index in the
            // row, while maxIndexToPrint equals the last
            for (int l = indexToPrint; l < maxIndexToPrint; l++) {
                // If the array isn't full don't try to print
                // indexes that don't exist
                if (l < nodes.length) {
                    System.out.print(nodes[l].key);
                    for (int k = 0; k < spaces; k++)
                        System.out.print(" ");
                }
            }
            // In a tree the spaces get bigger in the
            // same way that indents get smaller
            spaces = indent[iteration - 1];
            iteration++;
            System.out.println();
        }

    }
    // Calculate each indent per row for the tree
    // then reverse their order to go from biggest
    // to smallest
    public static int[] getIndentArray(int rows) {
        int[] indentArray = new int[rows];
        for (int i = 0; i < rows; i++) {
            indentArray[i] = (int) Math.abs((-2 + (Math.pow(2, i + 1))));
        }
        Arrays.sort(indentArray);
        reverseArray(indentArray);
        return indentArray;
    }

    // Reverse the indent values in the array
    // so that they go from biggest to smallest
    public static int[] reverseArray(int[] theArray) {
        // Index of the first element
        int leftIndex = 0;
        // Index of last element
        int rightIndex = theArray.length - 1;
        while (leftIndex < rightIndex) {
            // Exchange the left and right elements
            int temp = theArray[leftIndex];
            theArray[leftIndex] = theArray[rightIndex];
            theArray[rightIndex] = temp;
            // Move the indexes to check towards the middle
            leftIndex++;
            rightIndex--;
        }
        return theArray;
    }
    // END of Code copied and update from http://www.newthinktank.com/2013/04/java-heap-tutorial/

}

class Node{
    public int key;

    public Node(int key) {
        this.key = key;
    }

    public String toString() {
        return Integer.toString(key);
    }
}
