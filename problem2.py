class MinHeap:
    def __init__(self):
        self.minheap = []
    
    def getMin(self):
        if not self.minheap:
            return None
        return self.minheap[0]

    def insert(self, val):
        self.minheap.append(val)
        index = len(self.minheap) - 1

        # heapify up
        # Swapping parent and current element until it is less than parent
        # As parent needs to be the smallest of all children
        while index > 0:
            parent = (index - 1) // 2
            if self.minheap[index] < self.minheap[parent]:
                self.minheap[index], self.minheap[parent] = self.minheap[parent], self.minheap[index]
                index = parent
            else:
                break

    def extractMin(self):
        # If there are no elements return None
        if not self.minheap:
            return None

        # since the root is always the minimum value swap the root with the last value
        # remove the min value and store it to return later after we correct the heap
        self.minheap[0], self.minheap[-1] = self.minheap[-1], self.minheap[0]
        min_val = self.minheap.pop()

        index = 0
        n = len(self.minheap)


        # B/w the parent and its children find out which is the smallest and swap
       
        while True:
            l = 2*index + 1
            r = 2*index + 2
            smallest = index

            if l < n and self.minheap[l] < self.minheap[smallest]:
                smallest = l
            if r < n and self.minheap[r] < self.minheap[smallest]:
                smallest = r
            # If the parent is already the smallest among the children heap property is already satisfied 
            if smallest == index:
                break
            # If not, swap the parent with the minimum of the 2 children
            self.minheap[index], self.minheap[smallest] = self.minheap[smallest], self.minheap[index]
            index = smallest

        return min_val

