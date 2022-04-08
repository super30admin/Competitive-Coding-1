# Min Heap 
# Operations on Min Heap:

# getMin(): It returns the root element of Min Heap. O(1)
# extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
# insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)

class MinHeap:

    def __init__(self):
        self.heap =[]

    def insert(self,num):
        self.heap.append(num)
        self.__traverse_up(len(self.heap)-1)

    def getMin(self):
        return self.heap[0]

    def extractMin(self):
        self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]
        mini = self.heap.pop()
        self.__traverse_down(0)
        return mini

    def __traverse_down(self, index):

        left = 2*index+1
        right = 2* index +2

        current = index

        if(left < len(self.heap) and self.heap[left] < self.heap[current]):
            current = left
        if(right < len(self.heap) and self.heap[right] < self.heap[current]):
            current = right
        if(current == index):
            return

        self.heap[index], self.heap[current] = self.heap[current], self.heap[index]
        self.__traverse_down(current)

    def __traverse_up(self, index):

        if index ==0:
            return 
        
        parent = (index-1)//2

        if (parent>=0 and self.heap[parent]> self.heap[index]):
            self.heap[parent], self.heap[index ] = self.heap[index ] ,self.heap[parent]
            self.__traverse_up(parent)
    
#testing
ob = MinHeap()
arr = [4,2,6,5,8,9,1]
for i in arr:
    ob.insert(i)
    print(ob.heap)

for i in arr:
    ob.extractMin()
    print(ob.heap)