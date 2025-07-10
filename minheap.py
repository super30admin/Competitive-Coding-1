# //Time complexity - add-O(log n)
# // poll()	O(log n)
# // peek()	O(1)
# // Space complexity - O(1)
class MinHeap:
    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0
        self.minHeap = [0] * capacity

    def getParent(self, i):
        return (i - 1) // 2

    def getLeftChild(self, i):
        return 2 * i + 1

    def getRightChild(self, i):
        return 2 * i + 2

    def swap(self, i, j):
        self.minHeap[i], self.minHeap[j] = self.minHeap[j], self.minHeap[i]

    def add(self, x):
        if self.size == self.capacity:
            print("heap is full")
        else:
            self.minHeap[self.size] = x
            self.size += 1
            self.heapifyUp(self.size - 1)

    def heapifyUp(self, i):
        while i > 0 and self.minHeap[i] < self.minHeap[self.getParent(i)]:
            self.swap(i, self.getParent(i))
            i = self.getParent(i)

    def poll(self):
        if self.size == 0:
            print("heap is empty")
            return 0
        t = self.minHeap[0]
        self.minHeap[0] = self.minHeap[self.size - 1]
        self.size -= 1
        self.heapifyDown(0)
        return t

    def heapifyDown(self, x):
        smallest = x
        left = self.getLeftChild(x)
        right = self.getRightChild(x)

        if left < self.size and self.minHeap[smallest] > self.minHeap[left]:
            smallest = left
        if right < self.size and self.minHeap[smallest] > self.minHeap[right]:
            smallest = right

        if x != smallest:
            self.swap(x, smallest)
            self.heapifyDown(smallest)

    def peek(self):
        if self.size == 0:
            print("Heap is empty")
            return -1
        return self.minHeap[0]

    def isEmpty(self):
        return self.size == 0


if __name__ == "__main__":
    minHeap = MinHeap(10)
    minHeap.add(10)
    minHeap.add(5)
    minHeap.add(3)
    minHeap.add(2)
    minHeap.add(8)

    print("Min value:", minHeap.peek())

    while not minHeap.isEmpty():
        print(minHeap.poll(), end=" ")
