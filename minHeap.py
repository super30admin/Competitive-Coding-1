"""
// Time Complexity : o(1) - getMin(), o(logn) - extractMin(), insert()
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : not on leetcode
// Any problem you faced while coding this : no
"""

class minHeap:
    def __init__(self,size):
        self.size = size #max heap size
        self.cur_size = 0
        self.minheap = [-1] * (self.size+1) #initialiazing heap
        self.minheap[0] = -2 

    def insert(self, ele):
        if self.cur_size >= self.size: # if heap is at max capacity
            return


        self.cur_size += 1 # increase size
        self.minheap[self.cur_size] = ele #insert element at last position

        cur_ptr = self.cur_size # set current ptr to last position

        while cur_ptr>=2 and self.minheap[cur_ptr] < self.minheap[cur_ptr//2]: # loop to insert element at its correct position
            self.minheap[cur_ptr], self.minheap[cur_ptr//2] =  self.minheap[cur_ptr//2], self.minheap[cur_ptr] #if current val is smaller than its parent value then swap
            cur_ptr = cur_ptr//2 #set cur_ptr to parent

    def extractMin(self):

        ex_val = self.minheap[1] #store the value to be removed

        self.minheap[1] = self.minheap[self.cur_size] #put last element at root, position 1
        self.cur_size -= 1 #decrease size

        ptr = 1 # ptr to iterate over heap to place the value at root at its correct position
    
        while ptr <= self.cur_size and self.minheap[ptr*2] != -1 and self.minheap[ptr*2 + 1] != -1: # loop will run till ptr is not leaf

            if self.minheap[ptr] < self.minheap[ptr*2] and self.minheap[ptr] < self.minheap[ptr*2 + 1]: # if the value at ptr is smaller than both its children, break
                break
            
            if self.minheap[2*ptr+1] > self.minheap[2*ptr]: #if left child is smaller than right child, swap value at ptr with value at left 
                self.minheap[ptr], self.minheap[2*ptr] = self.minheap[2*ptr], self.minheap[ptr]
                ptr = ptr*2 #update ptr to point to the left child 
            else: #if right child is smaller than left child, swap value at ptr with value at right 
                self.minheap[ptr], self.minheap[2*ptr +1 ] = self.minheap[2*ptr+1], self.minheap[ptr]
                ptr = ptr*2+1#update ptr to point to the left child 
        return ex_val

    def getMin(self):
        
        return self.minheap[1] #return value at root

if __name__ == "__main__": 
      
    print('The minHeap is ') 
    MinHeap = minHeap(15) 
    MinHeap.insert(5) 
    MinHeap.insert(3) 
    MinHeap.insert(17) 
    MinHeap.insert(10) 
    MinHeap.insert(84) 
    MinHeap.insert(19) 
    MinHeap.insert(6) 
    MinHeap.insert(22) 
    MinHeap.insert(9) 

    print(MinHeap.extractMin())
    print(MinHeap.getMin())
    