class minHeap:
    #Initialize an empty array (heap) and maintain a variable that has it's capacity
    def __init__(self,capacity=10) -> None:
        self.capacity = capacity
        self.heap = []

    # Gives the current size of the heap
    def size(self):
        return len(self.heap)
    
    # Gives the parent of the index of a node passed
    def parent(self,i):
        # If root
        if i==0:
            return None
        return (i-1)//2
    
    # Gives the left child's index
    def leftChild(self,i):
        return 2*i+1
    
    # Gives the right child's index
    def rightChild(self,i):
        return 2*i+2

    # Print the heap 
    def printHeap(self):
        print(self.heap)
        return
    
    # Find the peak of the heap which is it's minimum in minHeap
    def peak(self):
        return self.heap[0]
    
    # Get to know if a node is a leaf node
    def isLeafNode(self,val):
        size = self.size()
        try:
            index = self.heap.index(val)
            if index>size/2 and index<=size:
                return True
            else:
                return False
        except:
            print("Element not present in the array")
            return False
        
    
    # Heapify rearranges the heap to make sure the elements at index are following the conditions of being a heap
    # In short, checks if Parent < both children else updates Parent to min and checks for the child's subtree
    def heapify(self,index):
        size = self.size()
        if size <=1:
            return self.heap
        left = self.leftChild(index)
        right = self.rightChild(index)
        
        smallest = index
        # Get the smallest element of the subtree under index
        if left<size and self.heap[left]<self.heap[index]:
            smallest = left
        
        if right<size and self.heap[right] < self.heap[smallest]:
            smallest = right
        
        # Smallest element was not found at this index, swap it with the index where it was found
        if smallest!=index:
            self.heap[smallest],self.heap[index] = self.heap[index],self.heap[smallest]
            self.heapify(smallest)

    # Add the node at the end and then bubble it to the top until it is greater then the parent or reaches the top
    def add(self,val):
        index = self.size()
        if index == self.capacity:
            return False
        else:
            self.heap.append(val)
            parent = self.parent(index)
            while parent!=None:
                if val < self.heap[parent]:
                    self.heap[index],self.heap[parent] = self.heap[parent],self.heap[index]
                    index = parent
                    parent = self.parent(parent)
                else:
                    break

    # Deletes the minimum of the heap which is the root
    def removeMin(self):
        if self.size() == 0:
            print("Cannot delete as heap is empty")
            return False

        # Update the root with the last element(or dummy val > all elements)
        self.heap[0] = self.heap[-1]
        self.heap.pop()
        
        # Call heapify to bring the smallest node up.
        self.heapify(0)
        pass

    # Deletes the element at index index
    def removeIndex(self,index):
        if index<0 or index>self.size()-1:
            print("Cannot delete the element as index is out of bounds")
            return False
        
        # Get the minimum of the heap
        minimum = self.peak()
        
        # Set the element to be deleted to the min of heap -1 to bring it to the top of the heap and delete it at the root
        self.heap[index] = minimum-1

        curr = index
        parent = self.parent(curr)
        while (curr > 0 and self.heap[parent] > self.heap[curr]):
            self.heap[parent],self.heap[curr] = self.heap[curr],self.heap[parent]
        # Now delete the min which is now the root
        self.removeMin()


if __name__ == "__main__":
    minheap = minHeap(5)
    print(minheap.capacity)
    minheap.add(10)
    minheap.printHeap()
    minheap.add(40)
    minheap.printHeap()
    minheap.add(50)
    minheap.printHeap()
    minheap.add(5)
    minheap.printHeap()
    minheap.removeMin()
    minheap.printHeap()
    minheap.removeIndex(2)
    minheap.printHeap()
    minheap.add(2)
    minheap.printHeap()
    print(f'Peak element is {minheap.peak()}')
    print(f'Heap size is currently {minheap.size()}')
    minheap.add(3)
    minheap.add(1)
    print(minheap.isLeafNode(4))
    print(minheap.isLeafNode(2))
    print(minheap.isLeafNode(3))
    minheap.printHeap()

    