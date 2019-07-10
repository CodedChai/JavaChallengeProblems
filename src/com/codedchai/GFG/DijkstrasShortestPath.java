package com.codedchai.GFG;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstrasShortestPath {


    static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int numVertices;
        LinkedList<Edge>[] adjacencyList;

        public Graph(int numVertices){
            this.numVertices = numVertices;
            adjacencyList = new LinkedList[numVertices];
            for(int i = 0; i < numVertices; i++){
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight){
            Edge edge = new Edge(source, destination, weight);
            adjacencyList[source].addFirst(edge);

            // This is for an undirected graph
            edge = new Edge(destination, source, weight);
            adjacencyList[destination].addFirst(edge);

        }

        public void dijkstra(int sourceVertex){
            boolean[] shortestPathTree = new boolean[numVertices];

            int[] distFromVertToSrc = new int[numVertices];

            for(int i = 0; i < numVertices; i++){
                distFromVertToSrc[i] = Integer.MAX_VALUE;
            }

            // Override the comparator to do the sorting based on keys

            PriorityQueue<AbstractMap.SimpleEntry<Integer,Integer>> priorityQueue = new PriorityQueue<>(numVertices, new Comparator<AbstractMap.SimpleEntry<Integer, Integer>>() {
                @Override
                public int compare(AbstractMap.SimpleEntry<Integer, Integer> o1, AbstractMap.SimpleEntry<Integer, Integer> o2) {
                    return o1.getKey() - o2.getKey();
                }
            });

            // Find distance at first location. This is going to be 0 since we are already there. Also make the pair
            distFromVertToSrc[0] = 0;
            AbstractMap.SimpleEntry startingPoint = new AbstractMap.SimpleEntry(distFromVertToSrc[0], 0);

            priorityQueue.offer(startingPoint);

            while(!priorityQueue.isEmpty()){
                // Grab the current minimum
                AbstractMap.SimpleEntry<Integer, Integer> extractedMin = priorityQueue.poll();

                int extractedVertex = extractedMin.getValue();
                if(!shortestPathTree[extractedVertex]){
                    shortestPathTree[extractedVertex] = true;


                    LinkedList<Edge> edges = adjacencyList[extractedVertex];
                    for(Edge edge : edges){
                        int destination = edge.destination;

                        if(!shortestPathTree[destination]){
                            // Check to see if the distance needs to be updated or not. So check the total weight from the source to vertex v is less than
                            int newKey = distFromVertToSrc[extractedVertex] + edge.weight;
                            int currentKey = distFromVertToSrc[destination];

                            if(currentKey > newKey){
                                AbstractMap.SimpleEntry<Integer, Integer> shorterPath = new AbstractMap.SimpleEntry<>(newKey, destination);
                                priorityQueue.offer(shorterPath);
                                distFromVertToSrc[destination] = newKey;
                            }
                        }
                    }
                }
            }

            printDijkstra(distFromVertToSrc, sourceVertex);

        }

        public void printDijkstra(int[] distance, int sourceVertex){
            System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
            for (int i = 0; i < numVertices ; i++) {
                System.out.println("Source Vertex: " + sourceVertex + " to vertex " +  i +
                        " distance: " + distance[i]);
            }
        }


    }



    public static void main(String[] args){

        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.dijkstra(0);
    }


}
