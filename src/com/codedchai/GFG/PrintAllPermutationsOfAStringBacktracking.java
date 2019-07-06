package com.codedchai.GFG;

public class PrintAllPermutationsOfAStringBacktracking {

    public static void main(String[] args){

        String string = "connor";
        printPermutations(string);

    }

    static void printPermutations(String string){
        printPermutations(string, "");
    }

    static void printPermutations(String string, String output){
        if(string == null || string.length() == 0){
            System.out.println(output + " " );
        }

        int index = 0;
        for(Character character : string.toCharArray()){
            String stringWithoutCharacter = string.substring(0, index) + string.substring(index + 1);
            index++;
            printPermutations(stringWithoutCharacter, output + character);
        }
    }

}
