// Time Complexity : O(log(n))
// Space Complexity : O(n)
    //n is the size of the array used to implement heap.

public class Problem1 {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.add(5);
        minHeap.add(4);
        minHeap.printHeap();
        minHeap.add(2);
        minHeap.add(6);
        minHeap.add(8);
        minHeap.add(9);
        minHeap.printHeap();
        minHeap.add(7);
        minHeap.add(11);
        minHeap.printHeap();
        System.out.println(minHeap.removeMin());
        System.out.println(minHeap.getMin());
        minHeap.printHeap();
        System.out.println(minHeap.removeMin());
    }
}

class MinHeap
{
    private int[] arr;
    private int size;
    private int capacity;
    
    MinHeap()
    {
        capacity = 5;
        arr = new int[capacity];
        size = 0;
    }
    
    private int getParentIndex(int x)
    {
        return x/2;
    }
    
    private int getLeftChildIndex(int x)
    {
        return x*2;
    }
    
    private int getRightChildIndex(int x)
    {
        return (x*2)+1;
    }
    
    private void swap(int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    private void doubleCapacity()
    {
        if (capacity==0)
        {
            capacity++;
        }
        else
        {
            capacity = capacity*2;
        }
        int temp[] = new int[capacity];
        for (int i=0; i<capacity/2; i++)
        {
            temp[i] = arr[i];
        }
        arr = temp;
    }
    
    public int getMin()
    {
        if (this.size>0)
        {
            return arr[0];
        }
        else
        {
            return -1;
        }
    }
    
    public int removeMin()
    {
        if (this.size==0)
        {
            return -1;
        }
        int x = arr[0];
        arr[0] = arr[this.size-1];
        this.size--;
        int parentIndex = 0;
        while(parentIndex<=this.size)
        {
            int leftIndex = getLeftChildIndex(parentIndex);
            int rightIndex = getRightChildIndex(parentIndex);
            int smallestNumberIndex = parentIndex;
            if (leftIndex<this.size&&arr[leftIndex]<arr[smallestNumberIndex])
            {
                smallestNumberIndex = leftIndex;
            }
            if (rightIndex<this.size&&arr[rightIndex]<arr[smallestNumberIndex])
            {
                smallestNumberIndex = rightIndex;
            }
            if (smallestNumberIndex != parentIndex)
            {
                swap(parentIndex, smallestNumberIndex);
                parentIndex = smallestNumberIndex;
            }
            else
            {
                break;
            }
        }
        return x;
    }
    
    public void add(int x)
    {
        if (getSize()>=capacity)
        {
            doubleCapacity();
        }
        this.size++;
        arr[this.size-1] = x;
        int childIndex = this.size-1;
        int parentIndex = getParentIndex(childIndex);
        while(childIndex>=0&&arr[childIndex]<arr[parentIndex])
        {
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = getParentIndex(childIndex);
        }
    }
    
    public int getSize()
    {
        return this.size;
    }
    
    public void printHeap()
    {
        System.out.print("[");
        for (int i=0; i<this.size-1; i++)
        {
            System.out.print(arr[i]+", ");
        }
        System.out.println(arr[this.size-1]+"]");
    }
}