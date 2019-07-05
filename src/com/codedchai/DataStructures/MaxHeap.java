package com.codedchai.DataStructures;

public class MaxHeap {

    private int[] Heap;
    private int length;
    private int maxLength;

    public MaxHeap(int maxLength){
        this.maxLength = maxLength;
        this.length = 0;
        Heap = new int[this.maxLength + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    // Return position of parent
    private int parent(int position){
        return position / 2;
    }

    private int leftChild(int position){
        return (2 * position);
    }

    private int rightChild(int position){
        return (2 * position) + 1;
    }

    private boolean isLeaf(int position){
        return position >= (length / 2) && position <= length;
    }

    private void swap(int firstPosition, int secondPosition){
        int temp = Heap[firstPosition];
        Heap[firstPosition] = Heap[secondPosition];
        Heap[secondPosition] = temp;
    }

    private void maxHeapify(int position){
        if(isLeaf(position)){
            return;
        }

        if(Heap[position] < Heap[leftChild((position))] || Heap[position] < Heap[rightChild(position)]){
            if(Heap[leftChild(position)] > Heap[rightChild(position)]){
                swap(position, leftChild(position));
                maxHeapify(leftChild(position));
            }else {
                swap(position, rightChild(position));
                maxHeapify(rightChild(position));
            }
        }

    }

    public void insert(int element){
        Heap[++length] = element;

        // Traverse up and fix the violated property
        int currentIndex = length;
        while(Heap[currentIndex] > Heap[parent(currentIndex)]){
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public void print(){
        for(int i = 1; i <= length / 2; i++){
            System.out.print(" Parent : " + Heap[i] + " LEFT CHILD : " + Heap[leftChild(i)] + " RIGHT CHILD : " + Heap[rightChild(i)]);
            System.out.println();
        }
    }

    public int popMax(){
        int poppedValue = Heap[1];
        Heap[1] = Heap[length--];
        maxHeapify(1);
        return  poppedValue;
    }

    public static void main(String[] arg)
    {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.popMax());
    }

}
