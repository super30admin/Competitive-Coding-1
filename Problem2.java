import java.util.Arrays;

class Heap{
    int size=0;
    int capacity = 10;
    int[] heap;

    public Heap(){
        heap = new int[capacity]; 
    }

    private void swap(int i, int j){
        int temp;
        temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int getMin(){
        if(size>0){
            return heap[0];
        }
        else{
            return -1;
        }
    }

    private int getMinChildIndex(int i){
        int l = 2*i + 1;
        int r = 2*i + 2;
        int min_idx = -1;

        if(l>size-1){
            return min_idx;
        }
        else{
            min_idx = l;
        }
        if(r>size-1){
            return min_idx;
        }
        else if (heap[r]<heap[l]){
            min_idx = r;
        }
        return min_idx;
    }

    private void heapifyDown(){
        int i = 0;
        int c_idx = getMinChildIndex(i);
        
        while(c_idx!=-1 && heap[i]>heap[c_idx]){
            swap(i, c_idx);
            i = c_idx;
            c_idx = getMinChildIndex(i);
        }
    }

    public int extractMin(){
        if(size>0){
            int item = heap[0];
            swap(0, size-1);
            heapifyDown();
            return item;
        }
        else{
            return -1;
        }
    }

    private void increaseCapacity(){
        heap = Arrays.copyOf(heap, capacity+10);
        capacity += 10;
    }

    private int getParentIndex(int i){
        return (i-1)/2;
    }

    private void heapifyUp(){
        int i = size-1;
        int p = getParentIndex(i);

        while(p>=0 && heap[p]>heap[i]){
            swap(i, p);
            i = p;
            p = getParentIndex(i);
        }
    }

    public void insert(int x){
        if(size==capacity){
            increaseCapacity();
        }
        size+=1;
        heap[size-1] = x;
        heapifyUp();
    }
}

public class Problem2{
    public static void main(String args[]){
        Heap heap = new Heap();
        heap.insert(5);
        heap.insert(7);
        heap.insert(2);
        heap.insert(8);
        heap.insert(3);
        heap.insert(4);
        heap.insert(6);
        System.out.println("Min element "+heap.getMin());
        System.out.println("Extracted element "+heap.extractMin());
        System.out.println("Min element "+heap.getMin());
        heap.insert(1);
        System.out.println("Min element "+heap.getMin());
    }
}