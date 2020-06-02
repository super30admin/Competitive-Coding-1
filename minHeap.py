# Time Complexity :  O(log(n)) for every operation except getMin (O(1)).
# Space Complexity : O(1), since there was no other data structure used for computation.
# Did this code successfully run on Leetcode : N.A.
# Any problem you faced while coding this : No, just had to debug a little.

# Your code here along with comments explaining your approach
class minHeap(object):
    def __init__(self):
        self.heap = []
    # parent index in array for any elem
    def parentIdx(self, idx):
        return (idx - 1) / 2
    # left child idx in array for any elem
    def leftChildIdx(self, idx):
        return (2 * idx) + 1
    # right child udx in array for any elem
    def rightChildIdx(self, idx):
        return (2 * idx) + 2
    # swap function
    def swap(self, idx1, idx2):
        self.heap[idx1], self.heap[idx2] = self.heap[idx2], self.heap[idx1]

    # add element at end of array and fixup
    def insert(self, val):
        self.heap.append(val)
        self.fixUp(len(self.heap)-1)

    # remove and return head node, swap head with last elem in array and fix down
    def extractMin(self):
        if not self.isEmpty():
            toReturn = self.heap[0]
            self.swap(0, len(self.heap)-1)
            self.heap.pop()
            self.fixDown(0)
            return toReturn
        else:
            print("The heap is Empty.")

    # return head node without removal
    def getMin(self):
        if not self.isEmpty():
            return self.heap[0]
        else:
            print("The heap is empty.")

    # fixUp to maintain minHeap property after insertion
    # while parent in array and parent > child
    # swap parent and child, traverse up and repeat
    def fixUp(self, idx):
        parent = self.parentIdx(idx)
        while parent >= 0 and self.heap[parent] > self.heap[idx]:
            self.swap(idx, parent)
            idx = parent
            parent = self.parentIdx(idx)

    # fixDown to maintain minHeap property after removal
    # while leftChild in array and if parent > min(left, right) child
    # swap parent and child, traverse down and repeat
    def fixDown(self, idx):
        size = len(self.heap)
        leftChild = self.leftChildIdx(idx)
        rightChild = self.rightChildIdx(idx)
        while leftChild < size:
            if rightChild < size:
                if self.heap[leftChild] < self.heap[rightChild]:
                    if self.heap[idx] > self.heap[leftChild]:
                        self.swap(idx, leftChild)
                        idx = leftChild
                else:
                    if self.heap[idx] > self.heap[rightChild]:
                        self.swap(idx, rightChild)
                        idx = rightChild
            else:
                self.swap(idx, leftChild)
                idx = leftChild
            leftChild = self.leftChildIdx(idx)
            rightChild = self.rightChildIdx(idx)

    def isEmpty(self):
        return len(self.heap) == 0


if __name__ == '__main__':
    minHeap = minHeap()
    minHeap.getMin()
    minHeap.insert(8)
    minHeap.insert(0)
    minHeap.insert(7)
    minHeap.insert(4)
    minHeap.insert(10)
    minHeap.insert(27)
    minHeap.insert(1)
    minHeap.insert(2)
    minHeap.insert(19)
    minHeap.insert(23)
    print "After 10 insertions", minHeap.heap
    print "getMin", minHeap.getMin()
    print "After getMin", minHeap.heap
    minHeap.extractMin()
    print "After extractMin", minHeap.heap
    minHeap.extractMin()
    print "After extractMin", minHeap.heap
    minHeap.extractMin()
    print "After extractMin", minHeap.heap
