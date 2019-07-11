package com.codedchai.leetcode;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;


public class WordLadder {

    public static void main(String[] args){
        WordLadder wordLadder = new WordLadder();


        ArrayList<String> wordList = new ArrayList(List.of("dog", "hog", "log", "cog", "fog", "dig", "don", "hit", "lol"));

        System.out.println("Total length: " + wordLadder.ladderLength("dog", "log", wordList));
        System.out.println("Total length: " + wordLadder.ladderLength("dog", "hit", wordList));
        System.out.println("Total length: " + wordLadder.ladderLength("dog", "lol", wordList));

    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList){


        Queue<SimpleEntry<String, Integer>> searchQueue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();

        searchQueue.add( new SimpleEntry<>(beginWord, 1));
        visited.put(beginWord, true);

        HashMap<String, ArrayList<String>> allPossibleVisitations = new HashMap<>();

        for(String word : wordList){
            allPossibleVisitations.put(word, getPossibleVisitationsForWord(word, wordList));
        }


        while(!searchQueue.isEmpty()){

            SimpleEntry<String, Integer> currentSearch = searchQueue.poll();

            System.out.println("Visiting word: " + currentSearch.getKey() + " at depth: " + currentSearch.getValue());

            if(currentSearch.getKey().equalsIgnoreCase(endWord)){
                return currentSearch.getValue();
            }

            ArrayList<String> possibleNewEntries = allPossibleVisitations.get(currentSearch.getKey());

            for(String word : possibleNewEntries){

                if(!visited.containsKey(word)){
                    searchQueue.add(new SimpleEntry<>(word, currentSearch.getValue() + 1));
                    visited.put(word, true);
                }
            }
        }
        return -1;
    }


    public ArrayList<String> getPossibleVisitationsForWord(String word1, List<String> wordList){

        ArrayList<String> possibleVisitations = new ArrayList<>();

        for(String word2 : wordList){
            if(wordsAreNextToEachOther(word1, word2)){
                possibleVisitations.add(word2);
            }
        }

        return possibleVisitations;

    }


    public boolean wordsAreNextToEachOther(String word1, String word2){
        int differences = 0;

        if(word1.length() != word2.length()){
            return false;
        }

        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                differences++;
            }
        }

        return differences == 1;

    }

}
