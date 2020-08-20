package com.arunapi.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = MergeSort.generateRandomArray(10);
        MergeSort.printArray(arr, -1,-1);
        insertionSort(arr);
        MergeSort.printArray(arr, -1,-1);

    }
    public static void insertionSort(int[] arr){
        for(int positionToSort = 1;positionToSort< arr.length;positionToSort++) {
            int placeHolder = arr[positionToSort];
            int previousPositionToCompare = positionToSort - 1;
            while(previousPositionToCompare >= 0) {
                if (arr[previousPositionToCompare] > placeHolder) {
                    arr[previousPositionToCompare + 1] = arr[previousPositionToCompare];
                }
                previousPositionToCompare--;
            }
            arr[previousPositionToCompare+1]=placeHolder;
        }
    }
}
