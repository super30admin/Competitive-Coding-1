#************************ Missing Number **************************
# Time Complexity : Inserting : O(log N), Deleting O(log n), Extract Min: O(log N), get min : O(log n), 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Using the array, Build the heap by inserting one at a time using percDown function. Extract the minimum value by removing the 
#root of the heap and  calling the percolate down function again. When even we need to insert a element into the heap, I added the element at the last position
#and call Percolate UP  function PercUP. We can get the min element by getting the root of the heap.


class BinHeap:
    def __init__(self):
        self.heapList = [0]
        self.currentSize = 0


    def percUp(self,i):
        while i // 2 > 0:
            if self.heapList[i] < self.heapList[i // 2]:
                tmp = self.heapList[i // 2]
                self.heapList[i // 2] = self.heapList[i]
                self.heapList[i] = tmp
            i = i // 2

    def insert(self,k):
        self.heapList.append(k)
        self.currentSize = self.currentSize + 1
        self.percUp(self.currentSize)


    def percDown(self,i):
        while (i * 2) <= self.currentSize:
            mc = self.minChild(i)
            if self.heapList[i] > self.heapList[mc]:
                tmp = self.heapList[i]
                self.heapList[i] = self.heapList[mc]
                self.heapList[mc] = tmp
            i = mc

    def minChild(self,i):
        if i * 2 + 1 > self.currentSize:
            return i * 2
        else:
            if self.heapList[i*2] < self.heapList[i*2+1]:
                return i * 2
            else:
                return i * 2 + 1
        
        

    def delMin(self):
        retval = self.heapList[1]
        self.heapList[1] = self.heapList[self.currentSize]
        self.currentSize = self.currentSize - 1
        self.heapList.pop()
        self.percDown(1)
        return retval
    
    def buildHeap(self,alist):
        i = len(alist) // 2
        self.currentSize = len(alist)
        self.heapList = [0] + alist[:]
        while (i > 0):
            self.percDown(i)
            i = i - 1
    
    def print(self):
        print(self.heapList)

bh = BinHeap()
bh.buildHeap([9,5,6,2,3])


print(bh.delMin())
print(bh.print())
bh.insert(4)
print(bh.print())
print(bh.delMin())
print(bh.print())
bh.insert(7)
print(bh.delMin())
print(bh.print())
bh.insert(10)
print(bh.delMin())
print(bh.delMin())
print(bh.print())