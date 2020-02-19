class MinHeap(object):
    '''
    Solution:
    1.  The goal is to extract minimum element in constant time and always place the minimum element at the root or
        first index.
    2. So, to achieve that we perform upHeapify and downHeapify while insertion and deletion respectively which performs
        jumps and swaps in logn time and constant space

    --- Not found on Leetcode and so performed custom testcases.
    Insertion, ExtractMin functions O(logn) Time and O(1) Space
    getMin function O(1) Time and O(1) Space
    '''

    def __init__(self):
        self.heap = []
        self.size = 0

    def getMin(self):
        # O(1) Time Complexity | O(1) Space Complexity
        if self.size <= 0:
            return -1
        return self.heap[0]

    def extractMin(self):
        # O(logn) Time Complexity | O(1) Space Complexity
        if self.size <= 0:
            return -1
        minimum = self.heap[0]
        self.heap[0] = self.heap[self.size - 1]
        self.heap.pop()
        self.size -= 1
        self.__downHeapify()
        return minimum

    def insert(self, value):
        # O(logn) Time Complexity | O(1) Space Complexity
        self.heap.append(value)
        self.size += 1
        self.__upHeapify()
        return

    def __getLeftChildIndex(self, index):
        return 2 * index + 1;

    def __getRightChildIndex(self, index):
        return 2 * index + 2;

    def __getParentIndex(self, index):
        return int((index - 1) / 2)

    def __hasLeftChild(self, index):
        return self.__getLeftChildIndex(index) < self.size

    def __hasRightChild(self, index):
        return self.__getRightChildIndex(index) < self.size

    def __hasParent(self, index):
        return self.__getParentIndex(index) >= 0

    def __getLeftChild(self, index):
        leftId = self.__getLeftChildIndex(index)
        return self.heap[leftId]

    def __getRightChild(self, index):
        rightId = self.__getRightChildIndex(index)
        return self.heap[rightId]

    def __getParent(self, index):
        parentId = self.__getParentIndex(index)
        return self.heap[parentId]

    def __swap(self, index1, index2):
        temp = self.heap[index1]
        self.heap[index1] = self.heap[index2]
        self.heap[index2] = temp

    def __downHeapify(self):
        currentId = 0
        while(self.__hasLeftChild(currentId)):
            # swap current index value with the smallest of children if it is less than any one of them
            smallerChildIndex = self.__getLeftChildIndex(currentId)     # initially assign it to left index
            if (self.__hasRightChild(currentId) and self.__getRightChild(currentId) < self.__getLeftChild(currentId)):
                smallerChildIndex = self.__getRightChildIndex(currentId)
            if (self.heap[currentId] < self.heap[smallerChildIndex]):         # if everything is fine, break the while loop
                break
            else:                                                             # else swap
                self.__swap(currentId, smallerChildIndex)
            currentId = smallerChildIndex
        return

    def __upHeapify(self):
        currentId = self.size - 1
        # swap it with the parent element if the value is less than parent element
        while(self.__hasParent(currentId) and self.__getParent(currentId) > self.heap[currentId]):
            self.__swap(currentId, self.__getParentIndex(currentId))
            currentId = self.__getParentIndex(currentId)
        return

# heap = MinHeap()
# heap.insert(10)
# print(heap.heap)
# heap.insert(20)
# print(heap.heap)
# heap.insert(15)
# print(heap.heap)
# heap.insert(5)
# print(heap.heap)
# heap.insert(25)
# print(heap.heap)
# print(heap.getMin())
# print(heap.extractMin())
# print(heap.getMin())
# print(heap.extractMin())
# print(heap.getMin())
# print(heap.extractMin())
# print(heap.getMin())
# print(heap.extractMin())
# print(heap.getMin())
# print(heap.extractMin())
# print(heap.getMin())
# print(heap.extractMin())
