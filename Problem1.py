class MinHeap:
    """
    Time complexity - O(log n)
    Space complexity - O(1)
    """

    def __init__(self):
        # Initializes an empty min heap.
        self.heap = []

    def parent(self, i):
        # Returns the index of the parent of the element at index i.
        return (i - 1) // 2

    def left_child(self, i):
        # Returns the index of the left child of the element at index i.
        return 2 * i + 1

    def right_child(self, i):
        # Returns the index of the right child of the element at index i.
        return 2 * i + 2

    def swap(self, i, j):
        # Swaps the elements at indices i and j in the heap.
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def heapify_up(self, i):
        # Restores the heap property by moving the element at index i up the heap.
        while i > 0 and self.heap[i] < self.heap[self.parent(i)]:
            # While the element has a parent and is smaller than its parent
            parent = self.parent(i)
            self.swap(i, parent)
            i = parent

    def heapify_down(self, i):
        # Restores the heap property by moving the element at index i down the heap.
        n = len(self.heap)  # Get the length of the heap
        smallest = i  # Assume the current element is the smallest

        left = self.left_child(i)  # Calculate the index of the left child
        if left < n and self.heap[left] < self.heap[smallest]:
            # If the left child exists and is smaller than the current smallest element
            smallest = left

        right = self.right_child(i)  # Calculate the index of the right child
        if right < n and self.heap[right] < self.heap[smallest]:
            # If the right child exists and is smaller than the current smallest element
            smallest = right

        if smallest != i:
            # If the current element is not the smallest
            # Swap the current element with the smallest child
            self.swap(i, smallest)
            # Recursively heapify down the swapped child
            self.heapify_down(smallest)

    def insert(self, item):
        # Inserts an item into the min heap.
        self.heap.append(item)  # Append the item to the end of the heap
        # Restore the heap property by moving the item up
        self.heapify_up(len(self.heap) - 1)

    def extract_min(self):
        # Removes and returns the minimum element from the heap.
        if not self.heap:
            return None

        # Swap the minimum element with the last element
        self.swap(0, len(self.heap) - 1)
        min_element = self.heap.pop()  # Remove the minimum element from the heap
        # Restore the heap property by moving the new root down
        self.heapify_down(0)

        return min_element

    def get_min(self):
        # Returns the minimum element from the heap without removing it.
        return self.heap[0] if self.heap else None

    def is_empty(self):
        # Checks if the heap is empty.
        return len(self.heap) == 0
