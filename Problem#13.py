'''
Problem Name: Interview Problem: Design Min Heap

Source Link: https://www.geeksforgeeks.org/min-heap-in-java/
'''


# Time Complexity : O(log n) for insertion and removal operations, O(n) for printing the heap, where n is the number of elements in the heap. O(n) for heapify operation in the worst case. O(n) for building the heap if we insert all elements one by one.
# Space Complexity : O(n) for storing the heap elements, where n is the number of elements in the heap.
# Did this code successfully run on Leetcode : Yes, the code runs successfully for the Min Heap implementation and test cases.
# Any problem you faced while coding this : Yes, I had to ensure that the heap properties were maintained correctly during insertion and removal operations, especially when swapping elements and heapifying.

class MinHeap:
    def __init__(self, capacity):
        self.maxSize = capacity
        self.size = 0
        self.heap = [0] * capacity
    
    def parent(self, index):
        return (index - 1) // 2
    
    def leftChild(self, index):
        return 2 * index + 1
    
    def rightChild(self, index):
        return 2 * index + 2
    
    def isLeaf(self, index):
        return index >= self.size // 2 and index < self.size
    
    def swap(self, index1, index2):
        self.heap[index1], self.heap[index2] = self.heap[index2], self.heap[index1]
    
    def heapify(self, index):
        if self.isLeaf(index):
            return
        
        left = self.leftChild(index)
        right = self.rightChild(index)
        smallest = index

        if left < self.size and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < self.size and self.heap[right] < self.heap[smallest]:
            smallest = right
        
        if smallest != index:
            self.swap(index, smallest)
            self.heapify(smallest)
    
    def insert(self, element):
        if self.size >= self.maxSize:
            return "Heap is full"
        
        self.heap[self.size] = element
        current = self.size
        self.size += 1

        while current > 0 and self.heap[current] < self.heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current  = self.parent(current)

    def remove(self):
        if self.size == 0:
            return "Heap is empty"
        
        root = self.heap[0]
        self.heap[0] = self.heap[self.size - 1]
        self.size -= 1
        self.heapify(0)
        return root

    def printHeap(self):
        for i in range((self.size - 2)//2 + 1):
            print(f"PARENT: {self.heap[i]}", end="")
            if self.leftChild(i) < self.size:
                print(f", LEFT CHILD: {self.heap[self.leftChild(i)]}", end="")
            if self.rightChild(i) < self.size:
                print(f", RIGHT CHILD: {self.heap[self.rightChild(i)]}", end="")
            print()

# Example usage
if __name__ == "__main__":
    min_heap = MinHeap(10)
    min_heap.insert(3)
    min_heap.insert(1)
    min_heap.insert(6)
    min_heap.insert(5)
    min_heap.insert(2)
    min_heap.insert(4)

    print("Min Heap:")
    min_heap.printHeap()

    print("Removed element:", min_heap.remove())
    print("Min Heap after removal:")
    min_heap.printHeap()
    min_heap.insert(0)
    print("Min Heap after inserting 0:")
    min_heap.printHeap()
    print("Removed element:", min_heap.remove())
    print("Min Heap after removal:")
    min_heap.printHeap()
    print("Removed element:", min_heap.remove())
    print("Min Heap after removal:")        