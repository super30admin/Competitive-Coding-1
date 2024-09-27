class Min_Heap:
    
    def __init__(self) -> None:
        self.heapList = [0] # 0 is not part of the list
                            # it is used to make calculations simpler
        self.currentSize = 0
    
    #insert in array, first insert at the end and percolate up to its suitable position
    #time complexity O(log n)
    def insert(self, x):
        self.heapList.append(x)
        self.currentSize = self.currentSize + 1
        self.percolateUp(self.currentSize)

    # return the root and heapfiy the array
    # time complexity - O(log n)
    def extractMin(self):
        if(self.currentSize==0):
            return -1
        root_value = self.heapList[1]
        self.heapList[1] = self.heapList[self.currentSize]
        self.currentSize -= 1
        self.heapList.pop()
        self.percolateDown(1)
        return root_value

    """during insertion an element is always added at the end of the array at
    vacant position i.e at the last level of the tree. this element is percolated up 
    to its right positon so that heap property is maintained"""
    def percolateUp(self, i):
        while( i//2 > 0):
            if(self.heapList[i] < self.heapList[i//2]):
                self.heapList[i], self.heapList[i//2] = self.heapList[i//2], self.heapList[i]
            i = i//2

    # method to find the minimimum child of a parent
    def findMinimumChildOfParent(self, i):
        if( 2*i + 1 > self.currentSize):
            return i*2
        else:
            if(self.heapList[2*i] < self.heapList[2*i + 1]):
                return i * 2
            else:
                return 2*i + 1
    """ whenever a root element(1st index) is removed the last element is replaced
    at the top, now this element is percolated down to its suitable position """
    def percolateDown(self, i):
        while(i*2 <= self.currentSize):
            min_child = self.findMinimumChildOfParent(i)
            if(self.heapList[i] > self.heapList[min_child]):
                self.heapList[i], self.heapList[min_child] = self.heapList[min_child], self.heapList[i]
            i = min_child
    
    #returns the minimimum element i.e element at 1st index
    #time complexity - constant time
    def getMin(self):
        if(self.currentSize != 0):
            return self.heapList[1]
        return -1

    def buildHeap(self, aList):
        self.currentSize = len(aList)
        self.heapList = [0] + aList[:]
        i = self.currentSize//2
        while(i>0):
            self.percolateDown(i)
            i-=1
    
    # printing a heap after building it
    def printheap(self):
        [print(i, end=" ") for i in self.heapList[1:]]
        print()

import random
mylist= [random.randrange(0,10)%10 for x in range(10)]
print (mylist)
myheap=Min_Heap()
myheap.buildHeap(mylist)
myheap.printheap()
print("min value " + str(myheap.getMin()), end="\n" )
for i in range(4):
    print("delete " + str(myheap.extractMin()))

myheap.printheap()