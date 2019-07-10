package com.codedchai.dynamicprogramming;

public class LongestPalindrome {

    /*
    A palindrome is a word that reads the same backwards and forwards. Specifically, we say a sequence of characters is a palindrome if the sequence remains unchanged when reversed. Given a string, determine the length of the longest palindrome in the string.
     */

    public static void main(String[] args){
        /* This consists of the palindromes racecar, carac and ashsa */
        String palindrome = "racecaracashsa";

        LongestPalindrome longestPalindrome = new LongestPalindrome();

        System.out.println(longestPalindrome.longestPalindrome(palindrome));

    }

    public int longestPalindrome(String string){

        if(string.length() <= 1){
            return 1;
        }

        for(int stringLength = string.length(); stringLength >= 0; stringLength--){

            for(int startingPosition = 0; startingPosition <= stringLength - stringLength; startingPosition++){
                if(isPalindrome(string.substring(startingPosition, startingPosition + stringLength))){
                    return stringLength;
                }
            }
        }

        return -1;
    }


    public boolean isPalindrome(String string){

        int length = string.length();

        if(length <= 1){
            return true;
        }

        return ( string.toCharArray()[0] == string.toCharArray()[length - 1] ) && isPalindrome(string.substring(1, length - 1));

    }

}
