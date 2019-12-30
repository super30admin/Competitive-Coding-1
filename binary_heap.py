"""
  A min heap implementation

  Array Form: [ 5, 7, 6, 10, 15, 17, 12 ]

  Complete Binary Tree Form:
                   5
              /         \
          7               6
      /     \          /     \
    10      15        17      12

  Mappings:
    Parent -> (childIndex - 1) / 2
    Left Child -> 2 * parentIndex + 1
    Right Child -> 2 * parentIndex + 2

"""


class MinHeap:

    """
        Insertion:
            // Time Complexity: O(logn) to heapify
        Deletion:
            // Time Complexity: O(logn) to heapify
        Peek:
            // Time Complexity: O(1)
        IsEmpty:
            // Time Complexity: O(1)
        For the whole heap:
        // Space Complexity: O(n)
           where 'n' is the number items
    """

    def __init__(self, capacity=5):
        self._capacity = capacity
        self._size = 0
        self._heap = [None] * self._capacity

    def is_empty(self):
        return self._size == 0

    def peek(self):
        if self.is_empty():
            raise Exception('Heap is empty.')
        return self._heap[0]

    def add(self, item_to_add):

        self._ensure_extra_capacity()

        """
            -> Place the item at the bottom, far right, of the
            conceptual binary heap structure
            -> Increment size
        """
        self._heap[self._size] = item_to_add
        self._size += 1

        """
            Restore the heap since it is very likely messed up now
            by bubbling up the element we just put in the last empty
            position of the conceptual complete binary tree
        """
        self._heapify_up()

    def remove(self):
        if self.is_empty():
            raise Exception('Heap is empty.')

        """
            -> Grab the min item. It is at index 0.
            -> Move the last item in the heap to the "top" of the
               heap at index 0.
            -> Reduce size.
        """
        min_item = self._heap[0]
        self._heap[0] = self._heap[self._size - 1]
        self._size -= 1

        self._heapify_down()

        return min_item

    """
        Heap restoration helpers
    """

    def _heapify_down(self):
        """
            We will bubble down the item just swapped to the "top" of the heap
            after a removal operation to restore the heap
        """
        index = 0

        """
            Since a binary heap is a complete binary tree, if we have no left child
            then we have no right child. So we continue to bubble down as long as
            there is a left child.
    
            A non-existent left child immediately tells us that a right child does
            not exist.
        """
        while self._has_left_child(index):
            """
                By default assume that left child is smaller. If a right
                child exists see if it can overtake the left child by
                being smaller
            """
            smaller_child_index = self._get_left_child_index(index)
            if self._has_right_child(index) and self._right_child(index) < self._left_child(index):
                smaller_child_index = self._get_right_child_index(index)

            """
                If the item we are sitting on (the cur index) is smaller than its children
                then nothing needs to happen & sifting down is finished.
    
                But if the smaller child is smaller than the node we are
                holding, we should swap and continue sifting down.
            """
            if self._heap[index] < self._heap[smaller_child_index]:
                break
            else:
                self._swap(index, smaller_child_index)
            index = smaller_child_index

    def _heapify_up(self):
        """
            Bubble up the item we inserted at the "end" of the heap
        """
        """
          We will bubble up the item just inserted into to the "bottom"
          of the heap after an insert operation. It will be at the last index
          so index 'size' - 1
        """
        index = self._size - 1

        """
            While the item has a parent and the item beats its parent in
            smallness, bubble this item up.
        """
        while self._has_parent(index) and self._heap[index] < self._parent(index):
            self._swap(self._get_parent_index(index), index)
            index = self._get_parent_index(index)

    """
        Helpers to access our array easily, perform
        rudimentary operations, and manipulate capacity
    """

    def _swap(self, index_one, index_two):
        self._heap[index_one], self._heap[index_two] = self._heap[index_two], self._heap[index_one]

    def _ensure_extra_capacity(self):
        if self._size == self._capacity:
            self._heap.extend([None] * self._capacity)
            self._capacity *= 2

    def _get_left_child_index(self, parent_index):
        return 2 * parent_index + 1

    def _get_right_child_index(self, parent_index):
        return 2 * parent_index + 2

    def _get_parent_index(self, child_index):
        return (child_index - 1) // 2

    def _has_left_child(self, index):
        return self._get_left_child_index(index) < self._size

    def _has_right_child(self, index):
        return self._get_right_child_index(index) < self._size

    def _has_parent(self, index):
        return index != 0 and self._get_parent_index(index) >= 0

    def _left_child(self, index):
        return self._heap[self._get_left_child_index(index)]

    def _right_child(self, index):
        return self._heap[self._get_right_child_index(index)]

    def _parent(self, index):
        return self._heap[self._get_parent_index(index)]

    def print_heap(self):
        print(f'{self._heap}\n')


if __name__ == '__main__':
    min_heap = MinHeap()
    insert_items = [0, 1, 3, 2, -4, 9, 1, 2]

    print('Insertion operations in heap')
    for item in insert_items:
        min_heap.add(item)
        print(f'Add {item}')
        print(f'Min is {min_heap.peek()}')
        min_heap.print_heap()

    print('Removal operations in heap')
    for _ in insert_items:
        print(f'Remove {min_heap.remove()}')
        print(f'Min is {min_heap.peek()}')
        min_heap.print_heap()
