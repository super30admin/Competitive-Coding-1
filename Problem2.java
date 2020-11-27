class MinHeap{

    private int[] heap; 
    private int maxsize;
    private int size;

    public MinHeap(int maxsize){
        this.heap = new int[maxsize];
        this.maxsize = maxsize;
        this.size = 0;
    }

    private int parent(int index){
        return (index-i)/2;
    }

    private int leftChild(int index){
        return 2*index+1;
    }

    private int rightChild(int index){
        return 2*index+2;
    }

    private boolean isEmpty(){
        return this.size == 0;
    }

    public int getMin(){
       return heap[0];
    }

    public int extractMin(){
     int min = -1;
     if(!isEmpty()){
       min = heap[0];
       heap[0] = heap[size];
       size--;
       sinkDown(0);
     }
      return min; 
    }

    public void insert(int value){
      if(this.size == maxsize){
          System.out.println("MAXIMUM SIZE REACHED");
          return;
      }
      this.size++;
      heap[size] = value;
      bubbleUp();
    }

    private void sinkDown(int index){
        int smallest = index;
        if(size>=2*index+1 && heap[smallest] > heap[leftChild(index)]){
           smallest = leftChild(index);
        }
        if(size>=2*index+2 && heap[smallest] > heap[rightChild(index)]){
           smallest = rightChild(index);
        }
        if(smallest != index){
            swap(index,smallest);
            sinkDown(smallest);
        }

    }

    private void bubbleUp(){
      int pos = this.size;
       while(pos>0 && heap[parent(pos)] > heap[pos]){
           swap(pos,parent(pos));
           pos = parent(pos);
       }
    }

    private void swap(int idx1, int idx2){
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }

}
