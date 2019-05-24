package com.codedchai.dynamicprogramming;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Knapsack {
    /*
    Welcome to one of the most commonly asked problems. I would definitely recommend that you(whoever may read this if anyone) understand this.

    The classic problem goes that you have a knapsack full of things that you are going to sell at the market but it can only carry a limited amount of weight. So your goal is to maximize the amount of money you want to earn.
     */

    public class Item {
        int weight;
        int value;

        public Item() {
            weight = 0;
            value = 0;
        }

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Knapsack solution = new Knapsack();

        Item[] items = solution.initItems(30, 10, 12);

        int maxWeight = 60;


        long startTime = System.nanoTime();
        System.out.println(solution.knapsackBruteForceEntry(items, maxWeight));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000 + "ms");  //divide by 1000000 to get milliseconds.

        startTime = System.nanoTime();
        System.out.println(solution.knapsackTopDown(items, maxWeight));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000 + "ms");  //divide by 1000000 to get milliseconds.

        startTime = System.nanoTime();
        System.out.println(solution.knapsackBottomUp(items, maxWeight));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000 + "ms");  //divide by 1000000 to get milliseconds.

    }

    public Item[] initItems(int numItems, int maxWeight, int maxValue) {
        Random rand = new Random();

        Item[] items = new Item[numItems];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(rand.nextInt(maxWeight), rand.nextInt(maxValue));
        }

        return items;
    }

    /*
    So this is a pretty bad solution, it's pretty easy to see that it's O(n^2) for time and that the space is O(n). For 30 items it took my 6700k 2.4 seconds to compute Let's see how much better we may be able to do.
    This algorithm also has a MAJOR issue. It won't get you the optimal solution. Since it is only looking at what items are left and the space you have left.
     */
    public int knapsackBruteForceEntry(Item[] items, int weight) {
        return knapsackBruteForce(items, weight, 0);
    }

    public int knapsackBruteForce(Item[] items, int weight, int itemIndex) {
        if (itemIndex == items.length) {
            return 0;
        }

        if (weight - items[itemIndex].weight < 0) {
            return knapsackBruteForce(items, weight, itemIndex + 1);
        }

        return Math.max(knapsackBruteForce(items, weight - items[itemIndex].weight, itemIndex + 1) + items[itemIndex].value, knapsackBruteForce(items, weight, itemIndex + 1));
    }

    /*
    Our top down dynamic solution. We will cache values in a hashmap.
     */
    public int knapsackTopDown(Item[] items, int weight) {
        // Map: item index -> weight -> value
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();

        return knapsackTopDown(items, weight, 0, cache);
    }

    public int knapsackTopDown(Item[] items, int weight, int itemIndex, Map<Integer, Map<Integer, Integer>> cache) {

        if (itemIndex == items.length) {
            return 0;
        }

        if (!cache.containsKey(itemIndex)) {
            cache.put(itemIndex, new HashMap<>());
        }

        Integer cached = cache.get(itemIndex).get(weight);

        // If this value was computed return it
        if(cached != null){
            return cached;
        }

        // Compute the item and add to cache
        int value;
        if (weight - items[itemIndex].weight < 0) {
            value = knapsackTopDown(items, weight, itemIndex + 1, cache);
        } else {
            value = Math.max(knapsackTopDown(items, weight - items[itemIndex].weight, itemIndex + 1, cache) + items[itemIndex].value, knapsackTopDown(items, weight, itemIndex + 1, cache));
        }
        cache.get(itemIndex).put(weight, value);

        return value;
    }

    public int knapsackBottomUp(Item[] items, int maxWeight){
        int[][] cache = new int[items.length + 1][maxWeight + 1];

        // For each item and weight, compute the max value of the items up to that item that doesn't go over the current weight
        // For each item
        for(int itemIndex = 1; itemIndex <= items.length; itemIndex++){
            // for each weight from 0 to our maximum
            for(int weightIndex = 0; weightIndex <= maxWeight; weightIndex++){
                // If we can support the weight of the item then let's compute the value. We will pick the maximum value between the previous item's value
                // or the previous item with the weight index that would be without the previous item plus the previous item's value
                // I have added a print statement to better visualize how this works, please note that if you want to accurately measure computation time then you should remove the print statements
                if(items[itemIndex-1].weight <= weightIndex){
                    cache[itemIndex][weightIndex] = Math.max(cache[itemIndex-1][weightIndex], cache[itemIndex-1][weightIndex-items[itemIndex-1].weight] + items[itemIndex-1].value);
                } else {
                    cache[itemIndex][weightIndex] = cache[itemIndex-1][weightIndex]; // If the item's weight is too much then we wouldn't be able to add it and so set this value to the value of the item's before it
                }
                System.out.printf( "%03d ", cache[itemIndex][weightIndex]);
            }
            System.out.println();
        }

        return cache[items.length][maxWeight];
    }

}





























