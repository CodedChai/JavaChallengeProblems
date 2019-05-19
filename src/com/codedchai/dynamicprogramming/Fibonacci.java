package com.codedchai.dynamicprogramming;

/*
Dynamic programming is essentially recursion where you are storing the solutions to sub problems. This relies on the fact that there are most likely overlapping sub-problems. For instance, say you want fibonacci(5) then you have to compute fibonnacci(4) and fibonnacci(3) but for fibonnacci(4) you would also need to compute fibonnacci(3). We would want to save this value instead of recomputing it.
We are essentially spending memory to save on performance.

So how do we come up with a DP Solution? The FAST Method!
F - First Solution
A - Analyze the First Solution
S - Identify the Subproblems
T - Turn the solution around
 */


public class Fibonacci {

    public static void main(String[] args) {
        // write your code here

        Fibonacci solution = new Fibonacci();

        long startTime = System.nanoTime();
        System.out.println(solution.fibNaive(45));
        long endTime = System.nanoTime();

        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.


        startTime = System.nanoTime();
        System.out.println(solution.fibDynamic(45));
        endTime = System.nanoTime();

        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.


        startTime = System.nanoTime();
        System.out.println(solution.fibDynamicIterative(45));
        endTime = System.nanoTime();

        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.

        startTime = System.nanoTime();
        System.out.println(solution.fibOptimal(45));
        endTime = System.nanoTime();

        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.


    }

    /*
    The runtime of this is O(2^n). We know this because it will have the depth of the recursive calls (n - 1) and it will create a tree like structure of repeated operations.
    Example, call 1 leads to 2 calls which leads to 4 calls which leads to 8...etc.
    Well, this sucks. On a 6700k it takes 4 seconds to compute the fibonacci of 45. I will be using this as my base benchmark.
     */
    public int fibNaive(int n){
        if(n < 2){
            return n;
        }

        return fibNaive(n-1) + fibNaive(n - 2);
    }

    /*
    The runtime of this is O(n) but the space complexity is also O(n). We will essentially compute and cache the sub-problems.
    On a 6700k this runs in a matter of nanoseconds, not milliseconds. For all intents and purposes it ran instantly.
    Note that this is a top-down solution, that means that it is recursive.
     */

    public int fibDynamic(int n){
        if(n < 2){
            return n;
        }

        // Create cache and initialize to -1
        int[] cache = new int[n + 1];
        for( int i = 0; i < cache.length; i++){
            cache[i] = -1;
        }
        cache[0] = 0;
        cache[1] = 1;
        return fibDynamic(n, cache);
    }
    /*
    Overloaded function for handling the cache
     */
    private int fibDynamic(int n, int[] cache){
        if(cache[n] > -1){
            return cache[n];
        }
        cache[n] = fibDynamic(n-1, cache) + fibDynamic(n-2, cache);
        return cache[n];
    }

    /*
    Now that we have a dynamic solution, let's flip it on it's head. We will do a bottom-up solution. That basically just means it's iterative. This is extremely fast, our space is O(n) and our time is O(n) because you only iterate through once.
     */
    public int fibDynamicIterative(int n){
        if(n <= 0){
            return n;
        }

        int[] cache = new int[n+1];
        cache[0] = 0; // Note that ints will be intiialized as "0" so this is pointless, it is simply to be verbose.
        cache[1] = 1;

        for(int i = 2; i <= n; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[n];
    }

    /*
    Whoaaa man, you're saying it can be done in O(n) time with the space complexity of O(1)?! That's whack! This is such a good solution and it's so simple to understand too. Of course this will also run just about instantly.
     */
    public int fibOptimal( int n ){
        if(n < 2){
            return n;
        }

        int nMinus1 = 1;
        int nMinus2 = 0;

        for(int i = 2; i < n; i++){
            int currentN = nMinus1 + nMinus2;
            nMinus2 = nMinus1;
            nMinus1 = currentN;
        }

        return nMinus1 + nMinus2;
    }

}
