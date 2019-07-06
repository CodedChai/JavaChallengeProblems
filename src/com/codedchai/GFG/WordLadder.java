package com.codedchai.GFG;

import java.util.*;

public class WordLadder {

    /*
    Given a starting word, a target word and a dictionary, change one letter at a time through the dictionary to get to the ending word. We will assume all words are the same length.
     */

    public static void main(String[] args){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("POON");
        dictionary.add("PLEE");
        dictionary.add("SAME");
        dictionary.add("POIE");
        dictionary.add("PLEA");
        dictionary.add("PLIE");
        dictionary.add("POIN");
        dictionary.add("COIN");

        String start = "TOON";
        String target = "PLEA";

        System.out.println(shortestChainLength(start, target, dictionary));

    }

    static boolean isAdjacent(String A, String B){
        int differences = 0;

        for(int i = 0; i < A.length(); i++){
            if(A.toUpperCase().toCharArray()[i] != B.toUpperCase().toCharArray()[i]){
                differences++;
            }
        }
        return  differences == 1;
    }

    static int shortestChainLength(String start, String target, Set<String> dictionary){
        /* A queue of pairs of the word and the current length */
        Queue<AbstractMap.SimpleEntry<String, Integer>> queuePair = new LinkedList<>();

        queuePair.add(new AbstractMap.SimpleEntry<>(start, 1));

        while(!queuePair.isEmpty()){
            AbstractMap.SimpleEntry currentEntry = queuePair.remove();

            System.out.println((String)currentEntry.getKey());

            Set<String> visitedWords = new HashSet<>();

            for(String dictionaryWord : dictionary){

                if(target.equalsIgnoreCase((String)currentEntry.getKey())){
                    return (Integer)currentEntry.getValue();
                }

                if(isAdjacent((String)currentEntry.getKey(), dictionaryWord)){
                    queuePair.add(new AbstractMap.SimpleEntry<>(dictionaryWord, (Integer)currentEntry.getValue() + 1));

                    visitedWords.add(dictionaryWord);

                }
            }

            for(String visitedWord : visitedWords){
                dictionary.remove(visitedWord);
            }


        }
         return  -1;
    }

}
