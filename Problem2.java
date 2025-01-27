// Design Min Heap

// Time Complexity : O(logn) - binary search
// Space Complexity : O(1) - constant
// Any problem you faced while coding this : yes, I did not get the idea on how to implement. Even after refering to the source code, I could not completely code it myself.
// If possible please explain this in class.

/*
 * As far as my understanding, min heap is a binary tree which as min elements as roots. While we take the element as input we try to make smaller elements to remain
 * in top positions. For making it happen, we find left child, right child of position and we keep finding the smaller among parent, left child and right child. This
 * happends recursively.
 */



class Solution{
    int []Heap;
    int size;
    int maxCapacity;

    public Solution(int capacity){
        this.maxCapacity = capacity;
        this.size = 0;
        this.Heap = new int[capacity];
    }

    // find parent of a node
    private int parent(int pos){
        return (pos-1)/2;
    }

    // finds the left child a node
    private int leftChild(int pos){
        return (2*pos)+1;
    }

    // finds the right child of a node
    private int rightChild(int pos){
        return (2*pos)+2;
    }

    // checks if a node is leaf or not
    private boolean isLeaf(int pos){
        if(pos >= size/2 && pos < size){
            return true;
        }
        else{
            return false;
        }
    }

    private void swap(int fpos, int spos){
        int temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    private void minHeap(int pos){
        if(!isLeaf(pos)){
            int left = leftChild(pos);
            int right = rightChild(pos);
            int smallestNumber = pos;

            if(left < size && Heap[left] < Heap[smallestNumber]){
                smallestNumber = left; 
            }
            if(right < size && Heap[right] < Heap[smallestNumber]){
                smallestNumber = right;
            }

            if(smallestNumber != pos){
                swap(pos,smallestNumber);
                minHeap(smallestNumber);
            }
        }
    }

    public void insert(int element){
        if(size == maxCapacity) return;

        Heap[size] = element;
        int current = size;
        size ++;

        while(current>0 && Heap[current] < Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int remove(){
        if(size == 0) return -1;

        int min = Heap[0];
        Heap[0] = Heap[size-1];
        size--;

        minHeap(0);
        return min;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(Heap[i] + " ");
        }
        System.out.println();

}

}



