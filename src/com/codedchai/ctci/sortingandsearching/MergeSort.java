package com.codedchai.ctci.sortingandsearching;

import java.util.Random;

public class MergeSort {

    public static void main(String[] args){
        MergeSort ms = new MergeSort();
        Random random = new Random();

        int[] list = new int[1000];
        for(int i = 0; i < list.length; i++){
            list[i] = random.nextInt(5000);
            System.out.print(list[i] + ", ");
        }

        ms.mergesort(list);

        System.out.println();

        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + ", ");
        }

    }

    public void mergesort(int[] array){
        mergesort(array, new int[array.length], 0, array.length - 1);
    }

    private void mergesort(int[] array, int[] tempArray, int leftStart, int rightEnd){
        if(leftStart >= rightEnd){
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergesort(array, tempArray, leftStart, middle);
        mergesort(array, tempArray, middle + 1, rightEnd);
        mergeHalves(array, tempArray,  leftStart, rightEnd);
    }

    public static void mergeHalves(int[] array, int[] tempArray, int leftStart, int rightEnd){
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd){
            if(array[left] <= array[right]){
                tempArray[index] = array[left];
                left++;
            } else {
                tempArray[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, tempArray, index, leftEnd - left + 1);
        System.arraycopy(array, right, tempArray, index, rightEnd - right + 1);
        System.arraycopy(tempArray, leftStart, array, leftStart, size);
    }

}
