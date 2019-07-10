package com.codedchai.algorithms;

import java.util.*;

public class ReverseNumberWithoutLoop {

    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1234);
        numbers.add(2020);
        numbers.add(1337);
        numbers.add(20);
        numbers.add(0);
        numbers.add(-1);
        numbers.add(50595051);

        for(Integer number : numbers){
            reverse(number);
        }


    }

    static void reverse(int number){
        reverse(number, 0);
    }

    static void reverse(int number, int reverseNumber){
        if(number <= 0){
            System.out.println("Reversed Number: " + reverseNumber);
            return;
        }

        int remainder = number % 10;
        reverseNumber *= 10;
        reverseNumber += remainder;
        number /= 10;
        reverse(number, reverseNumber);

    }

}
