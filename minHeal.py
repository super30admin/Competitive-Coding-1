#Time Complexity of insert is log(N) for every new element to insert, searching Minimun is O(1), 
# and creating heap from array(Heapify) is O(N) , remove is also O(N) as after removal we need to heapify to ensure min is at the top

class MinHeap:
    def __init__(self, maxSize):
        self.maxSize = maxSize
        self.size = 0
        self.heap = [0] *(self.maxSize+1)
        self.heap[0]=  float("-inf")
        self.front = 1

    def parent(self, index):
        return index//2 #node = i then leftchild = 2*i and right child= 2*i+1 

    def leftChild(self,index):
        return 2 * index
    
    def rightChild(self,index):
        return 2 * index + 1

    def isLeaf(self,index):
        return index * 2 > self.size
    
    def swap(self, fpos, spos):
        self.heap[fpos], self.heap[spos] = self.heap[spos], self.heap[fpos]
    
    def minHeapify(self, index):
        if not self.isLeaf(index):
            if self.heap[index]>self.heap[self.leftChild(index)] or self.heap[index]>self.heap[self.rightChild(index)]:
                if self.heap[self.leftChild(index)] < self.heap[self.rightChild(index)]:
                    self.swap(index,self.leftChild(index))
                    self.minHeapify(self.leftChild(index))
                else:
                    self.swap(index,self.rightChild(index))
                    self.minHeapify(self.rightChild(index))

    def insert(self, element):
        if self.size >= self.maxSize :
            return
        self.size+= 1
        self.heap[self.size] = element
 
        current = self.size
 
        while self.heap[current] < self.heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)


    def createMinHeap(self):
        for i in range(self.size//2,0,-1):
            self.minHeapify(i)

    def Print(self):
        for i in range(1,(self.size//2)+1):
            print(f"Parent:{self.heap[i]}, Left child: { self.heap[2 * i]}, Right child: {self.heap[2* i + 1] }")

    def remove(self):
        rem = self.heap[self.front]
        self.heap[self.front] = self.heap[self.size]
        self.size -= 1
        self.minHeapify(self.front)
        return rem

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
    minHeap.createMinHeap()
    minHeap.Print()
 
    print("The Min val is " + str(minHeap.remove()))

         
    