package com.codedchai.dynamicprogramming;

public class SquareSubmatrix {

    /*
    Given a 2D boolean array find the largest square submatrix of true values. The return value should be the side length of the largest square. (if there are 4 true boolean values in the square return 2)
     */
    public static void main(String[] args) {
        // write your code here

        SquareSubmatrix solution = new SquareSubmatrix();

        boolean[][] smallMatrix = new boolean[3][3];

        smallMatrix[0][0] = true;
        smallMatrix[1][1] = true;
        smallMatrix[1][2] = true;
        smallMatrix[2][2] = true;
        smallMatrix[2][1] = true;

        boolean[][] largeMatrix = new boolean[25][25];

        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 12; j++){
                largeMatrix[i][j] = true;
            }
        }

        long startTime = System.nanoTime();
        System.out.println(solution.squareSubmatrixNaive(largeMatrix));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.


        startTime = System.nanoTime();
        System.out.println(solution.squareSubmatrixTopDown(largeMatrix));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.


        startTime = System.nanoTime();
        System.out.println(solution.squareSubmatrixBottomUp(largeMatrix));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000000 + "ms");  //divide by 1000000 to get milliseconds.

    }

    /*
    So let's find the biggest submatrix where this is the top left corner
     */
    public int squareSubmatrixNaive(boolean[][] matrix){
        int maxSize = 0;

        // Search each cell for the largest size
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                // We only care to search if this is a valid location to search at
                if(matrix[i][j]){
                    maxSize = Math.max(maxSize, squareSubmatrixNaive(matrix, i, j));
                }
            }
        }

        return maxSize;
    }

    /*
    Here's the neat recursion part that actually solves it. The only problem...it's extremely inefficient. It's runtime complexity is O(n * m * 3^(n + m)). You can figure this out because each time this is called it makes 3 recursive calls inside the double for loop. So the double for loop gives you n*m and then this function give you the 3^(n+m). As for space complexity it is only the recursive stack, no other data so it's O(n+m).
    Interestingly enough this ran in 20359 ms for a 25x25 matrix where a rectangle of 15x12 are true which is probably within error margins of the top down solution. I ran this again and this ran in 20539ms so it really is slower.

     */
    private int squareSubmatrixNaive(boolean[][] matrix, int i, int j) {
        // Base case at bottom right of matrix
        if(matrix.length == i || matrix[0].length == j){
            return 0;
        }

        // If the cell is false then it's not part of a valid submatrix
        if(!matrix[i][j]){
            return 0;
        }

        // Find the size of the right, bottom and bottom right submatrices and add 1 to the minimum of those 3 to get the result (we go with min because we want the square not just a sum of a few)
        return 1 + Math.min(Math.min(squareSubmatrixNaive(matrix, i+1, j), squareSubmatrixNaive(matrix, i, j+1)), squareSubmatrixNaive(matrix, i+1, j+1));
    }

    /*
    Cache the values to avoid repeating computations. This is because we are only computing each cell once and we have a new matrix that we are storing the values in.
     */
    public int squareSubmatrixTopDown(boolean[][] matrix){
        int[][] cache = new int[matrix.length][matrix[0].length];
        int maxSize = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j]){
                    maxSize = Math.max(maxSize, squareSubmatrixTopDown(matrix, i, j, cache));
                }

            }
        }

        return maxSize;
    }

    /*
    Interestingly enough this ran in 19919 ms for a 25x25 matrix where a rectangle of 15x12 are true which isn't much of an improvement and probably within error margins. I ran this again and this ran in 19630ms so it really is faster.
     */
    private  int squareSubmatrixTopDown(boolean[][] matrix, int i, int j, int[][] cache){
        // Base case at bottom right of matrix
        if(matrix.length == i || matrix[0].length == j){
            return 0;
        }

        // If the cell is false then it's not part of a valid submatrix
        if(!matrix[i][j]){
            return 0;
        }

        // If the value is set in the cache then let's return that, otherwise we will set the cache
        if(cache[i][j] > 0){
            return cache[i][j];
        }

        cache[i][j]  = 1 + Math.min(Math.min(squareSubmatrixNaive(matrix, i+1, j), squareSubmatrixNaive(matrix, i, j+1)), squareSubmatrixNaive(matrix, i+1, j+1));

        return cache[i][j];
    }

    /*
    This ran basically instantly and is actually both time and space O(n + m)
     */
    public int squareSubmatrixBottomUp(boolean[][] matrix){
        int maxSize = 0;

        int[][] cache = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                /* If we're in the first row/column then the value is just 1 if that cell is true and 0 otherwise. In any other rows and columns need to loop up and to the left. so like my beautiful diagram below
                TFF     100
                FTT     011
                FTT     012

                It will grab the minimum sum of the possible values

                 */
                if(i == 0 || j == 0){
                    cache[i][j] = matrix[i][j] ? 1 : 0;
                } else if(matrix[i][j]){
                    cache[i][j] = 1 + Math.min(Math.min(cache[i][j-1], cache[i-1][j]), cache[i-1][j-1]);
                }
                maxSize = Math.max(cache[i][j], maxSize);
            }
        }

        return maxSize;
    }

}
