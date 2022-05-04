package com.dsa;

import java.util.Arrays;

public class BinaryHeap {
    int[] arr;
    int size;
    int heapCapacity;
    public BinaryHeap(int capacity) {
        arr = new int[capacity];
        heapCapacity = capacity;
        size = 0;
        Arrays.fill(arr, -1);
    }

    public void doArrange(int currKeyPlace) {
        int currIndex = currKeyPlace;
        for(int i = currKeyPlace; i>=0 && arr[i] != -1;i = (i%2 != 0 ? (i/2) : (i/2)-1)) {
            if(arr[i]>arr[currIndex]) {
                int temp = arr[i];
                arr[i] = arr[currIndex];
                arr[currIndex] = temp;
                currIndex = i;
            }
        }
    }

    public void insertKey(int key) {
        if(size == heapCapacity) {
            System.out.println("Capacity has exceeded");
            return;
        }
        System.out.println("Before Insert -> "+ Arrays.toString(arr));
        arr[size] = key;
        doArrange(size);
        size++;
        System.out.println("After Insert -> "+ Arrays.toString(arr));
    }

    public int leftChild(int pos) {
        return 2*pos + 1;
    }
    public int rightChild(int pos) {
        return 2*pos + 2;
    }
    public void swap(int[] arr, int firstElement, int secondElement) {
        int temp = arr[firstElement];
        arr[firstElement] = arr[secondElement];
        arr[secondElement] = temp;
    }

    public void doArrangeFromTop(int pos) {
        int leftChild = leftChild(pos);
        int rightChild = rightChild(pos);
        if(leftChild < size && arr[leftChild] < arr[pos]) {
            swap(arr, leftChild, pos);
            doArrangeFromTop(leftChild);
        } else if(rightChild < size && arr[rightChild] < arr[pos]) {
            swap(arr, rightChild, pos);
            doArrangeFromTop(rightChild);
        }
    }

    public void removeKey(int indx) {
        if(indx >= size) {
            System.out.println("Not a valid Index ->"+ indx);
            return;
        }
        if(size == 0 || arr[0] == -1){
            System.out.println("Heap is empty");
        }
        System.out.println("Before removal -> "+ Arrays.toString(arr));
        arr[indx] = arr[size-1];
        arr[size-1] = -1;
        size--;
        doArrangeFromTop(indx);
        System.out.println("After removal -> "+ Arrays.toString(arr));
    }

    public int getMin() {
        return arr[0];
    }

    public static void main(String[] args) {
        BinaryHeap bh = new BinaryHeap(12);
        for(int i=0;i<13;i++){
            bh.insertKey(i+1);
        }
        bh.removeKey(0);
        bh.removeKey(5);
        System.out.println(bh.getMin());
    }
}
//Output for above
//    Before Insert -> [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
//        After Insert -> [1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
//        Before Insert -> [1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
//        After Insert -> [1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
//        Before Insert -> [1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
//        After Insert -> [1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1]
//        Before Insert -> [1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1]
//        After Insert -> [1, 2, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1]
//        Before Insert -> [1, 2, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1]
//        After Insert -> [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1, -1]
//        Before Insert -> [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1, -1]
//        After Insert -> [1, 2, 3, 4, 5, 6, -1, -1, -1, -1, -1, -1]
//        Before Insert -> [1, 2, 3, 4, 5, 6, -1, -1, -1, -1, -1, -1]
//        After Insert -> [1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1]
//        Before Insert -> [1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1]
//        After Insert -> [1, 2, 3, 4, 5, 6, 7, 8, -1, -1, -1, -1]
//        Before Insert -> [1, 2, 3, 4, 5, 6, 7, 8, -1, -1, -1, -1]
//        After Insert -> [1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1]
//        Before Insert -> [1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1]
//        After Insert -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -1]
//        Before Insert -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -1]
//        After Insert -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1]
//        Before Insert -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1]
//        After Insert -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
//        Capacity has exceeded
//        Before removal -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
//        After removal -> [2, 4, 3, 8, 5, 6, 7, 12, 9, 10, 11, -1]
//        Before removal -> [2, 4, 3, 8, 5, 6, 7, 12, 9, 10, 11, -1]
//        After removal -> [2, 4, 3, 8, 5, 11, 7, 12, 9, 10, -1, -1]
//        2