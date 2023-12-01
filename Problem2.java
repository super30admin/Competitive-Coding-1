// Min Heap Implementation
// Time Complexity:
// To get min: O(1)
// To insert element: O(log n)
// To remove min element: O(log n)
// Space Complexity: O(n)
class Heap{

    private int size;
    private int heap[];
    private int front;

    public Heap(int size){
        this.size = size;
        this.heap = new int[size];
        this.front = 0;
    }

    public int parent(int i){
        return (i-1)/2;
    }

    public int leftChild(int i){
        return 2 * i + 1;
    }

    public int rightChild(int i){
        return 2 * i + 2;
    }

    public int min(){
        if(front == 0) {
            System.out.println("\nHeap is empty");
            return -1;
        }
        return heap[0];
    }

    public void insert(int value){
        if(front == size) {
            System.out.println("\nHeap is full");
            return;
        }

        int i = front;
        heap[front++] = value;
        while(i != 0 && heap[i] < heap[parent(i)]){
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
        System.out.println("\nAfter inserting " + value );
        print();
        return;
    }

//    Remove minimum element from the heap
    public void remove(){
        if(front == 0) {
            System.out.println("\nHeap is Empty");
            return;
        }
        int ele = heap[0];
        heap[0] = heap[--front];

        this.heapify(0);
        System.out.println("\nRemoving min element: " + ele);
        this.print();

    }

    private void heapify(int i) {
        int l = this.leftChild(i);
        int r = this.rightChild(i);
        int swappos = i;

        if(r < front){
            swappos = heap[l] < heap[r] ? l : r;
        }else if(l < front){
            swappos = l;
        }

        if(swappos != i && heap[swappos] < heap[i]){
            int temp = heap[swappos];
            heap[swappos] = heap[i];
            heap[i] = temp;
            this.heapify(swappos);
        }
        return;

    }

    public void print(){
        for(int i=0; i< front; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Heap heap = new Heap(10);

        heap.insert(50);
        heap.insert(80);
        heap.insert(30);
        heap.insert(90);
        heap.insert(20);
        heap.insert(10);
        heap.insert(40);
        heap.insert(70);
        heap.insert(100);
        heap.insert(60);
        heap.insert(1);

        System.out.println("\nMin element is: " + heap.min());

        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();




    }

}
