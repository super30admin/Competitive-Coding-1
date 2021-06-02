// Time Complexity: for getMin()-> O(1), for extractMin() -> O(log(n)), for insert() -> O(log(n));
// log(n) because we might need to swap elements along the height of the tree. Hence atmost logn swaps are required
//Space Complexity: O(n)

// Java implementation of Min Heap
public class MinHeap{
    int[] heap;
    int counter;
    int capacity;

    public MinHeap(int size)
    {
        this.capacity=size;
        heap=new int[size];
    }
    // peek min element
    public int getMin()
    {
        if(counter==0)
            return Integer.MIN_VALUE;// if heap is empty return negative infinity

        return heap[0];
    }

    // pop min element
    public int extractMin()
    {
        if(counter==0)
        {
            System.out.println("underflow");
            return Integer.MIN_VALUE;
        }
        int index=0,min;
        int l=2*index+1,r=2*index+2;
        min=heap[0];// root elemnt is the min element
        heap[0]=heap[counter-1];// assign last element to root;
        heap[counter-1]=Integer.MAX_VALUE;// setting last element to null, because its value was already moved to root

        while( r < counter)
        {
            if(heap[l]<=heap[r])
            {
                if(heap[index]>heap[l])
                    swap(index,l);
                index=l;
            }
            else
            {
                if(heap[index]>heap[r])
                    swap(index,r);
                index=r;
            }

            l=2*index+1;
            r=2*index+2;
        }

        if(l<counter)
        {
            heap[index]=heap[l];
            heap[l]=0;
        }

        counter--;
        return min;
    }

    public void insert(int curr)
    {
        if(counter==capacity)
        {
            System.out.println("overflow");
            return;
        }
        int index=0,lastidx=counter;
        //int l=2*index+1,r=2*index+2;
        heap[lastidx]=curr;
        if(lastidx>1)
            index= lastidx%2==1? (lastidx-1)/2: (lastidx-2)/2;
        counter++;
        while(index<counter && index>=0)
        {
            if(heap[lastidx]< heap[index])
            {
                swap(lastidx,index);
                lastidx=index;
            }
            else
                return;
            if(lastidx%2==1)
            {
                index=(lastidx-1)/2;
            }
            else
            {
                index=(lastidx-2)/2;
            }
        }


    }

    public void swap(int idx1,int idx2)
    {
        int temp=heap[idx1];
        heap[idx1]=heap[idx2];
        heap[idx2]=temp;
    }


    public void print()
    {
        for (int i = 0; i < counter / 2; i++) {
            System.out.print(" PARENT : " + heap[i]
                    + " LEFT CHILD : " + heap[2*i+1]
                    + " RIGHT CHILD :" + heap[2*i+2]);
            System.out.println();
        }
    }

    // Driver code
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
        System.out.println("The Min val is " + minHeap.extractMin());
        minHeap.print();

        System.out.println("The Min val is " + minHeap.extractMin());
        minHeap.print();
    }
}
