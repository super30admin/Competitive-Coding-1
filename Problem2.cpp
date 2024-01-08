// Min Heap

// Time Complexity: Insert, heapify and remove - O(logN) 
// Space Complexity: O(1)
// Any problem you faced while coding this : no.


// Your code here along with comments explaining your approach
// Using array to store the heap elements. We check everytime we push an element if its the minimum of all the nodes 
// present in the tree. When deleting an element, get the last element to the first location in the vector
// (and remove that last element once copied) and we do heapify operation to arrange elements in order.

#include<vector>
#include<iostream>

class MinHeap {
    private:
    int capacity;
    int size;
    std::vector<int> heap;
    
    // Helper to swap two nodes of the heap.
    void swap(int fpos, int spos)
    {
        int temp;
        temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
        return;
    }

    public: 
    // constructor
    MinHeap(int cap)
        : capacity(cap) 
    {
        heap.resize(capacity+1);
        heap[0] = INT32_MIN;
    } 

    // Destructor    
    ~MinHeap() {}

    //  Get size
    int getSize(void)
    {
        return size;
    }

    // Get Parent node of the given node
    int getParent(int pos)
    {
        return pos/2;
    }

    // Get LeftChild of the given node
    int getLeftChild(int pos)
    {
        return (2*pos);
    }

    // Get RightChild of the given node
    int getRightChild(int pos)
    {
        return ((2*pos) + 1);
    }

    // Check if the given node is a leaf node
    bool isLeafNode(int pos)
    {
        if((pos > size/2))
        {
            return true;
        } 
        return false;
    }

    // Insert the element into appropriate place.
    void insert(int element)
    {
        if(size >= capacity)
        {
            return;
        }
        heap[size] = element;
        int curr = size++;
        int parentIdx = getParent(curr);
        while(curr > 0 && (heap[curr] < heap[parentIdx]))
        {
            swap(curr, getParent(curr));
            curr = parentIdx;
            parentIdx = getParent(curr);
        }
        return;
    }

    // Helper to place elements according to the sorting order.
    void heapify(int index)
    {
        if(!isLeafNode(index))
        {
            int leftChildIdx = getLeftChild(index);
            int rightChildIdx = getRightChild(index);
            int smallestChildIndex = leftChildIdx;
            if((rightChildIdx < size) && (heap[rightChildIdx] < heap[leftChildIdx]))
            {
                smallestChildIndex = rightChildIdx;
            }
            
            if((heap[index] > heap[leftChildIdx]) || (heap[index] > heap[rightChildIdx]))
            {
                swap(index, smallestChildIndex);
                heapify(smallestChildIndex);
            }
        }
        return;
    }

    // Remove the first element
    int remove(void)
    {
        int removedElem = heap[1];
        heap[1] = heap[size--];
        heapify(1);
        return removedElem;
    }

    void printElements(void)
    {
        std::cout << "elements are: " << std::endl;
        for(int i = 1; i < size/2; i++)
        {
            std::cout << "Parent: " << heap[i]  << "\t" << "LeftChild" << heap[2*i] << "\t" << "RightChild" << heap[2*i+1] << std::endl;
        }
        return;
    }  
};

int main()
{
    MinHeap minHeap(15);

    // Custom input entries
    minHeap.insert(5);
    minHeap.insert(3);
    minHeap.insert(17);
    minHeap.insert(10);
    minHeap.insert(84);
    minHeap.insert(19);
    minHeap.insert(6);
    minHeap.insert(22);
    minHeap.insert(9);

    // Print all elements of the heap
    minHeap.printElements();

    // Delete first element
    std::cout << "min val - " << minHeap.remove() << std::endl;

    return 0;
}