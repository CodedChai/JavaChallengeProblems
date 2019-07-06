package com.codedchai.GFG;

public class TSPBacktracking {

    public static void main(String[] args){

        int numNodes = 4;
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0},
        };


        boolean[] visited = new boolean[numNodes];

        System.out.println(TSP(graph, visited, 0, numNodes, 1, 0, Integer.MAX_VALUE));

    }


    public static int TSP(int[][] graph, boolean[] visited, int currentPosition, int numNodes, int depth, int cost, int answer){

        /*
        If last node is reached and it has a link to the starting node keep the minimum value out of the total cost of traversal
         */

        if(depth == numNodes && graph[currentPosition][0] > 0){
            return Math.min(answer, cost + graph[currentPosition][0]);
        }

        /*
        Backtracking: loop to traverse the adjacency list of currentPosition node and increase the depth by 1 and the cost by graph[currPosition][i] value
         */

        for(int i = 0; i < numNodes; i++){
            if(!visited[i] && graph[currentPosition][i] > 0){
                visited[i] = true;
                answer = TSP(graph, visited, i, numNodes, depth+1, cost + graph[currentPosition][i], answer);
                visited[i] = false;
            }
        }
        return answer;
    }

}
