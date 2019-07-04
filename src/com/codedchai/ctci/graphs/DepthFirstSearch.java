package com.codedchai.ctci.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DepthFirstSearch {

    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();
        private Node(int id){
            this.id = id;
        }
    }

    private Node getNode(int id){
        return nodeLookup.get(id);
    }

    public void addEdge(int source, int destination){
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);
        sourceNode.adjacent.add(destinationNode);
    }


    public void init(){
        Node a = new Node(0);
        nodeLookup.put(0, a);
        Node b = new Node(1);
        nodeLookup.put(1, b);

        Node c = new Node(2);
        nodeLookup.put(2, c);

        Node d = new Node(3);
        nodeLookup.put(3, d);

        Node e = new Node(4);
        nodeLookup.put(4, e);

        Node f = new Node(5);
        nodeLookup.put(5, f);

        Node g = new Node(6);
        nodeLookup.put(6, g);

        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1,3);
        addEdge(3, 4);
        addEdge(2, 5);
    }

    public boolean hasPathDFS(int source, int destination){
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(sourceNode, destinationNode, visited);
    }

    private boolean hasPathDFS(Node sourceNode, Node destinationNode, HashSet<Integer> visited){
        if(visited.contains(sourceNode.id)){
            return false;
        }

        visited.add(sourceNode.id);
        System.out.println("Visiting: " + sourceNode.id);

        if(sourceNode == destinationNode){
            return true;
        }

        for(Node childNode : sourceNode.adjacent){
            if(hasPathDFS(childNode, destinationNode, visited)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        DepthFirstSearch dfs = new DepthFirstSearch();

        dfs.init();

        System.out.println(dfs.hasPathDFS(0, 6));

    }

}
