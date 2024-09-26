#Implementation of min heap
#min element of the array is at the top
#for item at index i, 2i+1, 2i+2 are children, parent value is less than both children
#operations
#getMin(), TC:O(1)
# extractMin(), TC:O(log n), to heapifyDown() the last element
# insert(), TC:O(log n), to heapifyUp() the new element  
# space complexity: O(n) where n is number of elements in heap

class Heap:
    def __init__(self):
        self.size = 0
        self.capacity = 10
        self.heap = [0]*(self.capacity)

    def getMin(self):
        if(self.size):
            return self.heap[0]
        else:
            return -1    

    def extractMin(self):
        if(self.size):
            item = self.heap[0]
            self.swap(0, self.size-1)
            self.heapifyDown()
            return item
        else:
            return -1    

    def insert(self, x):
        if(self.size==self.capacity):
            self.increaseCapacity()

        self.size += 1
        self.heap[self.size-1] = x
        self.heapifyUp()

    def getSize(self):
        return self.size

    def increaseCapacity(self):
        self.heap.extend([0]*10)
        self.capacity += 10

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def getMinChildIndex(self, i):
        l = 2*i + 1
        r = 2*i + 2
        if(l > self.size-1):
            return -1
        else:
            min_idx = l 

        if(r > self.size-1):
            return min_idx
        elif(self.heap[r]<self.heap[l]):
            min_idx = r

        return min_idx               

    def heapifyDown(self):
        i = 0
        c_idx = self.getMinChildIndex(i)

        while(c_idx!=-1 and self.heap[i]>self.heap[c_idx]):
            self.swap(i, c_idx)
            i = c_idx
            c_idx = self.getMinChildIndex(i)

    def getParentIndex(self, i):
        return (i-1)//2

    def heapifyUp(self):
        i = self.size-1
        p = self.getParentIndex(i)

        while(p>=0 and self.heap[p]>self.heap[i]):
            self.swap(i, p)
            i = p
            p = self.getParentIndex(i)

heap = Heap()
heap.insert(5)
heap.insert(7)
heap.insert(2)
heap.insert(8)
heap.insert(3)
heap.insert(4)
heap.insert(6)

print('Min element', heap.getMin())
print('Extracted element', heap.extractMin())
print('Min element', heap.getMin())
print(heap.insert(1))
print('Min element', heap.getMin())     