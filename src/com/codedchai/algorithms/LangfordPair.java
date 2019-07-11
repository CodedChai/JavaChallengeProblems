package com.codedchai.algorithms;

import java.util.Map;

public class LangfordPair {

    public static void main(String[] args){
        LangfordPair langfordPair = new LangfordPair();

        int[] pairs = langfordPair.langfordPairs(2);

        for(int num : pairs){
            System.out.print(num + ", ");
        }
    }

    int[] langfordPairs(int n){

        int[] pairs = new int[n * 2];

        //for 2 it would be 2 1 1 2
        // for 3 it would be 2 3 1 2 1 3

        pairs = new int[n * 2];

        for(int i = 0; i < pairs.length; i++){


            for(int j = n; j > 0; j--){
                if(isValid(pairs, i, j)){
                    pairs[i] = j;
                }


            }
        }
        return pairs;

    }

    boolean isValid(int[] pairs, int index, int candidate){
        if(index - candidate >= 0){
            return pairs[index] == candidate;
        }

        return pairs[index] == 0;
    }

}
