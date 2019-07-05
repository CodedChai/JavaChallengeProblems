package com.codedchai.DailyCodingProblem;

import java.util.Arrays;

public class BuildingHeapFromArray {

    public static void main(String[] args){
        int[] array = {5,8,6,1,2,9};
        Arrays.sort(array);

        buildHeap(array);

        for(int element : array){
            System.out.print(element + " ");
        }
    }

    static void buildHeap(int[] array){
        int startIndex = (array.length / 2) - 1;

        for(int i = startIndex; i >= 0; i--){
            heapify(array, i);
        }
    }

    static void heapify(int[] array, int currentIndex){
        int largestIndex = currentIndex;
        int left = 2 * currentIndex + 1;
        int right = 2 * currentIndex + 2;

        // If the left child is larger than the current largest
        if(left < array.length && array[left] > array[largestIndex]){
            largestIndex = left;
        }

        // If the right child is larger than the current largest
        if(right < array.length && array[right] > array[largestIndex]){
            largestIndex = right;
        }

        if(largestIndex != currentIndex){
            int swap = array[currentIndex];
            array[currentIndex] = array[largestIndex];
            array[largestIndex] = swap;

            heapify(array, largestIndex);
        }

    }

}
