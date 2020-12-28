'''
    Time Complexity:
        Mentioned after every method

    Space Complexity:
        O(n)

    Did this code successfully run on LeetCode?:
        Couldn't find this on LeetCode.

    Problems faced while coding this:
        None

    Approach:
        Since a heap is a complete binary tree, it's understandable to use a list
        as an underlying data structure so that all the components remain connected.
        Locations:
        -> Left child of a node at index i: 2*i + 1
        -> Right child of a node at index i: 2*i + 2
        -> Parent of a node at index i: (i-1)/2
        getMin()
            -> Min will always be at the root (0th index of the list).
        insert()
            -> Addition will occurr at the end of the list.
            -> Then, the newly added will be bubbled up so that its parent is < than itself.
        extractMin()
            -> Before extraction, the min (at 0th index) is swapped with the element at the end of the list.
            -> The last element from the list is removed (O(1) for popping from the list).
            -> The first element (0th index) is bubbled down so that its parent is < than itself.
'''
class MinHeap:
    def __init__(self):
        self.storage = []


    def insert(self, num):                                      # O(log(n))
        self.storage.append(num)
        self._upheap(len(self.storage) - 1)


    def getMin(self):                                           # O(1)
        if len(self.storage) == 0:
            raise Exception('Heap is empty!')

        return self.storage[0]


    def extractMin(self):                                       # O(log(n))
        if len(self.storage) == 0:
            raise Exception('Heap is empty!')

        self._swap(0, len(self.storage) - 1)
        min = self.storage.pop()
        self._downheap(0)
        return min


    def _left(self, i):
        return (2 * i) + 1


    def _right(self, i):
        return (2 * i) + 2


    def _parent(self, i):
        return (i - 1) // 2


    def _has_left(self, i):
        return self._left(i) < len(self.storage)


    def _has_right(self, i):
        return self._right(i) < len(self.storage)


    def _swap(self, i, j):
        self.storage[i], self.storage[j] = self.storage[j], self.storage[i]


    def _upheap(self, i):
        parent = self._parent(i)
        if i <= 0 or self.storage[i] >= self.storage[parent]:
            return

        self._swap(i, parent)
        self._upheap(parent)


    def _downheap(self, i):
        small_child = self._get_smaller_child(i)
        if small_child == -1 or self.storage[small_child] >= self.storage[i]:
            return

        self._swap(i, small_child)
        self._downheap(small_child)


    def _get_smaller_child(self, i):
        if not self._has_left(i):
            return -1

        left = self._left(i)
        if not self._has_right(i):
            return left

        right = self._right(i)
        return right if self.storage[right] < self.storage[left] else left
