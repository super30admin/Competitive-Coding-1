//Time Complexity: O(logN)
//Space Complexity: O(1)


import java.util.Arrays;
//creating a minHeap class
public class mHeap {
	private int[] Heap;
    private int size;
    private int maxsize;

    //initalizing the front value as 1
    private static final int FRONT = 1;

    //creating the constructor
    public mHeap(int maxsize){
    	this.maxsize = maxsize;
        this.size = 0; 
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    //root node position
    private int root(int pos) {
        return pos / 2; }

    //left node position in the heap
    private int lChild(int pos){
    	return (2 * pos); }
    
    //right node position in the heap
    private int rChild(int pos){
        return (2 * pos) + 1;}
    
    //for leafnode position
    private boolean isLeaf(int pos){ 
        if (pos > (size / 2) && pos <= size) 
            return true;
        return false;
    }
    //for swapping two nodes of the heap
    private void swap(int node1, int node2){ 
        int tmp = Heap[node1]; 
        Heap[node1] = Heap[node2];
        Heap[node2] = tmp;
    }

    private void minHeapify(int pos){ 
        // a non-leaf node, greater than any of its child
        if (!isLeaf(pos) && (Heap[pos] > Heap[lChild(pos)] || Heap[pos] > Heap[rChild(pos)])) { 
            // Swap with the left child and heapify it
                if (Heap[lChild(pos)]< Heap[rChild(pos)]) {
                    swap(pos, lChild(pos));
                    minHeapify(lChild(pos));
                }

                // Swap with the right child and heapify it
            else {
                swap(pos, rChild(pos));
                minHeapify(rChild(pos));
            }
        }
    }
    //insertion of a node into the heap
    public void insert(int element){ 
        if (size >= maxsize) 
            return;

        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[root(current)]) {
            swap(current, root(current));
            current = root(current);
        }
    }
    //to delete the element
    public int delete() { 
        int popElement = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT); 
        return popElement;
    }

    public void print(){
        for (int i = 1; i <= size / 2; i++) { 
            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + Heap[i]
                + " LCHILD : " + Heap[2 * i]
                + " RCHILD :" + Heap[2 * i + 1]); 
            System.out.println();
        }
    }

	//Main Method
	public static void main(String[] args) {
		mHeap minHeap= new mHeap(30);
		minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(5);
        minHeap.insert(6);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(10);

        minHeap.print();
		System.out.println("Min value to be removed is :"+ minHeap.delete());
		minHeap.print();		
	}	
}