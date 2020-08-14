package com.arunapi.sorting;


public class MergeSort {

    public static void main(String[] args) {

        MergeSort sorter = new MergeSort();


        //Test Case 1
        int[] arr = generateRandomArray(1);
        printHorzArray(arr,-1,-1);
        sorter.mergeSort(arr,0,arr.length-1);
        printHorzArray(arr,-1,-1);

        //Test Case 2
        arr = generateRandomArray(2);
        printHorzArray(arr,-1,-1);
        sorter.mergeSort(arr,0,arr.length-1);
        printHorzArray(arr,-1,-1);

        //Test Case 3
        arr = generateRandomArray(10);
        printHorzArray(arr,-1,-1);
        sorter.mergeSort(arr,0,arr.length-1);
        printHorzArray(arr,-1,-1);
    }

    public void mergeSort(int[]arr, int start, int end) {

        if (end <= start) {
            return;
        }
        int middle = start + (end - start) / 2;
        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);
        merge(arr, start, middle, end);


    }

    public void merge(int[] arr, int start, int middle, int end) {

        int sizeOfLeftArray = (middle - start) + 1;
        int sizeOfRightArray = end - middle;

        int[] leftArray = new int[sizeOfLeftArray];
        int[] rightArray = new int[sizeOfRightArray];

        for (int i = 0; i < sizeOfLeftArray; i++) {
            leftArray[i] = arr[start+i];
        }
        for (int j = 0; j < sizeOfRightArray; j++) {
            rightArray[j] = arr[middle+1+j];
        }
        System.out.println("Left Array :");
        printHorzArray(leftArray,-1,-1);
        System.out.println("Right Array: ");
        printHorzArray(rightArray,-1,-1);
        int j = 0;
        int i = 0;
        for (int k = start; k <= end; k++) {
            if (i < sizeOfLeftArray && ( j == sizeOfRightArray
                    || leftArray[i] < rightArray[j])) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
        }
//    start = 0, end = 4, middle = 3
//    leftArray = 8,11,15
//    rightArray = 7,14

//    k=0
//    8<7 no arr[0] = 7 j=1
//    8<14 yes arr[1] = 8 i=1
//    11<14 yes arr[2] = 11 i=2
//    15<14 no arr[3] = 14 j=2
    }
    //TODO Watch and improve upon lambda


    static void printHorzArray(int[] theArray, int i, int j) {
        int arraySize = theArray.length;
        for (int n = 0; n < 61; n++)
            System.out.print("-");

        System.out.println();

        for (int n = 0; n < arraySize; n++) {

            System.out.format("| %2s " + " ", n);

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++)
            System.out.print("-");

        System.out.println();
        System.out.print("{");
        for (int n = 0; n < arraySize; n++) {
            if (n < arraySize - 1) {
                System.out.print(String.format(" %2s  " + ",", theArray[n]));
            } else if (n == 0) {
                System.out.print(String.format(" %2s " + ",", theArray[n]));
            } else {
                System.out.print(String.format(" %2s " + " ", theArray[n]));
            }

        }
        System.out.println("}");

        for (int n = 0; n < 61; n++)
            System.out.print("-");

        System.out.println();
        if (i >= 0 || j >= 0)
            if (i <= j) {

                // Number of spaces to put before the F

                int spacesBeforeFront = 6 * (i) + 3;

                for (int k = 0; k < spacesBeforeFront; k++)
                    System.out.print(" ");

                System.out.print("L");

                // Number of spaces to put before the R

                int spacesBeforeRear = (6 * (j)) - spacesBeforeFront + 1;

                for (int l = 0; l < spacesBeforeRear; l++)
                    System.out.print(" ");

                System.out.print("R");


                System.out.println("\n");

            } else {
                int temp = i;
                i = j;
                j = temp;
                // Number of spaces to put before the F

                int spacesBeforeFront = 6 * (i) + 3;

                for (int k = 0; k < spacesBeforeFront; k++)
                    System.out.print(" ");

                System.out.print("R");

                // Number of spaces to put before the R

                int spacesBeforeRear = (6 * (j)) - spacesBeforeFront + 1;

                for (int l = 0; l < spacesBeforeRear; l++)
                    System.out.print(" ");

                System.out.print("L");


                System.out.println("\n");

            }


    }

    public static int[] generateRandomArray(int arraySize) {
        int[] arr = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            arr[i] = (int) (Math.random() * 50) + 10;
        }
        return arr;
    }

}


