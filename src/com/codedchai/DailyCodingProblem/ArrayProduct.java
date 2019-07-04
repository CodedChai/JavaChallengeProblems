package com.codedchai.DailyCodingProblem;

import java.util.Arrays;

public class ArrayProduct {

    public static void main(String[] args){

        int[] initialArray = {1,2,3,4,5};

        int[] summedArrayNaive = new int[initialArray.length];

        for(int i = 0; i < summedArrayNaive.length; i++){

            int totalProduct = 1;

            for(int j = 0; j < initialArray.length; j++){
                if( i != j){
                    totalProduct *= initialArray[j];
                }
            }
            summedArrayNaive[i] = totalProduct;
        }

        for(int i : summedArrayNaive){
            System.out.print(i + ", ");
        }

        System.out.println();

        int[] summedArrayEfficient = new int[initialArray.length];


        int productOfInitialArray = 1;
        for(int i : initialArray){
            productOfInitialArray *= i;
        }

        for(int i = 0; i < initialArray.length; i++){
            summedArrayEfficient[i] = productOfInitialArray/initialArray[i];
        }

        for(int i : summedArrayEfficient){
            System.out.print(i + ", ");
        }


    }

}
