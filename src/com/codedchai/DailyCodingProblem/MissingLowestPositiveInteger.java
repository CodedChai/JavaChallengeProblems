package com.codedchai.DailyCodingProblem;

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

        lowestPositiveInt = 1;
        int closeToLowestInInput = 2;
        int finalIndex = 0;
        for(int i = 0; i < input.length; i++){
            int temp = input[i];

            if(temp == finalIndex){

            }

        }


    }

}
