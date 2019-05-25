package com.codedchai.dynamicprogramming;

import java.util.HashMap;
import java.util.Random;

public class TargetSum {

    public static void main(String[] args) {
        TargetSum solution = new TargetSum();
        Random rand = new Random();

        int[] nums = new int[30];
        for(int i = 0; i < nums.length; i++){
            nums[i] = rand.nextInt(3);
        }
        int target = 15;

        long startTime = System.nanoTime();
        System.out.println(solution.targetSumBruteForce(nums, target));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000 + "ms");  //divide by 1000000 to get milliseconds.

        startTime = System.nanoTime();
        System.out.println(solution.targetSumTopDown(nums, target));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000 + "ms");  //divide by 1000000 to get milliseconds.

        startTime = System.nanoTime();
        System.out.println(solution.targetSumBottomUp(nums, target));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000 + "ms");  //divide by 1000000 to get milliseconds.

    }


    public int targetSumBruteForce(int[] nums, int target){
        return targetSumBruteForce(nums, target, 0, 0);
    }

    /*
    This is a fairly straightforward and simple way to solve this problem. We will check every combination of adding and subtracting each number to finally come out to a result. This solution is fairly obviously O(2^n) since it will branch out twice each and everytime for an input of n.
    For reference it took 2.4 seconds to run on my 6700k for 30 numbers (hmmm I feel like I've seen this somewhere before).
     */
    public int targetSumBruteForce(int[] nums, int target, int index, int sum){
        if(index >= nums.length){
            return sum == target ? 1 : 0;
        }

        return targetSumBruteForce(nums, target, index+1, sum + nums[index]) + targetSumBruteForce(nums, target, index+1, sum - nums[index]);
    }

    /*
    I bet you can tell where this is going now. We're going to do everything we can to precompute the data and use a cache similar to the knapsack problem.
     */
    public int targetSumTopDown(int[] nums, int target){
        HashMap<Integer, HashMap<Integer, Integer>> cache = new HashMap<Integer, HashMap<Integer, Integer>>();
        return targetSumTopDown(nums, target, 0, 0, cache);
    }
    /*
    We will be storing the number of combinations where sum = target - sum, we will use a hashmap of a hashmap just like the knapsack problem
    To determine space complexity we will multiply index with the maximum sum giving us the space complexity of O(index * sum(nums)), this will also be our time complexity as we will only be computing each value once. That is WAY better that O(2^n).

    So I don't know about you, but I'm starting to really get the hang of this. To sum it up in my own words we will solve it recursively, say "Wow, that's slow but we solved it." Then we will take the same solution but we will first check to see if we have
    a solution to the problem, if we do let's return that. If we don't then we will have to basically run the return statement from the first brute force recursive problem and then set that equal to a value, we will then add that value to the cache and return that value.
     */
    public int targetSumTopDown(int[] nums, int target, int index, int sum, HashMap<Integer, HashMap<Integer, Integer>> cache){

        if(index == nums.length){
            return sum == target ? 1 : 0;
        }

        if(!cache.containsKey(index)){
            cache.put(index, new HashMap<>());
        }

        Integer cachedCount = cache.get(index).get(sum);

        if(cachedCount != null){
            return cachedCount;
        }

        // Compute the item and add to cache
        int count = targetSumTopDown(nums, target, index + 1, sum + nums[index], cache) + targetSumTopDown(nums, target, index + 1, sum - nums[index], cache) ;

        cache.get(index).put(sum, count);

        return count;
    }

    public int targetSumBottomUp(int[] nums, int target){
        int maxSum = 0;

        for( int num : nums){
            maxSum += num;
        }
        // cache that is the size of all numbers and twice the size of the sum +1, because we can go from -sum to sum
        int[][] cache = new int[nums.length + 1][2 * maxSum + 1];
        cache[0][maxSum] = 1;

        for(int i = 1; i <= nums.length; i++){
            for( int j = 0; j < 2*maxSum + 1; j++){
                int prev = cache[i - 1][j];
                if(prev != 0){
                    cache[i][j-nums[i-1]] += prev;
                    cache[i][j+nums[i-1]] += prev;
                }
            }
        }

        return cache[nums.length][maxSum + target];
    }

}
