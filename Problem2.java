// Incpmplete
//Not able to understand the algo for this
public class minHeap {
    private int[]Heap;
    private int size;
    private int MAX_SIZE;

    private static final int FRONT =1;

    public minHeap(int maxsize){
        this.MAX_SIZE =maxsize;
        this.size =0;
        Heap = new int[this.MAX_SIZE +1];
        Heap[0] =Integer.MIN_VALUE;
    }
    // Function to tell the position of Parent Node
    private int parent(int pos){
        return pos/2;
    }
    // Function to tell the position of Right child Node
    private int rightChild(int pos){
        return (pos*2)+1;
    }

    // Function to tell the position of left child Node
    private int leftChild(int pos){
        return pos*2;
    }

    private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Function to swap two nodes of the heap
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }


    public static void main(String[] arg)
    {
        System.out.println("The Min Heap is ");
        minHeap minHeap = new minHeap(15);
        /*minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();

        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());*/
    }
}

