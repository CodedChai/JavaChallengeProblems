package com.codedchai.GFG;

public class ReplaceWithGreatestFromRightSide {

    public static void main(String[] args){
        int[] array = {16, 17, 4, 3, 5, 2};
        int[] array2 = {16, 17, 4, 3, 5, 2};

        naiveReplaceWithGreatest(array);
        for(int element : array){
            System.out.print(element + ", ");
        }
        System.out.println();
        betterReplaceWithGreatest(array2);
        for(int element : array2){
            System.out.print(element + ", ");
        }

    }

    // O(n)
    public static void betterReplaceWithGreatest(int[] array){
        int currentMax = array[array.length - 1];

        array[array.length - 1] = Integer.MIN_VALUE;

        for(int i = array.length - 2; i >= 0; i--){
            int replacementValue = array[i];

            array[i] = currentMax;

            if(replacementValue > currentMax){
                currentMax = replacementValue;
            }
        }

    }

    // O(n^2)
    public static void naiveReplaceWithGreatest(int[] array){
        int backIndex = 0;
        int currentMax = Integer.MIN_VALUE;

        for(int forwardIndex = 0; forwardIndex < array.length; forwardIndex++){

            // if our currentMax is min value we'll need to set a new one
            if(currentMax == Integer.MIN_VALUE){
                currentMax = array[forwardIndex];
            }

            if(currentMax < array[forwardIndex] || forwardIndex == array.length - 1){
                // get the value we want to put in the array now
                currentMax = array[forwardIndex];
                // Set the location of the old max to min
                array[forwardIndex] = Integer.MIN_VALUE;
                // Update array
                for(int i = backIndex; i < forwardIndex ; i++ ){
                    array[i] = currentMax;
                }
                // update back pointer
                backIndex = forwardIndex;
                // we want to set our current min again
                currentMax = Integer.MIN_VALUE;
            }
        }
    }

}
