package com.codedchai.ctci.sortingandsearching;

/*
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args){
        GroupAnagrams groupAnagrams = new GroupAnagrams();

    }

    void sort(String[] array){
        // TODO: Implement HashMapList
   /*     HashMapList<String, List<String>> mapList = new HashMapList<>();
        for(String s : array){
            String key = sortChars(s);
            mapList.put(key, s);
        }

        // Convert hash table to array
        int index = 0;
        for(String key : mapList.keySet()){
            ArrayList<String> list = mapList.get(key);
            for(String t : list){
                array[index] = t;
                index++;
            }
        }
    }

    String sortChars(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);*/
    }

    /*
    First we need to determine if two strings are anagrams of each other. An anagram is two words that have the same letters
    but in different orders. One way to check is if we can put the letters of each string in the same order then they are an anagram.
     */
    public class AnagramComparator implements Comparator<String> {
        public String sortChars(String s){
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        public int compare(String s1, String s2){
            return sortChars(s1).compareTo(sortChars(s2));
        }
    }
}
