class Heap{
    int size;
    int capacity;
    int heap[];
    public Heap(int capacity){
    this.capacity=capacity;
    this.size=0;
    heap = new int[this.capacity+1];
    }

    int parent(int pos){
        return pos/2;
    }

    int leftChild(int pos){
        return 2*pos;
    }

    int rightChild(int pos){
        return 2*pos+1;
    }

    boolean isLeafNode(int pos){
        return pos>size/2 && pos<size;
    }

    int peek(){
        return heap[1];
    }

    void heapify(int i){
        if(isLeafNode(i)){
            return;
        }
        int smallest = i;
        int leftChildNode = leftChild(i);
        int rightChildNode= rightChild(i);

        if(leftChildNode<=size && heap[leftChildNode]<heap[smallest]){
            smallest=leftChildNode;
        }

        if(rightChildNode<=size &&heap[rightChildNode]<heap[smallest]){
            smallest=rightChildNode;
        }
            if(smallest!=i){
                int temp = heap[i];
                heap[i]=heap[smallest];
                heap[smallest]=temp;
                heapify(smallest);
            }


    }

    void add(int pos){
        if(size>=capacity){
            return;
        }
        size++;
        int a = size;
        heap[a]=pos;
        int pt = parent(a);
        while(pt>0 && (heap[a]<heap[pt])){
            int temp=heap[a];
            heap[a]=heap[pt];
            heap[pt]=temp;
            a=pt;
            pt=parent(a);
        }
    }

    void print(){
        for (int i = 0; i <=size; i++) {
            System.out.println(heap[i]);
        }
    }

    int remove(){
        if(size==0){
            return -1;
        }
        int a = heap[1];
            int temp=heap[size];
            heap[size]=heap[1];
            heap[1]=temp;
            size--;
            heapify(1);
        return a;
    }

    public static void main(String[] args) {
        Heap a = new Heap(15);
        a.add(10);
        a.add(5);
        a.add(3);
        a.add(2);
        a.print();
        a.add(15);


        System.out.println("Min (peek): " + a.peek());
        System.out.println("Removed: " + a.remove());
        System.out.println("Removed: " + a.remove());
    }
    }
