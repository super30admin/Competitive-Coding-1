public class minheap {
    int size;
    private static final int FRONT = 1;
    int capacity=0;
    int[] minheap;
    public minheap(int capacity)
    {
        this.capacity=capacity;
        this.minheap=new int[capacity];
        this.size=0;
    }
    // Function to build the min heap using the minHeapify
    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minheapify(pos);
        }
    }
    public int parent(int child)
    {
        return (child-1)/2;
    }
    public int getleftchild(int parent)
    {
        return 2*parent+1;
    }
    public int getrightchild(int parent)
    {
        return 2*parent+2;
    }
    public void swap(int a, int b)
    {
        int temp=minheap[a];
        minheap[a]=minheap[b];
        minheap[b]=temp;
    }
    public void insert(int n)
    {
        if(size>=capacity)
            return;
        minheap[size]=n;
        int current=size;
        while(minheap[current]<minheap[parent(current)])
        {
            swap(current,parent(current));
            current=parent(current);
        }
        size++;
    }
    public void print()
    {
        for(int i=0;i<size;i++)
        {
            System.out.println(minheap[i]);
        }
    }
    public boolean isleaf(int pos)
    {
        if(getleftchild(pos)>=size|| getrightchild(pos)>=size)
        {
            return true;
        }
        return false;
    }
    public void minheapify(int pos)
    {
        if(!isleaf(pos))
        {
            if(minheap[pos]>minheap[getleftchild(pos)] || minheap[pos] > minheap[getrightchild(pos)])
            {
                if(minheap[getleftchild(pos)] < minheap[getrightchild(pos)])
                {
                    swap(pos,getleftchild(pos));
                    minheapify(getleftchild(pos));
                }
                else
                {
                    swap(pos,getrightchild(pos));
                    minheapify(getrightchild(pos));
                }
            }

        }

    }
    public int remove()
    {
        int removed=minheap[0];
        minheap[0]=minheap[--size];
        minheapify(0);
        return removed;
    }
    public static void main(String[] args)
    {
        System.out.println("The Min Heap is ");
        minheap minHeap = new minheap(10);
        minHeap.insert(5);
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
        System.out.println("The Min val is " + minHeap.remove());
    }
}

