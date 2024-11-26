
public class MinHeap {
    int[] Heap;
    int size;
    int capacity;

    int FRONT = 1;

    public MinHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        Heap = new Heap[size+1];
        Heap[0] = Integer.MIN_VALUE;

    }

    private int parent(int position){ 
        return position/2;
    }

    private int leftChild(int position){
        return 2*position;
    }

    private int rightChild(int position){
        return 2*position + 1;
    }

    private int leafNode(int position){
        return (position > size/2 && position <= size);
    }

    private int peak(int position){
        return Heap[1];
    }

    public void swap(int a, int b){
        int temp = Heap[a];
        Heap[a] = Heap[b];
        Heap[b] = temp;
    }

    public void add(int element){
        if(size >= capacity){
            return;
        }
        Heap[++size] == element;
        int current = size;

        while(Heap[current] < Heap[parent(current)]){
            swap(current,parent(current ));
            current = parent(current);
        }
    }

    private void heapify(int position){
        if(!leafNode(position)){
            if(Heap[position] > Heap[leftChild(position)] ||  Heap[position] > Heap[rightChild(position)]) {
                if (Heap[leftChild(position)] < Heap[rightChild(position)]) {
                    swap(position, leftChild(position));
                    heapify(leftChild(position));
                }
                else {
                    swap(position, rightChild(position));
                    heapify(rightChild(position));
                }
            }
        }
    }

    public int remove(int position){
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        heapify(FRONT);
        return popped;
    }

    }
