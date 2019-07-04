package com.codedchai.ctci.sortingandsearching;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        Random random = new Random();

        int[] list = new int[1000];
        for(int i = 0; i < list.length; i++){
            list[i] = random.nextInt(5000);
            System.out.print(list[i] + ", ");
        }

        qs.quicksort(list);

        System.out.println();

        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + ", ");
        }

    }

    public void quicksort(int[] array){
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(int[] array, int left, int right){
        if(left >= right){
            return;
        }
        int pivotElement = array[(left + right) / 2];
        int index = partition(array, left, right, pivotElement);
        quicksort(array, left, index - 1);
        quicksort(array, index, right);
    }

    private int partition(int[] array, int left, int right, int pivotElement){
        while(left <= right){
            while(array[left] < pivotElement){
                left++;
            }

            while(array[right] > pivotElement){
                right--;
            }

            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] array, int leftIndex, int rightIndex){
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
