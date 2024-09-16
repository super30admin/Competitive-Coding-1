/**
 * @author Vishal Puri
 * // Time Complexity : Insert - O(logn) ExtractMin-O(logn) GetMin - O(1)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this : No
 */

class MinHeap {
    int[] arr;
    int size;
    int MAX_SIZE = 100;

    public MinHeap() {
        this.arr = new int[MAX_SIZE];
        this.size = 0;
    }

    public void insert(int element) {
        if (size == 0) {
            arr[size++] = element;
            return;
        }
        arr[size++] = element;
        percolateUp();
    }

    public int getMin() {
        return (size==0)? Integer.MIN_VALUE : arr[0];
    }

    public void percolateUp() {
        int curr = size - 1;
        int parent;
        while (arr[curr] < arr[(curr - 1) / 2] && curr >= 0) {
            parent = (curr - 1) / 2;
            swap(curr, parent);
            curr = parent;
        }
    }

    public void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void percolateDown() {
        int index =0;
        int x = arr[index];
        int small = 2 * index + 1;
        while (small <= size - 1) {
            if (small < size - 1 && arr[small] > arr[small + 1]) {
                small = small + 1;
            }
            if (x < arr[small]) {
                break;
            }
            arr[index] = arr[small];
            index = small;
            small = 2*index+1;
        }
        arr[index] = x;
    }

    public int extractMin() {
        if (size==0)
            return Integer.MIN_VALUE;
        int min = arr[0];
        arr[0] = arr[size - 1];
        size--;
        percolateDown();
        return min;
    }

    public void printArr(){
        for(int i =0; i <size; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        MinHeap obj = new MinHeap();
        obj.insert(19);
        obj.insert(20);
        obj.insert(21);
        obj.insert(1);
        obj.extractMin();

        obj.printArr();

    }
}
