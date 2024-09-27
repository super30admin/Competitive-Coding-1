import java.util.*;
//Min heap design

/*
    Theory for min heap: -> 
    1) we use a complete binary tree for constructing a mean heap and only property we follow is root element must be smaller than its children.
    2) Operations for min Heap:
        1) getMin-> o(1), get the topmost element
        2) insert -> o(logN), insert the new element
        3) delete -> o(logN), delete the element
    we use heapify() operation to keep adding the last element to the top and then heapify down to check if the root element is smaller than its children, otherwise we call  the heapify function again until we get the case.
    else we just keep on calling the heapify operation. 
    A Min Heap is a Complete Binary Tree. A Min heap is typically represented as an array. The root element will be at Arr[0]. For any ith node, i.e., Arr[i]:
    Arr[(i -1) / 2] returns its parent node.
    Arr[(2 * i) + 1] returns its left child node.
    Arr[(2 * i) + 2] returns its right child node.
*/

/*

// Time Complexity : insertion: O(logN), getMin / remove: O(1). 
// Space Complexity : O(N)
// Did this code successfully run on Editor : Yes
// Any problem you faced while coding this : No
*/
public class MinHeap {
 
    static final int TOP=1;

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

    //  insert function // To insert a node into the heap
    public void insert(int element)
    {
        if(size>=maxSize)
        {
            return ;
        }
         heap[++size]= element;
         int current = size;
       // if the parent is greater than child then swap 
         while(heap[current]<=heap[parent(current)])
         {
             swap(current,parent(current));
             current= parent(current);
         }

    }
    
    // Returning the position of the parent for the node currently at pos
    public int parent(int position)
    {
        return position/2;
    }

   // To swap two nodes of the heap
       public void swap(int firstElement,int secondElement)
    {
        int temp = heap[firstElement];
        heap[firstElement]= heap[secondElement];
        heap[secondElement]=temp;

    }

   // To remove and return the minimum element from the heap
    public int remove(){

        int popped = heap[TOP];
        // now assign the last element to top
        heap[TOP]= heap[size--];
        minheapify(TOP);

        return popped;
        

    }

      // To heapify the node at pos
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
                // swap if child is < than parent at left
                // Swap with the left child and heapify
                // the left child

                    swap(position,leftPosition(position));
                    minheapify(leftPosition(position));
                }
                else
                {
                // swap if child is < than parent at right
                // Swap with the right child and heapify
                // the left child

                    swap(position,rightPosition(position));
                    minheapify(rightPosition(position));
                }


            }



        }

    }

    //Returning the position of the left child for the node currently at pos
    public int leftPosition(int position)
    {
        return (2*position);
    }

//Returning the position of the right child for the node currently at pos

    public int rightPosition(int position)
    {
        return (2*position)+1;
    }
    
    // to check if the array at position ia a leaf node 
   // Returning true if the passed node is a leaf node

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
// Print the MinHeap (binary tree) contents
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
        System.out.println("The minimum value is " + minHeap.remove());
    }

}