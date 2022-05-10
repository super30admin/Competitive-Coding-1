
public class MinHeap{
    int[] heap;
    int capacity;
    int size;
    private static final int front = 1; 
    public MinHeap(int capacity){
        this.capacity=capacity;
        this.size = 0;
        heap = new int[this.capacity + 1]; //first element is not used.
        heap[0]=Integer.MIN_VALUE;
    }

    private int parent(int pos){
        return pos/2;
    }

    private int leftchild(int pos){
        return 2*pos;
    }

    private int rightchild(int pos){
        return 2*pos+1;
    }

    private void swap(int pos1,int pos2){
        int temp;
        temp = heap[pos1];
        heap[pos1]=heap[pos2];
        heap[pos2]=temp;
    }

    private boolean isLeaf(int pos){
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false;
    }

    private void minHeapify(int pos){
        if(!isLeaf(pos)){
            if(heap[pos] > heap[leftchild(pos)] || heap[pos] > heap[rightchild(pos)] ) {
                if(heap[leftchild(pos)] < heap[rightchild(pos)]){
                    swap(pos,leftchild(pos));
                    minHeapify(leftchild(pos));
                }
                else{
                    swap(pos,rightchild(pos));
                    minHeapify(rightchild(pos));
                }
            }
        }
    }

    public void insert(int element){
        if(size>=capacity){
            return;
        }
        heap[++size]=element;
        int curr = size;
        while(heap[curr]<heap[parent(curr)]){
            swap(curr,parent(curr));
            curr=parent(curr);
        }
    }

    public void minHeap() 
    { 
        for (int pos = (size / 2); pos >= 1; pos--) { 
            minHeapify(pos); 
        } 
    } 
    public int remove() 
    { 
        int poppedelement = heap[front]; 
        heap[front] = heap[size--]; 
        minHeapify(front); 
        return poppedelement; 
    } 

    //maiin fucntion below



}