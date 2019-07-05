package com.codedchai.DailyCodingProblem;

import java.util.LinkedHashMap;
import java.util.Map;

public class MissingLowestPositiveInteger {

    public static void main(String[] args){

        int[] input = {3, 4, -1, 1, 1, 2};

        // Find in linear time and constant space
        // You can modify the input array in place


        int lowestPositiveInt = 1;


        // Naive approach in O(N^2) time
        for(int i : input){
            for(int j : input){
                if(lowestPositiveInt == j){
                    lowestPositiveInt++;
                }
            }
        }

        System.out.println(lowestPositiveInt);

        System.out.println(missingNumber(input));


    }

    static int missingNumber(int a[]){
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < a.length; i++){
            if(a[i] > 0){
                map.put(a[i], map.get(a[i]) == null ? 1 : map.get(a[i]) + 1);
            }
        }

        int index = 1;
        while(true){
            if(!map.containsKey(index)){
                return index;
            }
            index++;
        }
    }

}
