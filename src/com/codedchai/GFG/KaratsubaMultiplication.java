package com.codedchai.GFG;

public class KaratsubaMultiplication {

    /*
    Given two binary strings, find the product of them and output in decimal format. Normally this is an O(n^2) process since you go through each bit. However, Karatsuba's uses divide and conquer so it is faster.
     */


    /*
    For some reason this implementation isn't working. I'm not going to worry too much about it though. Feel free to fix it and submit a pull request.
     */
    public static void main(String[] args){

        KaratsubaMultiplication multiplication = new KaratsubaMultiplication();

        StringBuilder X = new StringBuilder();
        X.append("10");
        StringBuilder Y = new StringBuilder();
        Y.append("101");
        System.out.println(multiplication.karatsubaMultiply(X, Y));


    }

    int multiplySingleBit(String X, String Y){
        return (X.toCharArray()[0] - '0')*(Y.toCharArray()[0] - '0');
    }

    /*
    Append 0s to the front to make the strings the same length
     */
    int makeSameLength(StringBuilder X, StringBuilder Y){
        int len1 = X.length();
        int len2 = Y.length();

        if(len1 < len2){
            for(int i = 0; i < len2 - len1; i++){
                String temp = X.toString();
                X.delete(0, len1).append("0" + temp);
            }
            return  len2;
        } else if(len2 < len1){
            for(int i = 0; i < len1 - len2; i++){
                String temp = Y.toString();
                Y.delete(0, len1).append("0" + temp);
            }
            return  len1;
        }

        return len1;
    }

    StringBuilder addBitStrings(StringBuilder X, StringBuilder Y){

        String result = "";

        int length = makeSameLength(X, Y);
        if(length == 0){
            return new StringBuilder(result);
        }
        int carry = 0;

        // Add all bits one by one
        for(int i = length - 1; i >=0; i--){
            int firstBit = X.toString().toCharArray()[i] - '0';
            int secondBit = Y.toString().toCharArray()[i] - '0';

            // Sum of three bits
            int sum = (firstBit ^ secondBit ^ carry) + '0';

            result = (char)sum + result;

            carry = (firstBit & secondBit) | (secondBit & carry ) | (firstBit & carry);

        }
        if(carry == 1){
            result = '1' + result;
        }

        return new StringBuilder(result);
    }

    long karatsubaMultiply(StringBuilder X, StringBuilder Y){
        /* Make the strings the same length and find the maximum length */
        int length = makeSameLength(X, Y);

        if(length == 0){
            return 0;
        }

        if(length == 1){
            return multiplySingleBit(X.toString(), Y.toString());
        }

        int firstHalf = length / 2; // First half of string, floor(n/2)
        int secondHalf = length - firstHalf; // Second half of string, ceil(n/2)

        String XLeft = X.substring(0, firstHalf);
        String XRight = X.substring(firstHalf, secondHalf);

        String YLeft = Y.substring(0, firstHalf);
        String YRight = Y.substring(firstHalf, secondHalf);

        long P1 = karatsubaMultiply(new StringBuilder(XLeft), new StringBuilder(YLeft));
        long P2 = karatsubaMultiply(new StringBuilder(XRight), new StringBuilder(YRight));
        long P3 = karatsubaMultiply(addBitStrings(new StringBuilder(XLeft), new StringBuilder(XRight)), addBitStrings(new StringBuilder(YLeft), new StringBuilder(YRight)));

        return P1*(1<<(2*secondHalf)) + (P3 - P1 - P2) * (1<<secondHalf) + P2;
    }

}
