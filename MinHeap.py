# Min Heap - almost complete binary tree. Parent will be always less than left and right child.
# Insert operation and remove operation -> TC - O(logn) SC- O(1)
#getMin -  TC - 0(1), SC -0(1)
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

    # check if leaf node (N//2 TO N-1 nodes in list will be leaf nodes)
    def isLeaf(self, k):
        if k >= self.size//2 and k <= self.size:
            return True
        return False

    def swap(self, fpos, spos): 
        self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos] 

    #compare left and right child of root and swap the root elememt 
    # with the smallest child. Continue till we reach leaf node. 
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

    #insert to leaf node then swap the element up to create min heap
    def insert(self, x):
        if self.size >= self.maxsize : 
            return
        self.size+= 1
        self.Heap[self.size] = x 
  
        current = self.size 
  
        while self.Heap[current] < self.Heap[self.parent(current)]: 
            self.swap(current, self.parent(current))
            current = self.parent(current) 

    #swap the first element to last and remove last element. then call heapify to rearrange
    def remove(self):
        popped = self.Heap[self.front]
        self.Heap[self.front] = self.Heap[self.size]
        self.size -= 1
        self.heapify(self.front)
        
        return popped
    #first element will be the min element
    def getMin(self):
        return self.Heap[self.front]

    # build the min heap
    def minHeap(self):
        for k in range(self.size//2, 0, -1):
            self.heapify(k)

    # print heap
    def printMinHeap(self):
        for i in range(1, (self.size//2)+1): 
            print(" Parent: "+ str(self.Heap[i])+
                    " | Child(left): "+ str(self.Heap[2 * i])+
                    " | Child(right): "+ str(self.Heap[2 * i + 1])) 
