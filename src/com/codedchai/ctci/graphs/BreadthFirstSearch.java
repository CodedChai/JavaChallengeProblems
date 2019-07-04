package com.codedchai.ctci.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BreadthFirstSearch {


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

    public boolean hasPathBFS(Node source, Node destination){
        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(source);

        while(!nextToVisit.isEmpty()){
            Node node = nextToVisit.removeFirst();
            System.out.println("Visiting: " + node.id);
            if(node == destination){
                return true;
            }

            if(visited.contains(node.id)){
                continue;
            }

            visited.add(node.id);

            for(Node childNode : node.adjacent){
                nextToVisit.add(childNode);
            }

        }
        return false;
    }


    public static void main(String[] args){
        BreadthFirstSearch bfs = new BreadthFirstSearch();

        bfs.init();

        System.out.println(bfs.hasPathBFS(bfs.nodeLookup.get(0), bfs.nodeLookup.get(5)));

    }
}
