package com.codedchai.algorithms;

import java.util.*;

public class ValidateParens {

    public static void main(String[] args){
        List<String> expressions = new ArrayList<>();
        expressions.add("()()[]{{}}");
        expressions.add("(]");
        expressions.add("((((((((())))))))");
        expressions.add("([{{[()]}}])");

        for(String expression : expressions){
            System.out.println(isValidExpression(expression));
        }

    }

    public static boolean isValidExpression(String expression) {

        if(expression.isEmpty()){
            return true;
        }

        char[] expressionChars = expression.toCharArray();

        Stack<Character> expressionStack = new Stack<>();

        for(Character character : expressionChars){

            if(isPushCharacter(character)){
                expressionStack.push(character);
            } else {
                if(!isValidPop(expressionStack.pop(), character)) {
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean isPushCharacter(char character){
        List<Character> pushCharacters = List.of('(', '[', '{');

        return pushCharacters.contains(character);
    }

    public static boolean isValidPop(char characterToPop, char closingCharacter){
        Map<Character, Character> validPairs = new HashMap<>();

        validPairs.put('(', ')');
        validPairs.put('{', '}');
        validPairs.put('[',']');

        if(!validPairs.containsKey(characterToPop)){
            return false;
        }

        return validPairs.get(characterToPop).equals(closingCharacter);
    }


}
