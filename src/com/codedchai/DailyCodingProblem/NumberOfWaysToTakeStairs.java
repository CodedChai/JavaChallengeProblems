package com.codedchai.DailyCodingProblem;

public class NumberOfWaysToTakeStairs {

    public static void main(String[] args){
        // Suppose you can go up stairs either at 1 or 2, how many different ways can we go up the stairs?

        int numStairs = 15;

        int[] cache = new int[numStairs + 1];

        if(cache.length < 2){
            System.out.println(1);
            return;
        }

        cache[0] = 1;
        cache[1] = 1;

        for(int i = 2; i <= numStairs; i++){
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        System.out.println(cache[numStairs]);


    }


}
