'''
Time Complexity: O(n)
Space Complexity: O(n)
'''
import math
from multiprocessing import heap
class MinHeap:
    def __init__(self,minHeap=[]):
        self.minHeap = minHeap
    
    def insert(self,val):
        heapSize = self.getSize()
        if(heapSize==0):
            self.minHeap.append(val)
        else:
            parent = math.ceil((heapSize/2)-1)
            self.minHeap.append(val)
            if(self.minHeap[parent]>self.minHeap[heapSize]):
                temp = self.minHeap[parent]
                self.minHeap[parent] = self.minHeap[heapSize]
                self.minHeap[heapSize] = temp

    def delete(self):
        heapSize = self.getSize()
        temp = self.minHeap[0]
        self.minHeap[0] = self.minHeap[heapSize-1]
        self.minHeap[heapSize-1] = temp
        del self.minHeap[-1]
        indexSwap = 0 
        while(True):
            childLeft = indexSwap*2 +1
            childRight = indexSwap*2 +2
            if(childLeft >= heapSize and childRight >= heapSize):
                break
            elif(childLeft < heapSize and childRight < heapSize):
                minEle = min(self.minHeap[childLeft], self.minHeap[childRight])
                indexTo = self.minHeap.index(minEle)
            elif(childLeft < heapSize and childRight >= heapSize):
                if(self.minHeap[childLeft]<self.minHeap[indexSwap]):
                    indexTo = childLeft
                else:
                    break
            temp = self.minHeap[indexTo]
            self.minHeap[indexTo] = self.minHeap[indexSwap]
            self.minHeap[indexSwap] = temp
            indexSwap = indexTo

        
    def getSize(self):
        return len(self.minHeap)

    def printHeap(self):
        print(self.minHeap)

h = MinHeap()
h.insert(13)
h.insert(31)
h.insert(8)
h.insert(24)
h.printHeap()
h.delete()
h.printHeap()