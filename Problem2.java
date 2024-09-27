
//Min heap
//Time complexity for getting min element is o(1), extractMin o(logn), insertion o(logn)
//space complexity o(1)

public class MinHeap{
    
    private int[] heap;
    private int size;
    private int maxSize;
    private static final int TOP = 1;
    
    public MinHeap(int maxSize){
        this.maxSize = maxSize;
        size = 0;
        heap = new int[maxSize + 1];
        heap[0] = Integer.MIN_VALUE;
    }
    
    private void MinHeapify(int pos){
        if(pos >= size/2 && pos<=size)
            return;
            
        if(heap[pos] > heap[2*pos] || heap[pos] > heap[2*pos + 1]){
            if(heap[2*pos] < heap[2*pos + 1])
            {
                swap(pos,2*pos);
                MinHeapify(2*pos);
            }
            else{
                swap(pos,2*pos+1);
                MinHeapify(2*pos+1);
            }
        }
            
    }
    
    private void swap(int a, int b){
        int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
    }
    
    private void insert(int num){
        if(size >= maxSize)
            return;
        heap[++size] = num;
        int curpos = size;
        //according to heap property, parent element shoeld be less than child elements
        while(heap[curpos]<heap[parent(curpos)]){
            //swapping of elements
            swap(curpos,parent(curpos));
            
            curpos = parent(curpos);
        }
    }
    
    private int parent(int pos){
        return pos/2;
    }
    
    public int extractMin(){
        int min = heap[TOP];
        heap[TOP] = heap[size--];
        MinHeapify(TOP);
        
        return min;
    }
    
    private void minheap(){
        for(int i = size/2; i>=1; i--){
            MinHeapify(i);
        }
    }

     public static void main(String []args){
         MinHeap m = new MinHeap(10);
         m.insert(8);
         m.insert(3);
         m.insert(18);
         m.insert(32);
         m.insert(6);
         m.insert(20);
         m.insert(1);
         m.minheap();
        System.out.println("min Number: "+ m.extractMin());
        System.out.println("min Number: "+ m.extractMin());
     }
}
