class MinHeap():

    def __init__(self):
        self.heap = []
        self.size = 0

    def getMin(self):
        if not self.size:
            return None
        return self.heap[0]

    def extractMin(self):
        if not self.size:
            return None
        
        ### Swap first and last node
        self.heap[0], self.heap[self.size - 1] = self.heap[self.size - 1], self.heap[0] 

        ### Extract Minimum and Heapify
        minimum = self.heap.pop()
        self.size -= 1
        self.__heapify()
        return minimum

    def insert(self, value):
        self.heap.append(value)
        self.size += 1

        child_index = self.size - 1

        ### Compare child nodes with it's parents and swap to eradicate violations
        while child_index:
            parent_index = self.__getParentIndex(child_index)
            if self.heap[child_index] >= self.heap[parent_index]:
                return
            self.heap[parent_index], self.heap[child_index] = self.heap[child_index], self.heap[parent_index]
            child_index = parent_index
    
    def __heapify(self):
        terminate = False if self.size else True
        parent_index = 0

        ### Compare parent nodes with it's children and swap to eradicate violations
        while not terminate:
            left_child_index = 2*parent_index+1
            right_child_index = 2*parent_index+2
            parent_node = self.heap[parent_index]

            child_index = left_child_index if left_child_index < self.size else None
            
            if right_child_index < self.size:
                child_index = right_child_index if self.heap[left_child_index] > self.heap[right_child_index] else child_index

            if child_index is None or parent_node <= self.heap[child_index]:
                terminate = True
            else:
                self.heap[parent_index], self.heap[child_index] = self.heap[child_index], self.heap[parent_index]
                parent_index = child_index
                
    def __str__(self):
        string = " ".join(str(element) for element in self.heap)
        return string

    @staticmethod
    def __getParentIndex(index):
        return (index-1) // 2



### Driver
heap = MinHeap()
while True:
    print('insert <Value>')
    print('extractMin')
    print('getMin')
    print('print')
    do = input('What would you like to do? ').split()
    # operation = do[0].strip().lower()
    operation = do[0]
    if operation == 'insert':
        heap.insert(int(do[1]))
    elif operation == 'extractMin':
        print('\n')
        popped = heap.extractMin()
        if popped is None:
            print('Heap is Empty.')
        else:
            print('Popped value: ', int(popped))
        print('\n')
    elif operation == 'getMin':
        print('\n')
        print(heap.getMin())
        print('\n')
    elif operation == 'print':
        print('\n')
        print('Heap:', heap)
        print('\n')
