package com.arunapi.sorting;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


public class MergeSortBenchmark {

    @State(Scope.Thread)
    public static class Data {

        @Setup(Level.Iteration)
        public void doSetup() {
            arr = MergeSort.generateRandomArray(10);
        }

        @TearDown(Level.Trial)
        public void doTearDown() {
        }

        public int []arr;
    }

    @Benchmark @BenchmarkMode(Mode.SampleTime) @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void mergeSort(Data data) {
        mergeSort(data.arr, 0,data.arr.length-1);
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
    }
}
