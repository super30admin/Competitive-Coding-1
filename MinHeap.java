// Time Complexity : O(logn) Insert, Remove | O(1) getMin, getSize
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (On GeeksForGeeks)
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.Collections;

class MinHeap {

    private ArrayList<Integer> minHeap;

    public MinHeap() {
        this.minHeap = new ArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getSize(); i++) {
            sb.append(" Idx: " + i + " Ele: " + this.minHeap.get(i));
        }
        return sb.toString();
    }

    public Integer getMinimum() {
        return this.minHeap.get(0);
    }

    public Integer getSize() {
        return this.minHeap.size();
    }

    public void insert(int element) {
        this.minHeap.add(element);
        this.__bubbleUp(this.getSize() - 1);
    }

    public void remove() {
        this.__swap(0, this.getSize() - 1);
        int temp = this.minHeap.remove(this.getSize() - 1);
        this.__bubbleDown(0);
    }

    private void __swap(int index1, int index2) {
        Collections.swap(this.minHeap, index1, index2);
    }

    private void __bubbleUp(int index) {
        if (index == 0) {
            return;
        }
        int parent = (index - 1) / 2;
        if (parent >= 0 &&
                this.minHeap.get(index) < this.minHeap.get(parent)) {
            this.__swap(index, parent);
            this.__bubbleUp(parent);
        }
    }

    private void __bubbleDown(int index) {
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        int temp = index;
        if (left < this.getSize() 
            && this.minHeap.get(left) < this.minHeap.get(index)) {
            temp = left;
        }
        if (right < this.getSize() 
            && this.minHeap.get(right) < this.minHeap.get(index)) {
            temp = right;
        }
        if (temp == index) {
            return;
        }
        this.__swap(index, temp);
        this.__bubbleDown(temp);
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        int[] arr = new int[]{15, 28, 16, 32, 31, 20};

        for (int i = 0; i < arr.length; i++) {
            minHeap.insert(arr[i]);
            System.out.println(minHeap.toString());
        }

        for (int i = 0; i < arr.length; i++) {
            minHeap.remove();
            System.out.println(minHeap.toString());
        } 
    }

}