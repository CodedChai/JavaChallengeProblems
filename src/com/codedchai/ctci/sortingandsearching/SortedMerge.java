package com.codedchai.ctci.sortingandsearching;

public class SortedMerge {

    /*
     * Given two sorted arrays, A and B, merge them into array A, assuming A has enough space for both, while remaining sorted
     */
    public static void main(String[] args){
        SortedMerge sortedMerge = new SortedMerge();

        int[] a = new int[10];
        a[0] = 1;
        a[1] = 6;
        a[2] = 11;
        a[3] = 11;
        a[4] = 20;

        int[] b = {5,7,8,12,15};

        sortedMerge.merge(a, b, 5, 5);

        for(int element : a){
            System.out.println(element);
        }

    }

    public void merge(int[] a, int[] b, int lastA, int lastB){

        int indexA = lastA - 1; // Index of last element in a
        int indexB = lastB - 1; // Index of last element in b
        int indexMerged = lastB + lastA - 1; // end of merged array

        // Merge A and B starting on the last element in each

        while(indexB >= 0){
            if(indexA>=0 && a[indexA] > b[indexB]){
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }


    }

}
