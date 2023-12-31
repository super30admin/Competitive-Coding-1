# Time Complexity : O(logn) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to find the min Heap element and return it then maintain  the heap property.


class MinHeap:
    def __init__(self, maxsize):
        self.maxsize = maxsize
        self.size = 0
        self.Heap = [0]*(self.maxsize + 1)
        self.Heap[0] = -1 * 9999
        self.FRONT = 1
    
    def parent(self, pos):
        return pos//2
    
    def leftchld(self, pos):
        return pos * 2

    def rightchld(self, pos):
        return (pos*2)+1
    
    def isLeaf(self, pos):
        return (2*pos)>self.size

    def swap(self, fpos, spos):
        self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos]
    
    def minHeapify(self, root):
        if not self.isLeaf(root):
            if self.Heap[root] > self.Heap[self.rightchld(root)] or self.Heap[root] > self.Heap[self.leftchld(root)]:
                if self.Heap[self.leftchld(root)] < self.Heap[self.rightchld(root)]:
                    self.swap(root, self.leftchld(root))
                    self.minHeapify(self.leftchld(root))
                else:
                    self.swap(root, self.rightchld(root))
                    self.minHeapify(self.rightchld(root))
    
    def insert(self, element):
        if self.size>=self.maxsize:
            return
        
        self.size+=1
        self.Heap[self.size] = element
        curr= self.size
        while(self.Heap[curr] < self.Heap[self.parent(curr)]):
            self.swap(curr, self.parent(curr))
            curr = self.parent(curr)

    def print(self):
        for i in range(1, self.size//2+1):
            print("Parent node: "+ str(self.Heap[i])+" Left Child: "+ str(self.Heap[2*i])+ "rightChild is : " + str(self.Heap[2*i+1]))

    def minHeap(self):
        for i in range(self.size//2, 0 , -1):
            self.minHeapify(i)

    def remove(self):
        popper = self.Heap[self.FRONT]
        self.Heap[self.FRONT] = self.Heap[self.size]
        self.size -=1
        self.minHeapify(self.FRONT)
        return popper
    
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
  
    minHeap.print()
    print("The Min val is " + str(minHeap.remove()))