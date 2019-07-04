package com.codedchai.ctci.sortingandsearching;

import java.util.List;

public class SparseSearch {

    public static void main(String[] args){
        SparseSearch sparseSearch = new SparseSearch();

        int[] list = {-1, 2, -1, -1, -1, -1, -1, -1, 4, 5, 6, -1, 7, -1, 9, -1, -1,10};

        System.out.println(sparseSearch.search(list, 9));
    }

    int search(int[] list, int value){
        int index = 0;
        while(list[index] != -1 && list[index] < value){
            index *= 2;
        }
        return sparseBinarySearch(list, value, index / 2, index);
    }

    int sparseBinarySearch(int[] list, int value, int low, int high){
        int mid;
        while( low <= high){
            mid = (low + high) / 2;
            int middleValue = list[mid];
            if(middleValue > value || middleValue == -1){
                high = mid - 1;
            } else if (middleValue < value){
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
