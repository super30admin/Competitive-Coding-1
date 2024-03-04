//TC = o(log n)
//SC = o(n)

public class DesignMinHeap {

    int capacity = 10;
    int size = 0;
    int[] heap = new int[capacity+1];

    public void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public int parent(int i){
        return i/2;
    }

    public int leftChild(int i){
        return 2 * i;
    }

    public int rightChild(int i){
        return 2 * i + 1;
    }

    public boolean isLeafNode(int i){
        if(i > (size/2) && i <= size){
            return true;
        }
        return false;
    }

    public int peek(){
        return heap[1];
    }

    public void add(int data){
        if(size == capacity)return;
        size++;
        heap[size] = data;
        int current = size;
        while(heap[current] < heap[parent(current)] && parent(current) >= 1){
            swap(current, parent(current));
            current = parent(current); // important line to bubble min element up
        }

    }

    public void remove(){
        if(size == 0)return;
        int top = peek();
        int last = heap[size];
        heap[1] = last;
        heap[size] = 0;
        size--;
        heapify(1); // do it from 1st index since we are not storing anything at zero index
        
    }

    public void print(){
        for(int i=0;i<heap.length;i++){
            System.out.println(heap[i]);
        }
    }

    public void heapify(int i){
        if(!isLeafNode(i)){
            if(heap[i] > heap[leftChild(i)] || heap[i] > heap[rightChild(i)]){
                if(heap[leftChild(i)] < heap[rightChild(i)]){
                    swap(i, leftChild(i));
                    heapify(leftChild(i));
                }
                else{
                    swap(i, rightChild(i));
                    heapify(rightChild(i));
                }
            }
            
        }
    }

    public static void main(String[] args) {
        DesignMinHeap m = new DesignMinHeap();
        m.add(3);
        m.add(2);
        m.add(1);
        m.add(-1);
        m.print();
        m.remove();
    }
}
