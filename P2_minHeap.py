# Problem statement: Design a Min Heap

# Operations on Min Heap :

# getMin(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).

# extractMin(): Removes the minimum element from MinHeap. Time Complexity of this Operation is O(Log n) as this operation needs to maintain the heap property (by calling heapify()) after removing root.

# insert(): Inserting a new key takes O(Log n) time. We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

# // Time Complexity : O(1) for getMin(), O(log n) for insert() and extractMin() 
# // Space Complexity : O(n)
# // Any problem you faced while coding this : Struggled at first to create the initial structure of heap


class MinHeap:
    def __init__(self, maxsize):
        self.maxsize = maxsize
        self.size = 0
        self.Heap = [0]*(self.maxsize+1)
        self.Heap[0] = -1*self.maxsize
        self.front = 1

    # to get the position of parent, left and right for node currently at k
    def parent(self, k):
        return k//2

    def leftChild(self, k):
        return 2*k
    
    def rightChild(self, k):
        return (2*k)+1

    # is the node you are at is leaf node, return True
    def isLeaf(self, k):
        if k >= self.size//2 and k <= self.size:
            return True
        return False

    def swap(self, fpos, spos): 
        self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos] 

    def heapify(self, k): 
  
        # If node is non-leaf and greater than any of its child 
        if not self.isLeaf(k): 
            if (self.Heap[k] > self.Heap[self.leftChild(k)] or 
               self.Heap[k] > self.Heap[self.rightChild(k)]): 
  
                # Swap with the left child and heapify the left child else Swap with the right child and heapify the right child
                if self.Heap[self.leftChild(k)] < self.Heap[self.rightChild(k)]: 
                    self.swap(k, self.leftChild(k)) 
                    self.heapify(self.leftChild(k)) 
                else: 
                    self.swap(k, self.rightChild(k)) 
                    self.heapify(self.rightChild(k)) 

    def insert(self, x):
        if self.size >= self.maxsize : 
            return
        self.size+= 1
        self.Heap[self.size] = x 
  
        current = self.size 
  
        while self.Heap[current] < self.Heap[self.parent(current)]: 
            self.swap(current, self.parent(current))
            current = self.parent(current) 


    def extractMin(self):
        popped = self.Heap[self.front]
        self.Heap[self.front] = self.Heap[self.size]
        self.size -= 1
        self.heapify(self.front)
        return popped

    def getMin(self):
        return self.Heap[self.front]

    # to build the min heap
    def minHeap(self):
        for k in range(self.size//2, 0, -1):
            self.heapify(k)

    # printing contents of heap:
    def printMinHeap(self):
        for i in range(1, (self.size//2)+1): 
            print(" Parent: "+ str(self.Heap[i])+
                    " | Child(left): "+ str(self.Heap[2 * i])+
                    " | Child(right): "+ str(self.Heap[2 * i + 1])) 

# Driver Code 
if __name__ == "__main__": 
      
    print('The minHeap is ') 
    minHeap = MinHeap(15) 
    minHeap.insert(5) 
    minHeap.insert(3) 
    minHeap.insert(17) 
    minHeap.insert(10) 
    minHeap.insert(84) 
    minHeap.insert(19) 
    minHeap.insert(6) 
    minHeap.insert(22) 
    minHeap.insert(9) 
    minHeap.minHeap() 
    
    minHeap.printMinHeap() 
    
    print("Extracting Min val... " + str(minHeap.extractMin())) 

    print("Getting new Min val... " + str(minHeap.getMin())) 


    
    
