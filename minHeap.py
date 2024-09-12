class MinHeap:
    def __init__(self, a=[]):
        '''__init__ Function definition. '''
        self.l = len(a)
        self.a = [-100]
        self.a.extend(a)
    
    def __repr__(self):
        if len(self.a) == 1 and self.a[0] == -100:
            return "Heap Empty"
        return str(self.a[1:])
    
    def insert(self, element):
        '''insert Function definition. '''
        # Time Complexity: O(logn), since we have at most "height of the heap" swaps for n elements in the heap, i.e. logn
        self.a.append(element)
        self.l += 1
        i = self.l
        while self.a[i] < self.a[i//2] and i > 1:
            self.a[i], self.a[i//2] = self.a[i//2], self.a[i]
            i //= 2

    def get_min(self):
        '''get_min Function definition. '''
        # Time Complexity: O(1), returns the minimum element of the heap that is stored at index 1
        return self.a[1]

    def extract_min(self):
        '''extract_min Function definition. '''
        # Time Complexity: O(logn), At most logn swaps downward (height of the heap)
        temp = self.a[1]
        i = 1
        right_child = i * 2 + 1
        left_child = i * 2
        self.a[i] = self.a[self.l]
        del self.a[self.l]
        self.l -=1
        while self.a[i] > self.a[left_child] or self.a[i] > self.a[right_child]:
            if self.a[i] > self.a[left_child] and self.a[i] > self.a[right_child]: # Greater than both
                if self.a[left_child] < self.a[right_child]:
                    self.a[i], self.a[left_child] = self.a[left_child], self.a[i]
                else:
                    self.a[i], self.a[right_child] = self.a[right_child], self.a[i]
            elif self.a[i] > self.a[left_child]:
                self.a[i], self.a[left_child] = self.a[left_child], self.a[i]
            elif self.a[i] > self.a[right_child]:
                self.a[i], self.a[right_child] = self.a[right_child], self.a[i]
        return temp
    
    def heap_size(self):
        '''heap_size Function definition. '''
        return self.l

mh = MinHeap()
mh.insert(1)
mh.insert(2)
mh.insert(3)
mh.insert(4)
mh.insert(5)
mh.insert(6)
mh.insert(0)
print(mh.heap_size())
print(mh)
print(mh.extract_min())
print(mh)
print(mh.heap_size())