package com.codedchai.dynamicprogramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class MaximumSubarray {

    public static void main(String[] args){
        int[] array = {1,2,-3,-4,2,7,-2,3};

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        String string = "asdfb";


        System.out.println("The maximum subarray is: " + maximumSubarray.findMaximumSubarray(array));
    }

    public int findMaximumSubarray(int[] array){
        int[] cache = new int[array.length + 1];
        cache[0] = 0;

        for(int i = 1; i < cache.length; i++){
            cache[i] = Math.max(cache[i - 1] + array[i-1], array[i-1]);
            System.out.println("The current maximum is: " + cache[i]);
        }

        return Arrays.stream(cache).max().getAsInt();
    }
}
