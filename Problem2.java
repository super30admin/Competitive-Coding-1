
A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Operations on Min Heap:

getMin(): It returns the root element of Min Heap. O(1)
extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)

#################################
class MinHeap:
    def __init__(self,maxlen):
        self.size=0
        self.maxlen=maxlen
        self.heap=[0]*(self.maxlen+1)
        self.heap[0]=float('-inf')
        self.f=1
    def parent(self,index):
        return pos//2
    def left(self,pos):
        return 2*pos
    def right(self,pos):
        return 2*pos+1
    def insert(self,ele):
        if self.size>=self.maxlen:
            return
        self.size+=1
        c=self.size
        while self.heap[c]<self.heap[parent(c)]:
            self.heap[self.parent(c)],self.heap[c]=self.heap[c],self.heap[self.parent(c)]
            c=self.parent(c)
    def Leaf(self,index):
        if index>=(self.size)//2 and pos<=self.size:
            return True
        return False
    def MinHeap(self,index):
        if not Leaf(index):
            if self.heap[index]>self.heap[self.right(index)] or self.heap[index]>self.heap[self.left(index)]:
                if self.heap[self.left(index)]<self.heap[self.right(index)]:
                    self.heap[index],self.heap[self.left(index)]=self.heap[self.left(index)],self.heap[index]
                    self.MinHeap(self.left(index))
                else:
                    self.heap[index],self.heap[self.right(index)]=self.heap[self.right(index)],self.heap[index]
                    self.MinHeap(self.right(index))
    def heap(self):
        for i in range(self.size//2,0,-1):
            self.MinHeap(i)
    def remove(self):
        ele=self.heap[self.f]
        self.heap[self.f]=self.heap[self.size]
        self.size-=1
        self.MinHeap(self.f)
        return ele


