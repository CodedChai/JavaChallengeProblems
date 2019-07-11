package com.codedchai.leetcode;

import java.util.List;
import java.util.PriorityQueue;

public class MegeKSortedLists {

    public static void main(String[] args){
        List<Integer> list1 = List.of(1,3,4,6,7,8);
        List<Integer> list2 = List.of(2,4,5,6,7,9,10);
        List<Integer> list3 = List.of(5, 11);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int element : list1){
            priorityQueue.offer((element));
        }

        for(int element : list2){
            priorityQueue.offer((element));
        }
        for(int element : list3){
            priorityQueue.offer((element));
        }

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }

    }


}
