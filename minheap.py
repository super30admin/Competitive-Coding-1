# // Time Complexity :O(logn)
# // Space Complexity :O(n) complexity of the heap
# // Did this code successfully run on Leetcode :no,gfg problem
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach






from os import sys

class MinHeap():
    def __init__(self,maxsize):
        self.maxsize=maxsize
        self.size=0
        self.heap=[0]*(self.maxsize+1)
        self.heap[0]=-1*sys.maxsize
        self.front=1
    def parent(self,current):
        return current//2
    def swap(self,a,b):
        self.heap[a],self.heap[b]=self.heap[b],self.heap[a]
    def insert(self,data):
        if(self.size>=self.maxsize):
            return
        self.size=self.size+1
        self.heap[self.size]=data
        current=self.size
        while(self.heap[current]<self.heap[self.parent(current)]):
            self.swap(current,self.parent(current))
            current=self.parent(current)
    def Print(self):
        
        for i in range(self.size):
            print(self.heap[i])
    def isleaf(self,pos):
        if pos >= (self.size//2) and pos <= self.size:
            return True
        return False
    def leftchild(self,pos):
        return 2*pos
    def rightchild(self,pos):
        return (2*pos)+1
    def minheapify(self,pos):
        if not self.isleaf(pos):
            if(self.heap[pos]>self.heap[self.leftchild(pos)] and self.heap[pos]>self.heap[self.rightchild(pos)]):
                if(self.heap[self.leftchild(pos)]<self.heap[self.rightchild(pos)]):
                    self.swap(pos,self.leftchild(pos))
                    self.minheapify(self.leftchild(pos))
                else:
                    self.swap(pos,self.rightchild(pos))
                    self.minheapify(self.rightchild(pos))
    def remove(self):
        popped=self.heap[self.front]
        self.heap[self.front]=self.heap[self.size]
        self.size=self.size-1
        self.minheapify(self.front)
        return popped

    def minheap(self):
        for i in range(self.size//2,0,-1):
            self.minheapify(i)



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
    # minHeap.Print()
    minHeap.minheap()
    print(minHeap.remove())
    print(minHeap.remove())