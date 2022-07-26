
//Time complexity - 
//Getting mininmum element: O(1)
//Removing the element: O(logn)
//Inserting the element: O(logn)

//Space Complexity: O(n)

//Any problems faced during implementation: No

public class MinHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int root = 1;


    public MinHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;

        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }


    public int getMin(){
        return Heap[root];
    }

    public void insert(int element){
        // This condition checks if the heap is already full or not. 
        if (size >= maxsize) {
            return;
        }

        Heap[++size] = element;
        int newsize = size;

        // need to swap to keep the min heap property valid. 
        while (Heap[newsize] < Heap[parent(newsize)]) {
            swap(newsize, parent(newsize));
            newsize = parent(newsize);
        }
    }

    public int remove()
    {

        int top = Heap[root];
        Heap[root] = Heap[size--];
        rearrage(root);
        return top;
    }


     private void swap(int first, int second)
    {

        int tmp;
        tmp = Heap[first];
        Heap[first] = Heap[second];
        Heap[second] = tmp;
    }

   private void rearrage(int i)
   {     
     if(!isLeaf(i)){

       //swap with the minimum of the two children
       int si = Heap[leftChild(i)]<Heap[rightChild(i)]?leftChild(i):rightChild(i);

       if(Heap[i]>Heap[leftChild(i)] || Heap[i]> Heap[rightChild(i)]){
         swap(i,si);
         rearrage(si);
       }

     }      
   }


    private int parent(int i) { 
        return i/2; 
    }

    private int leftChild(int i){
        return 2*i; 
    }

    private int rightChild(int i)
    {
        return (2*i) + 1;
    }

     private boolean isLeaf(int pos)
    {

        if (pos > (size / 2)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        MinHeap heap = new MinHeap(10);
        heap.insert(7);
        heap.insert(3);
        heap.insert(23);
        heap.insert(8);
        heap.insert(62);
        heap.insert(30);
        heap.insert(42);
        heap.insert(55);
        heap.insert(2);

         System.out.println("The Min val is in the heap "
                           + heap.getMin());

        System.out.println("The value removed from the heap is "
                           + heap.remove());
    }
}