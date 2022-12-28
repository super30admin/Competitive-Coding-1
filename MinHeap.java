// MinHeap Implementation
public class MinHeap{
    int[] heap;
    int size;
    int maxSize;
    
    public MinHeap(int maxSize){
        this.maxSize = maxSize;
        heap = new int[maxSize];
        this.size = 0;
    }

    public static void main(String[] args){
        MinHeap minHeap = new MinHeap(6);
        System.out.println(minHeap.getMin());
        int[] arr = {15,28,16,32,31,20};
        for (int n : arr){
            minHeap.insert(n);
            System.out.println("Size "+minHeap.getSize());
            minHeap.print();
        }
        for (int n : arr){
            int temp = minHeap.remove();
            System.out.println("Removed "+ temp);
            System.out.println("Size "+minHeap.getSize());
            minHeap.print();
        }
    }


    public void print(){
        for (int n : heap){
            System.out.print(n +", ");
        }
        System.out.println();
    }

    public int getMin(){
        return heap[0];
    }

    public void insert(int num){
        heap[size] = num;
        size++;
        bubbleUp(size-1);
    }

    public int getSize(){
        return size;
    }

    public int remove(){
        int temp = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = temp;  
        size--;
        bubbleDown(0);
        return temp;
    }

    public void bubbleUp(int index){
        if (index ==0){
            return;
        }
        int p = (index-1)/2;
        if (p >=0 && heap[index] < heap[p]){
            int temp = heap[index];
            heap[index] = heap[p];
            heap[p] = temp; 
            bubbleUp(p);
        }
    }

    public void bubbleDown(int index){
        int left = 2*index +1;
        int right = 2*index +2;
        int temp = index;
        if (left < getSize() && heap[left] < heap[temp]) {
            temp = left;
        }
        if (right < getSize() && heap[right] < heap[temp]) {
            temp = right;
        }
        if (temp == index) return;

        int nn = heap[index];
        heap[index] = heap[temp];
        heap[temp] = nn; 
        bubbleDown(temp);
    }

}
