class MinHeap{
     private int[] Heap;
     private int size;
     private int maxSize;

     private static final int FRONT = 1;

     public MinHeap(int maxSize){
           this.maxSize = maxSize;
           this.size = 0;

           Heap = new int[this.maxSize+1];
           Heap[0] = Integer.MIN_VALUE;
     }

     private int parent(int pos){
        return pos/2;
     }

     private int leftChild(int pos){
        return pos*2;
     }
     private int rightChild(int pos){
        return (pos*2)+1;
     }
     private boolean isLeaf(int pos){
        if(pos > (size/2)) return true;
        else return false;
     }

     private void swap(int pos1,int pos2){
        int temp = Heap[pos1];
        Heap[pos1] = Heap[pos2];
        Heap[pos2] = temp;
     }

     private void minHeapify(int pos){
        if(!isLeaf(pos)){
            int swapPos = pos;
            if(rightChild(pos)<= size){
                swapPos = Heap[leftChild(pos)] < Heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
            }else{
                swapPos = leftChild(pos);
            }

            if(Heap[pos] > Heap[rightChild(pos)] || Heap[pos] > Heap[leftChild(pos)]){
                swap(pos, swapPos);
                minHeapify(swapPos);
            }

        }
     }

     public void insert(int element){
        if(size >= maxSize){
            return;
        }
        Heap[++size] = element;
        int current = size;

        while(Heap[current] < Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }

     }

     public void print(){
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                " PARENT : " + Heap[i]
                + " LEFT CHILD : " + Heap[2 * i]
                + " RIGHT CHILD :" + Heap[2 * i + 1]);

            System.out.println();
        }
     }

     public int remove(){
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
     }

     public static void main(String[] arg)
    {
 
    
        System.out.println("The Min Heap is ");
 
       
        MinHeap minHeap = new MinHeap(15);
 
        
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
 
      
        minHeap.print();
 
        System.out.println("The Min val is "
                           + minHeap.remove());
    }


}