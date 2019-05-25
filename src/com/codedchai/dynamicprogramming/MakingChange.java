package com.codedchai.dynamicprogramming;

public class MakingChange {

    public static void main(String[] args) {
        // write your code here

        MakingChange solution = new MakingChange();
        int[] coins = new int[]{10, 6, 1};
        int amount = 68;

        long startTime = System.nanoTime();
        System.out.println(solution.makeChangeCalculate(coins, amount));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.

        startTime = System.nanoTime();
        System.out.println(solution.makeChangeRecursive(coins, amount));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.

        startTime = System.nanoTime();
        System.out.println(solution.makeChangeTopDown(coins, amount));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.

        startTime = System.nanoTime();
        System.out.println(solution.makeChangeBottomUp(coins, amount));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.
    }

    /*
    This is by far my favorite solution to this problem. It's the one that immediately comes to mind and is pretty efficient. Space and time wise it is O(c). Also it's way more readable than the versions below but it isn't the point of this exercise.
     */
    public int makeChangeCalculate(int[] coins, int amount){

        int totalCoins = 0;

        for(int coin : coins){
            totalCoins += amount / coin;
            amount = amount % coin;
        }

        return totalCoins;
    }

    public int makeChangeRecursive(int[] coins, int amount){
        // Base case
        if(amount == 0){
            return 1;
        }
        int minCoins = Integer.MAX_VALUE;
        for(int coin : coins){
            if(coin <= amount){
                int currMinCoins = makeChangeRecursive(coins, amount - coin);
                minCoins = Math.min(currMinCoins, minCoins);
            }
        }

        return minCoins + 1;
    }


    public int makeChangeTopDown(int[] coins, int amount){
        int[] cache = new int[amount + 1];
        return makeChangeTopDown(coins, amount, cache);
    }

    public int makeChangeTopDown(int[] coins, int amount, int[] cache){
        if(cache[amount] != 0){
            return  cache[amount];
        }

        // Base case
        if(amount == 0){
            return 1;
        }
        cache[amount] = Integer.MAX_VALUE;
        for(int coin : coins){
            if(coin <= amount){
                int currMinCoins = makeChangeRecursive(coins, amount - coin);
                cache[amount] = Math.min(currMinCoins, cache[amount]);
            }
        }

        return cache[amount] + 1;
    }

    public int makeChangeBottomUp(int[] coins, int amount){
        int[] cache = new int[amount + 1];

        for(int i = 1; i <= amount; i++){
            int minCoins = Integer.MAX_VALUE;
            for(int coin : coins){
                if(coin <= i){
                    int currCoins = cache[i - coin] + 1;
                    minCoins = Math.min(currCoins, minCoins);
                }
            }
            cache[i] = minCoins;
        }

        return cache[amount] + 1;
    }
}
