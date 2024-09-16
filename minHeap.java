
import javax.naming.directory.InvalidSearchFilterException;
import java.util.*;

public class MinHeap {

    static final int Front=1;

    private int[] heap;
    int size;
    int maxSize;

    public MinHeap(int maxSize)
    {
        this.maxSize=maxSize;
        this.size = 0;
        heap = new int[maxSize+1];
        heap[0]= Integer.MIN_VALUE; // assign negative infinity to the value;

    }

    // 1st call is to insert function
    public void insert(int element)
    {
        if(size>=maxSize)
        {
            return ;
        }
        heap[++size]= element;
        int current = size;

        while(heap[current]<=heap[parent(current)])
        {
            swap(current,parent(current));
            current= parent(current);
        }

    }
    public int parent(int position)
    {
        return position/2;
    }

    public void swap(int firstElement,int secondElement)
    {
        int temp = heap[firstElement];
        heap[firstElement]= heap[secondElement];
        heap[secondElement]=temp;

    }

    public int remove(){

        int popped = heap[Front];
        // now assign the last element to top
        heap[Front]= heap[size--];
        minheapify(Front);

        return popped;


    }

    public void minheapify(int position)
    {
        if(!isLeaf(position))
        {
            // if not a leaf node
            // if greater than the left child or rightchild we need to heapify
            if(heap[position]>heap[leftPosition(position)] || heap[position]>heap[rightPosition(position)])
            {
                if(heap[leftPosition(position)]<heap[rightPosition(position)])
                {
                    swap(position,leftPosition(position));
                    minheapify(leftPosition(position));
                }
                else
                {
                    swap(position,rightPosition(position));
                    minheapify(rightPosition(position));
                }


            }



        }

    }

    public int leftPosition(int position)
    {
        return (2*position);
    }

    public int rightPosition(int position)
    {
        return (2*position)+1;
    }

    public boolean isLeaf(int position)
    {
        if(position>=(size/2) && position<=size)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i]
                    + " LEFT CHILD : " + heap[2 * i]
                    + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

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
        System.out.println("The topValue is " + minHeap.remove());
    }

}