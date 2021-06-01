
public class MinHeap{
    int maxSize;
    int size; 
    int[] heap;
    public MinHeap(int size){
        this.maxSize = size;
        this.size = 0;
        this.heap = new int[size+1];
        heap[0] = Integer.MIN_VALUE;
    }

    public int parent(int pos){
        return pos/2;
    }

    public int leftChild(int pos){
        return pos * 2;
    }

    public int rightChild(int pos){
        return pos*2 + 1;
    }

    public boolean isLeaf(int pos){
        if(pos>= size/2 && pos <=size)
            return true;
        return false;
    }

    public void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public void insert(int num){
        if(size < maxSize){
            size++;
            heap[size] = num;

            int curPos = size;
            while(heap[curPos] < heap[parent(curPos)]){
                swap(curPos, parent(curPos));
                curPos = parent(curPos);
            }
        }
    }

    public void minHeapify(int pos){
        if(!isLeaf(pos)){
            if(heap[leftChild(pos)] < heap[pos] || heap[rightChild(pos)] < heap[pos]){
                if(heap[leftChild(pos)] < heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else{
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void minHeap(){
        for(int i = size/2; i>=1 ; i--)
            minHeapify(i);
    }

    public int remove(){
        int element = heap[1];
        heap[1] = heap[size];
        size--;
        return element;
    }
}