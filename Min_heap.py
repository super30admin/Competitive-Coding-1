class MinHeap:
    def __init__(self, maxsize):
        self.maxSize = maxsize
        self.size = 0
        self.Heap = [0]*(self.maxSize)
        self.Front=0

    def minheap(self):
        for position in range(0, (self.size//2)):
            self.heapify(position)
    
    def parent(self, pos):
        return (pos-1)//2
    
    def leftchild(self, pos):
        return (2*pos)+1
    
    def rightchild(self, pos):
        return (2*pos)+2
    
    def swap(self,firstpos,lastpos):
        self.Heap[firstpos],self.Heap[lastpos] = self.Heap[lastpos],self.Heap[firstpos]

    def heapify(self, position):
        # check if its in other half of array as leaf nodes present in other half
        if not (position>=self.size//2 and position<=self.size-1):
            if self.Heap[position]>self.Heap[self.leftchild(position)] or self.Heap[position]>self.Heap[self.rightchild(position)]:
                if self.Heap[self.rightchild(position)]<self.Heap[self.leftchild(position)]:
                    self.swap(position, self.rightchild(position))
                    self.heapify(self.rightchild(position))
                if self.Heap[self.leftchild(position)]<self.Heap[self.rightchild(position)]:
                    self.swap(position, self.leftchild(position))
                    self.heapify(self.leftchild(position))

    def getmin(self):
        return self.Heap[self.Front]

    def insert(self, element):
        if self.size > self.maxSize:
            return
        self.Heap[self.size] = element
        current = self.size
        # do this until the child elements are larger than parent elements
        while self.Heap[current]< self.Heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)
        self.size+=1

    def remove(self):
        poppedEle = self.Heap[self.Front]
        self.Heap[self.Front] = self.Heap[self.size-1]
        self.size -= 1
        self.heapify(self.Front)
        print(self.Heap[:self.size])
        return poppedEle
        
    def Print(self):
        for i in range(0, (self.size//2)):
            print(" parent : "+ str(self.Heap[i])+" left child : "+
                                str(self.Heap[(2 * i)+1])+" right child : "+
                                str(self.Heap[(2 * i )+ 2]))

if __name__ == "__main__":
    
    print("The minHeap is ")
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
    minHeap.minheap()

    minHeap.Print()
    print("The Min val is " + str(minHeap.remove()))

    #The Problem is about finding the minimum element using binary heap, we use the Min Heap of binary heap algorithm.
    # It takes complexity of O(logn) for both insertion and extraction.
    #Time complexity - O(1) as the min element is always at the root node in the min heap. 