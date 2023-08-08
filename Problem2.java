
// Time Complexity : O(log n) for Insertion and Deletion of min element to maintain Heapify property
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes on my compiler
// Any problem you faced while coding this : No
class MinHeap{
    int capacity;
    int[] Heap;
    int size;

    public  MinHeap (int capacity)
    {

        this.capacity =capacity ;
        Heap=new int[this.capacity];
        size = 0;
    }

    public int parent(int childIndex)
    {
        return ((childIndex-1)/2);
    }

    public int leftChild(int parentIndex)
    {
        return (parentIndex*2)+1;
    }

    public int rightChild(int parentIndex)
    {
        return (parentIndex*2)+2;
    }

    public void swap(int childIndex, int parentIndex)
    {
        int tmp = Heap[childIndex];
        Heap[childIndex] = Heap [parentIndex];
        Heap[parentIndex] =tmp;
    }
    public void insert(int value)
    {
        int childIndex =0;
        if(size>= capacity)
        {
            System.out.println("The Heap is full, Insertion operation cannot be done");
            return;
        }
        childIndex = size;
        Heap[size++]= value;
        while(childIndex>0 && Heap[childIndex] < Heap[parent(childIndex)])
        {
            swap(childIndex,parent(childIndex));
            childIndex = parent(childIndex);
        }
       

    }

    public int getMin()
    {
        //if the heap has no elements then it returns -1
        if(size==0)
        {
            System.out.println("The Heap is empty");
            return -1;
            
        }
       
        return  Heap[0];
    
    }

    public int deleteMin()
    {
        if(size==0)
        {
            System.out.println("The Heap is empty");
            return -1;
            
        }
       
            int min= Heap[0];
            Heap[0]= Heap[size-1];
            size--;
            Heapify(0);

        return min;
    }

    public void Heapify(int index)
    {   int smallest = index;
        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);

        if(leftChildIndex< size && Heap[leftChildIndex]< Heap[index])
        {
            smallest= leftChildIndex;
        }

        if(rightChildIndex< size && Heap[rightChildIndex]< Heap[index])
        {
            smallest= rightChildIndex;
        }
        if(smallest!=index){
        swap(smallest, index );
       
        Heapify(smallest);
        }

    }

    public void print()
    {
        for (int i = 0; i < size / 2 ; i++) {
 
            // Printing the parent and both childrens
            
            System.out.print(
                " PARENT : " + Heap[i]);
            
            System.out.print(
                " LEFT CHILD " + Heap[leftChild(i)]);

            if(rightChild(i)< size) 
             System.out.print( " RIGHT CHILD :" + Heap[rightChild(i)]);
 
            // By here new line is required
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        
        minHeap.insert(9);

        minHeap.print();
       System.out.println("The minimum element is :"+ minHeap.getMin());
       minHeap.deleteMin();
        minHeap.print();
    }


}