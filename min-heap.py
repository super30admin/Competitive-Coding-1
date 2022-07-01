"""
Runtime Complexity:
O(n log n) - the implementation of min heap takes runtime of O(n log n) because there are log n levels and any operation in min heap such as min heapify, insert, remove to the heap which 
process over log n level and we do this for n elements. Therefore the time complexity is O(n log n)

Space Complexity: The time taken to construct a heap is O(n) - n elements.
Yes, the code worked on leetcode
"""


import sys
class minHeap:
    def __init__(self,maxsize):
        self.maxsize = maxsize
        self.size = 0
        self.heap = [0] *(self.maxsize+1)
        self.heap[0] = -1 *sys.maxsize
        self.FRONT = 1
    def parent(self,pos):
        return pos//2
    def leftchild(self,pos):
        return (2* pos)
    def rightchild(self,pos):
        return (2*pos)+1
    def isLeaf(self,pos):
        return pos*2 >self.size
    def swap(self,pos1,pos2):
        self.heap[pos1], self.heap[pos2] = self.heap[pos2], self.heap[pos1]
    def minHeapify(self, pos):
        if not self.isLeaf(pos):        #if not leaf, means the parent
            if (self.heap[pos]>self.heap[self.leftchild(pos)] or self.heap[pos]> self.heap[self.rightchild(pos)]):      #we check if parent is greater than left child or right child inorder to swap and keep the parent node as min according to min heap property.
                if self.heap[self.leftchild(pos)] < self.heap[self.rightchild(pos)]:        #if parent is larger than left child, then swap the parent with left child and call min heapify
                    self.swap(pos,self.leftchild(pos))
                    self.minHeapify(self.leftchild(pos))
                else:       #swap parent with right child if right child has larger value than parent and call min heapify
                    self.swap(pos, self.rightchild(pos))
                    self.minHeapify(self.rightchild(pos))

    def insert(self,element):       #if the size of current heap is greater than maxsize then we cant add any elements to it.
        if self.size >= self.maxsize:
            return
        self.size+=1
        self.heap[self.size] = element  #increment the size and add the element to the last
        
        curr = self.size
        
        while self.heap[curr] < self.heap[self.parent(curr)]:   #check whether the newly added element is smaller than parent, if it is then we swap
            self.swap(curr, self.parent(curr))
            curr = self.parent(curr)
    def Print(self):
        for i in range(1, (self.size//2)+1):
            print("PARENT:" + str(self.heap[i]) +" LEFT-CHILD: "+ str(self.heap[2*i]) + " RIGHT-CHILD:" + str(self.heap[2*i+1]))
    
    
    def remove(self):
        popped  = self.heap[self.FRONT]
        self.heap[self.FRONT]  = self.heap[self.size]
        self.size-=1
        self.minHeapify(self.FRONT)
        return popped

if __name__=="__main__":
    print("The minHeap is:")
    minHeap = minHeap(20)
    minHeap.insert(5)
    minHeap.insert(1)
    minHeap.insert(50)
    minHeap.insert(25)
    minHeap.insert(35)
    minHeap.insert(51)
    minHeap.insert(29)
    minHeap.insert(32)
    minHeap.insert(23)
    minHeap.Print()
    print("The min value is :" + str(minHeap.remove()))