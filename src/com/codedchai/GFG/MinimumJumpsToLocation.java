package com.codedchai.GFG;
import java.util.*;

public class MinimumJumpsToLocation {

    public static void main(String[] args){

        int startingPosition = 10;
        int endingPosition = 8;
        List<Integer> jumpLengths = new ArrayList<>();
        jumpLengths.add(4);
        jumpLengths.add(6);
        jumpLengths.add(3);
        Set<Integer> visited = new HashSet<>();

        System.out.print(findMinimumJumps(startingPosition, endingPosition, jumpLengths, visited));
    }


    public static int findMinimumJumps(int startingPosition, int endingPosition, List<Integer> jumpLengths, Set<Integer> visited){

        if(startingPosition == endingPosition){
            return 0;
        }

        Queue<AbstractMap.SimpleEntry<Integer,Integer>> jumpsToTry = new LinkedList<>();

        jumpsToTry.add(new AbstractMap.SimpleEntry<>(startingPosition, 0));
        visited.add(startingPosition);

        while(!jumpsToTry.isEmpty()){
            AbstractMap.SimpleEntry currentPosition = jumpsToTry.remove();

            int currentPos = (Integer)currentPosition.getKey();
            int currentDepth = (Integer)currentPosition.getValue();
            visited.add(currentPos);

            if(currentPos == endingPosition){
                return currentDepth;
            }

            for(int jumpLength : jumpLengths){
                if(!visited.contains(currentPos + jumpLength)){
                    jumpsToTry.add(new AbstractMap.SimpleEntry<>(currentPos + jumpLength, currentDepth + 1));
                }

                if(!visited.contains(currentPos - jumpLength)){
                    jumpsToTry.add(new AbstractMap.SimpleEntry<>(currentPos - jumpLength, currentDepth + 1));
                }
            }
        }
        return -1;
    }

}
