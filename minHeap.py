'''
Approach:
1. Create a list called hashList which will store all the values
2. The lowest value will be the 0th index
3. Insert():
    1. Append the value into the hashList
    2. Check if "parent" of current inserted index is greater
    3. If yes, we will perform bubbleUp approach where we will swap the parent and current inserted value
    4. Once done we wil iteratively check if the parent of swaped value is greater than it's parent
    5. Time Complexity 0(logn) as we are not scanning the entire list, we are just checking the parent of
       currentNode and scanning up in (1/2)
4. getMin():
    1. It will simply return the 0th index
5. extractMin():
    1. Swap the 0th element with the last element
    2. Once done pop the last element from the hashList
    3. Check if our root now is following the min hash list approach
    4. If no, follow the bubble-down approach. Our parent-node will be swapped with the
    lowest/smallest min node.
    5. Time Complexity 0(logn) as we are not scanning the entire list, we are just checking the children of
       parentNode and scanning down in in (2*)
'''

class minHeap:
    def __init__(self):
        self.heapList = []
        self.count = 0
        
    def insert(self,val):
        
        # 1. Append val into min heap
        self.heapList.append(val)
        
        # 2. Increase count
        self.count+=1
        
        # 3. Perform minHeap check
        if self.count == 1:
            return self.heapList[self.count-1]
        
        else:
            # get currentIndex 
            currentIndex = self.count-1
            parentIndex = (currentIndex-1)//2
            
            # 3.1 Violation check; parentIndex > childIndex
            while (parentIndex > -1) and (self.heapList[parentIndex]>self.heapList[currentIndex]):
                # Bubble-up approach
                
                # Swap parentIndex and currentIndex values
                self.heapList[currentIndex],self.heapList[parentIndex] = self.heapList[parentIndex],self.heapList[currentIndex]
                
                # Update currentIndex and parentIndex rfr's
                currentIndex = parentIndex
                parentIndex = (currentIndex-1)//2
                
                continue
            
            return self.heapList[currentIndex]
    
    def getMin(self):
        if self.count > 0:
            return self.heapList[0]
        else:
            return None

    def extractMin(self):
        
        if self.count == 0:
            return None
        
        # 1. Swap 0th index value with count-1 index value
        self.heapList[0],self.heapList[-1] = self.heapList[-1], self.heapList[0]
        
        # 2. Pop the last element from the heapList
        self.heapList.pop()
        
        # 3. Update count
        self.count -= 1
        
        # 4. set currentIndex
        currentIndex = 0
        
        # 4. Bubble down approach
        while (currentIndex) < self.count:
            
            # Case 1: 'currentIndex' value is greater than both 'leftChild' and 'rightChild'
            if ((2*currentIndex+1<self.count)and(self.heapList[currentIndex] > self.heapList[2*currentIndex+1])) and ((2*currentIndex+2<self.count) and (self.heapList[currentIndex] > self.heapList[2*currentIndex+2])):
                # currentIndex value is greater than both leftChild and rightChild
                
                # Check if leftChild is minimum
                if self.heapList[2*currentIndex+1] < self.heapList[2*currentIndex+2]:
                    
                    # Swap leftChild with currentIndex
                    self.heapList[currentIndex], self.heapList[2*currentIndex+1] = self.heapList[2*currentIndex+1], self.heapList[currentIndex]
                    currentIndex = 2*currentIndex+1
                    
                else:
                    
                    # Swap rightChild with currentIndex
                    self.heapList[currentIndex], self.heapList[2*currentIndex+2] = self.heapList[2*currentIndex+2], self.heapList[currentIndex]
                    currentIndex = 2*currentIndex+2
                
            # Case 2: 'currentIndex' value is only greater than 'leftChild'
            elif (2*currentIndex+1<self.count) and (self.heapList[currentIndex] > self.heapList[2*currentIndex+1]):
                # Swap leftChild with currentIndex
                self.heapList[currentIndex], self.heapList[2*currentIndex+1] = self.heapList[2*currentIndex+1], self.heapList[currentIndex]
                currentIndex = 2*currentIndex+1
            
            # Case 3: 'currentIndex' value is only greater than 'rightChild'
            elif (2*currentIndex+2<self.count) and (self.heapList[currentIndex] > self.heapList[2*currentIndex+2]):
                # Swap rightChild with currentIndex
                self.heapList[currentIndex], self.heapList[2*currentIndex+2] = self.heapList[2*currentIndex+2], self.heapList[currentIndex]
                currentIndex = 2*currentIndex+2
            
            # Case 4: Everything is OK
            else:
                break
            
            continue    
        
        # 5. return the updated heap list
        return self.heapList    
            
minHeapObj = minHeap()

minHeapObj.insert(13)
minHeapObj.insert(16)
minHeapObj.insert(31)
minHeapObj.insert(41)
minHeapObj.insert(51)
minHeapObj.insert(100)
minHeapObj.insert(41)

print('1. Min heap list BEFORE is:\t',minHeapObj.heapList)

minHeapObj.insert(5)

print('2. Min heap list AFTER is:\t',minHeapObj.heapList)
print('3. Min in min-heap is:\t',minHeapObj.getMin())

print('4. Min heap after EXTRACT-MIN is:\t',minHeapObj.extractMin())

print(minHeapObj.extractMin())
print(minHeapObj.extractMin())
print(minHeapObj.extractMin())
print(minHeapObj.extractMin())


print(minHeapObj.extractMin())
print(minHeapObj.extractMin())

print(minHeapObj.extractMin())
print(minHeapObj.extractMin())
        