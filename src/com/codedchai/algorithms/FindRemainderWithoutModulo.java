package com.codedchai.algorithms;

public class FindRemainderWithoutModulo {

    public static void main(String[] args){
        FindRemainderWithoutModulo findRemainderWithoutModulo = new FindRemainderWithoutModulo();

        System.out.println(findRemainderWithoutModulo.remainder(15, 4));
    }

    public int remainder(int number, int divisor){

        if(number < divisor){
            return number;
        }

        return remainder(number - divisor, divisor);

    }


}
