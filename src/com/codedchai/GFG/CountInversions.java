package com.codedchai.GFG;

public class CountInversions {

    /* Count the inversions in an array. The straightforward version is to loop through the array and check it but in this case we will be using divide and conquer. */


    public static void main(String[] args){
        int[] array = {1, 20, 6, 4, 5};
        System.out.println(mergeSort(array));
    }

    static int mergeSort(int[] array){
        int[] temp = new int[array.length];
        return mergeSort(array, temp, 0, array.length - 1);
    }

    static int mergeSort(int[] array, int[] temp, int left, int right){
        int mid, numInversions = 0;

        if(right > left){
            mid = (right + left) / 2;

            numInversions += mergeSort(array, temp, left, mid);
            numInversions += mergeSort(array, temp, mid + 1, right);

            numInversions += merge(array, temp, left, mid+1, right);
        }

        return  numInversions;

    }

    static int merge(int[] array, int[] temp, int left, int mid, int right){
        int numInversions = 0;
        int i, j, k;

        i = left;
        j = mid;
        k = left;

        while((i <= mid - 1) && (j <= right)){
            if(array[i] <= array[j]){
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                numInversions += (mid - i);
            }
        }

        while(i < mid){
            temp[k++] = array[i++];
        }

        while(j <= right){
            temp[k++] = array[j++];
        }

        for(i = left; i <= right; i++){
            array[i] = temp[i];
        }

        return  numInversions;
    }

}
