# Time Complexity : Insert -> O(logn) getMin -> O(1) extractMin -> O(logn)
# Space Complexity : Insert -> O(1) getMin -> O(1) extractMin -> O(1) , DataStructure -> O(n)
# Any problem you faced while coding this : No

class MinHeap:
    # intializing list
    def __init__(self):
        self.heap = [None]

    #insert at last and recursively sending to parent if value is less than the parent
    def insert(self,val):
        self.heap.append(val)
        self.__elevate(len(self.heap)-1)
    
    # get number at index 1
    def getMin(self):
        if len(self.heap) == 1:
            return None
        return self.heap[1]
    
    # swapping the first and removing the last item and heapifying the present first element
    def extractMin(self):
        if len(self.heap) == 1:
            return None
        if len(self.heap) == 2:
            return self.heap.pop()
        self.heap[1],self.heap[len(self.heap)-1] = self.heap[len(self.heap)-1],self.heap[1]
        a = self.heap.pop()
        self.__goDepths(1)
        return a
    
    #checking the parent and elevating the current value
    def __elevate(self,ind):
        if ind == 1:
            return
        par = ind // 2
        if self.heap[par] > self.heap[ind]:
            self.heap[par],self.heap[ind] = self.heap[ind],self.heap[par]
            return self.__elevate(par)
        else:
            return
    #checking the children and heapifying
    def __goDepths(self,ind):
        if ind >= len(self.heap):
            return
        val = ind
        l = 2 * ind
        r = 2 * ind + 1
        if l < len(self.heap) and self.heap[l] < self.heap[val]:
            val = l
        if r < len(self.heap) and self.heap[r] < self.heap[l]:
            val = r
        if val == ind:
            return
        else:
            self.heap[val],self.heap[ind] = self.heap[ind],self.heap[val]
            return self.__goDepths(val)