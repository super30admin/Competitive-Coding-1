#Time Complexity : O(logN), average, N being the number of values in array.
#Space Complexity : O(1), because besides input and output, only constant space is used.
#Did this code successfully run on Leetcode : Did not find link to leetcode.
#Any problem you faced while coding this : I had a little trouble debugging and had issue 
# with None inside the array at first. 

#Your code here along with comments explaining your approach in three sentences only
''' Insert or extract using the 2k+1 and 2k+2 formula and the minheap properties. 
'''
class MinHeap:
    def __init__(self, array):
        self.min_heap = array
    # returns just the top element without modifying. 
    def getMin(self):
        return self.min_heap[0]
    
    # eliminates the first value and pushes up the smaller values. 
    def extractMin(self):
        index = 0
        while(index<len(self.min_heap)):
            left = 2*index+1
            right = 2*index+2
            if left<len(self.min_heap) and self.min_heap[left]<=self.min_heap[right]:
                self.min_heap[index]=self.min_heap[left]
                index = left
            elif right<len(self.min_heap) and self.min_heap[right]>self.min_heap[left]:
                self.min_heap[index]=self.min_heap[right]
                index = right
            else: 
                break
        if index<len(self.min_heap):
            self.min_heap[index]=None
        else:
            above = int((index-1)/2)
            self.min_heap[above]=None

    # find a None and place in value, or append to end. Then, pushes up until still a minheap.
    def insert(self, value):
        half = int((len(self.min_heap)+1)/2)
        half_index = half-1
        inserted = False
        end_index = 0
        for i in range(half):
            index = half_index+i
            if self.min_heap[index]==None:
                self.min_heap[index]=value
                inserted = True
                end_index = index
                break
        if inserted==False:
            self.min_heap.append(value)
            end_index = len(self.min_heap)-1
        index = end_index

        above = int((index-1)/2)
        while(above>=0):
            if self.min_heap[above]>self.min_heap[index]:
                temp = self.min_heap[index]
                self.min_heap[index]=self.min_heap[above]
                self.min_heap[above]=temp
                index = above
                above = int((index-1)/2)
            else:
                break






array = [1,2,4,3,5,6,7]
print(array)
m = MinHeap(array)
print(m.getMin())
print(array)
m.extractMin()
print(array)
m.insert(1)
print(array)