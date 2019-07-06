package com.codedchai.GFG;

import java.util.ArrayList;
import java.util.List;

public class MinimumStepsToColorTree {
    static int numChanges = 0;

    public static void main(String[] args){

        List<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= 10; i++){
            graph.add(new ArrayList<>());
        }

        // Zero is for parent of node 1
        int[] color = {0, 1, 2, 3, 2, 2, 3};

        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 2, 5);
        addEdge(graph, 3, 6);

        depthFirstSearch(graph, 1, 0, color);
        System.out.println(numChanges);
    }

    static void addEdge(List<ArrayList<Integer>> graph, int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void depthFirstSearch(List<ArrayList<Integer>> graph, int child, int parent, int[] color){
        if(color[child] != color[parent]){
            numChanges++;
        }

        for(int i = 0; i < graph.get(child).size(); i++){
            if(graph.get(child).get(i) == parent){
                continue;
            }
            depthFirstSearch(graph, graph.get(child).get(i), child, color);
        }
    }

}
