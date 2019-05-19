package com.codedchai.dynamicprogramming;

public class MakingChange {

    public static void main(String[] args) {
        // write your code here

        MakingChange solution = new MakingChange();

        long startTime = System.nanoTime();
        System.out.println(solution.makeChangeCalculate(12));
        long endTime = System.nanoTime();

        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.

    }

    /*
    This is by far my favorite solution to this problem. It's the one that immediately comes to mind and is pretty efficient. Space and time wise it is O(c).
     */
    public int makeChangeCalculate(int amount){
        int[] coins = new int[]{10, 6, 1};

        int totalCoins = 0;

        for(int coin : coins){
            totalCoins += amount / coin;
            amount = amount % coin;
        }

        return totalCoins;
    }

    // TODO: Create a dynamic programming approach to this problem
}
