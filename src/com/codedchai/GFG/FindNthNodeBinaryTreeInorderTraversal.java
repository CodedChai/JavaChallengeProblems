package com.codedchai.GFG;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

public class FindNthNodeBinaryTreeInorderTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }

    }

    static int NthInOrder(Node node, int N){
        int count = 1;

        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()){

            Node currentNode = queue.remove();

            if(count == N){
                return currentNode.data;
            }

            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node (30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        System.out.println(NthInOrder(root, 4));
    }

}
