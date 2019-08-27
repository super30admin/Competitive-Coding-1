/*
    1. Min HEap also known as priority queue.
    2. Min heap is a complete binary tree.
    3. Root node of a min heap must be the minimum value. 
    4. The Heap data structure can be used to efficiently find the kth smallest element
*/
//Space Complexity O(n)
class Minheap
{
    int[] heap;
    int size;
    int maxsize;

    public static final int FRONT = 1;

    public static void main(String[] args)
    {
        Minheap minHeap = new Minheap(15); 
        minHeap.insert(10); 
        minHeap.insert(7); 
        minHeap.insert(6); 
        minHeap.insert(12); 
        minHeap.insert(17); 
        minHeap.insert(5);
        

        System.out.println("min is "+minHeap.getmin());
        System.out.println("the element removed is"+minHeap.remove());

    }

    public Minheap(int maxsize)
    {
        this.maxsize=maxsize;
        this.size=0;
        heap=new Int(this.maxsize+1);
        heap[0]=Integer.MIN_VALUE;
    } 

    //parent node
    private int parent(int pos)
    {
        return pos/2;
    } 

    //left
    private int left(int pos)
    {
        return (2*pos);
    }

    //right
    private int right(int pos)
    {
        return (2*pos)+1;
    }

    public boolean isleaf(int pos)
    {
        if(pos>=(size/2)&&(pos<=size))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //swap() to swap pos of nodes inside heapify()
    public void swap(int a,int b)
    {
        int temp;
        temp = heap[a];
        heap[a]=heap[b];
        heap[b]=temp;
    }
    //heapify function is used to compare the left and the right with the position to be swapped and swaps them accordingly to satisfy the property of the min heap.
    //Called in insert function,in remove function() when the top element is removed and the last element is made the root node).
    //heapify is used to traverse through the heap to find the next smallest element and makes it the root element.
    public void heapify(int pos)
    {
        if(!isleaf(pos))
        {
            if(heap(pos)>heap[left] || heap(pos)>heap[right])
            {
                if(heap[left(pos)]<heap[right(pos)])
                {
                    swap(pos,left(pos));
                    heapify(left(pos));
                }
                else
                {
                    swap(pos,right(pos));
                    heapify(right(pos));
                }
            }
        }
    }
    //insert() is implemented in O(logN) time complexity
    public void insert(int val)
    {
        if(size>=maxsize)
        {
            return;
        }
        heap[++size]=val;
        int curr=size;
        while(heap[curr]<heap[parent(curr)])
        {
            swap(curr,parent(curr));
            curr=parent(curr);
        }
    }

    public void minHeap() 
    { 
        for (int pos = (size / 2); pos >= 1; pos--)
        { 
            heapify(pos); 
        } 
    } 

    //getmin() is implemented in O(1) time complexity
    public int getmin()
    {
        return heap[FRONT];
    }

    //remove() is implemented in O(logN) time complexity
    public int remove()
    {
        int rem = heap[FRONT];
        heap[FRONT]=heap[size--];
        heapify(FRONT);
        return rem;
    }
}
