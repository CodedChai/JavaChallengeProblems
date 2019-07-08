package com.codedchai.DailyCodingProblem;

public class LongestPrefixSuffixOfString {

    /*
    abbabba the longest prefix/suffix is abba
     */

    public static void main(String[] args){
        String S = "ABBABBA";
        String S2 = "CONNOR";
        String S3 = "TEST";

        System.out.println(longestPrefixAndSuffix(S));
        System.out.println(longestPrefixAndSuffix(S2));
        System.out.println(longestPrefixAndSuffix(S3));

    }

    static int longestPrefixAndSuffix(String S){

        for(int i = S.length() - 1; i >= 0; i--){
            String prefix = S.substring(0, i);
            String suffix = S.substring(S.length() - i);
            System.out.println(prefix);
            System.out.println(suffix);

            if(prefix.equalsIgnoreCase(suffix) && !prefix.isEmpty() && !suffix.isEmpty()){
                return prefix.length();
            }

        }

        return -1;

    }

}
