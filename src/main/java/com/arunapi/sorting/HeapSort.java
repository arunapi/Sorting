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

        HeapSort newHeap = new HeapSort(15);

        // Print out the array before it is sorted
        System.out.println("Original Array");
        HeapSort.printHeapArray(newHeap.nodes);
        System.out.println();
        HeapSort.printTree(-1, newHeap.nodes,new int[]{});
        System.out.println();
        Node[] maxHeapNodes = buildMaxHeap(newHeap.nodes);
        System.out.println("Max heap Array");
        HeapSort.printHeapArray(maxHeapNodes);
        System.out.println();
        HeapSort.printTree(-1, maxHeapNodes,new int[]{});
        System.out.println();

    }

    private static Node[] buildMaxHeap(Node[] nodes) {
        System.out.println("Starting at A["+(nodes.length/2-1)+"] = "+nodes[nodes.length/2 - 1]);
        for(int i= nodes.length/2 - 1; i>=0; i--){
            System.out.println("Next, Is A["+i+"] = "+nodes[i]+" at right position in it's tree?");
            int key = nodes[i].key;
            maxHeapify(nodes,i);
            System.out.println(key+" is moved to the correct position");
            System.out.println("Heap Array");
            HeapSort.printHeapArray(nodes);
            System.out.println();
            HeapSort.printTree(-1, nodes,new int[]{key});
            System.out.println();
        }

        return nodes;
    }

    private static void maxHeapify(Node[] nodes, int i) {
        int largest = i;
        int left = 2*(i+1) - 1;
        int right = 2*(i+1) ;

        if(left< nodes.length)
            System.out.println("A["+i+"]'s left is at A["+left+"] = "+nodes[left]);
        if(right< nodes.length)
            System.out.println("A["+i+"]'s right is at A["+right+"] = "+nodes[right]);

        if(left< nodes.length && nodes[largest].key < nodes[left].key){
            largest = left;
        }
        if(right< nodes.length && nodes[largest].key < nodes[right].key){
            largest = right;
        }
        if(largest!=i){
            System.out.println("Swap with the largest. i.e. Move current node as a child node of the largest node. Swapping A["+i+"] with A["+largest+"]");
            Node temp = nodes[i];
            nodes[i] = nodes[largest];
            nodes[largest] = temp;
            System.out.println("Heap Array after swap");
            HeapSort.printHeapArray(nodes);
            System.out.println();
            HeapSort.printTree(-1, nodes,new int[]{nodes[i].key,nodes[largest].key});
            System.out.println();
            maxHeapify(nodes,largest);
        }
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
    public static void printTree(int heightOfheap, Node[] nodes, int[] highlightValues) {
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
                    boolean highlight = false;
                    for(int val: highlightValues)
                    if (val == nodes[l].key){
                        highlight=true;
                    }
                    if(highlight){
                        System.out.print("["+nodes[l]+"]");
                    }
                    else{
                        System.out.print(nodes[l]);
                    }
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
