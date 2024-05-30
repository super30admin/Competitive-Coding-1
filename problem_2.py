# Design a heap methods
class MinHeap:
    def __init__(self, maxsize):
        """
        Constructor for MinHeap class.

        Parameters
        ----------
        maxsize : int
            Maximum size of the heap.
        """
        self.maxsize = maxsize
        self.size = 0 
        self.Heap = [float('-inf')] + [0] * maxsize
        self.FRONT = 1
# Time O(1)
    def parent(self, pos):
        """
        Return the position of the parent for the node currently at pos.

        Parameters
        ----------
        pos : int
            Position of the node.

        Returns
        -------
        int
            Position of the parent node.
        """
        return pos // 2
# Time O(1)
    def leftChild(self, pos):
        """
        Return the position of the left child for the node currently at pos.

        Parameters
        ----------
        pos : int
            Position of the node.

        Returns
        -------
        int
            Position of the left child node.
        """
        return 2 * pos
# Time O(1)
    def rightChild(self, pos):
        """
        Return the position of the right child for the node currently at pos.

        Parameters
        ----------
        pos : int
            Position of the node.

        Returns
        -------
        int
            Position of the right child node.
        """
        return 2 * pos + 1
# Time O(1)
    def isLeaf(self, pos):
        """
        Return true if the node at pos is a leaf node.

        Parameters
        ----------
        pos : int
            Position of the node.

        Returns
        -------
        bool
            True if the node is a leaf, False otherwise.
        """
        return pos >= (self.size // 2) and pos <= self.size 
# Time O(1)
    def swap(self, fpos, spos):
        """
        Swap two nodes in the heap.

        Parameters
        ----------
        fpos : int
            Position of the first node.
        spos : int
            Position of the second node.
        """
        self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos]
# Time O(logn)
    def minHeapify(self, pos):
        """
        Heapify the node at pos to maintain the min-heap property.

        Parameters
        ----------
        pos : int
            Position of the node to heapify.
        """
        if not self.isLeaf(pos):
            left = self.leftChild(pos)
            right = self.rightChild(pos)
            smallest = pos
            if left <= self.size and self.Heap[left] < self.Heap[smallest]:
                smallest = left
            if right <= self.size and self.Heap[right] < self.Heap[smallest]:
                smallest = right
            if smallest != pos:
                self.swap(pos, smallest)
                self.minHeapify(smallest)

# Time O(logn)
    def insert(self, element):
        """
        Insert a node into the heap.

        Parameters
        ----------
        element : int
            Element to be inserted.
        """
        if self.size >= self.maxsize:
            return
        self.size += 1
        self.Heap[self.size] = element

        current = self.size
        while self.Heap[current] < self.Heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)

    def printHeap(self):
        """
        Print the contents of the heap.
        """
        for i in range(1, (self.size // 2) + 1):
            print(" PARENT : " + str(self.Heap[i]) +
                  " LEFT CHILD : " + str(self.Heap[2 * i]) +
                  " RIGHT CHILD : " + str(self.Heap[2 * i + 1]))
# Time O(logn)
    def remove(self):
        """
        Remove and return the minimum element from the heap.

        Returns
        -------
        int
            The minimum element from the heap.
        """
        popped = self.Heap[self.FRONT]
        self.Heap[self.FRONT] = self.Heap[self.size]
        self.size -= 1
        self.minHeapify(self.FRONT)
        return popped

# Main function to test the MinHeap class
if __name__ == "__main__":
    print("The Min Heap is ")

    minHeap = MinHeap(15)
    minHeap.insert(5)
    minHeap.insert(3)
    minHeap.insert(17)
    minHeap.insert(10)
    minHeap.insert(84)
    minHeap.insert(19)
    minHeap.insert(6)
    minHeap.insert(22)
    minHeap.insert(9)

    minHeap.printHeap()

    print("The Min val is " + str(minHeap.remove()))