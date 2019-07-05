package com.codedchai.DailyCodingProblem;

public class FindingTwoNumbersWithOddOccurrences {

    public static void main(String[] args){
        int[] array = {4,2,4,5,2,3,3,1,1,1,};

        printTwoOdd(array);
    }


    static void printTwoOdd(int[] array){
        int length = array.length;

        /*
        XOR of the two odd elements
         */

        int xor2 = array[0];

        int setBitNumber;
        int n = length - 2;
        int x = 0, y = 0;

        for(int i = 1; i < length; i++) {
            xor2 ^= array[i];
        }
        /* get one set bit in the xor2. We get the rightmost set bit in the following line as it is easy to get. */
        setBitNumber = xor2 & ~ (xor2 - 1);

        /*
        Now divide the elements into two sets:
        1) The elements having the corresponding bit as 1
        2) The elements having the corresponding bit as 0
         */

        for(int i = 0; i < length; i++){
            if((array[i] & setBitNumber ) > 0 ) {
                x ^= array[i];
            } else {
                y ^= array[i];
            }
        }

        System.out.println("The two ODD elements are " +  x + " & " + y);
    }

}
