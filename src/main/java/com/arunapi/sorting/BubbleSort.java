package com.arunapi.sorting;
import java.util.Arrays;

public class BubbleSort{

    public static void main(String[] args){
        int [] arr  = new int[]{5,12,7,3,8};
        System.out.println( Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        for(int j=arr.length-1;j>0;j--){
            for(int i=0;i<j;i++){
                if(arr[i]>arr[i+1]){
                    //swap
                    int temp = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
            }
        }
    }

}
