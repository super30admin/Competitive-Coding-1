#Time Complexity : O(1) - getMin(), O(logn) - extractMin(), O(logn) - insert
#Space Complexity : O(1) no auxilary space is used
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class MinHeap:
    def __init__(self):
        self.heap = [0]
        self.size = 0

    def getMin(self):
        return self.heap[1]

    def heapify_up(self, i):
        #till element is not root
        while i // 2 > 0:
            #if curr element is smaller than it's parent swap the two
            if self.heap[i] < self.heap[i//2]:
                self.heap[i], self.heap[i//2] = self.heap[i//2], self.heap[i]
            i = i // 2

    def heapify_down(self, i):
        #while element has one child atleast
        while (i * 2) <= self.size:
            #only one child or right child is smaller then left child
            if (i*2) > self.size or self.heap[(i*2)] > self.heap[(i*2)+1]:
                smallerChild = (i*2)+1
            else:
                smallerChild = (i*2)
            #swap smaller child with parent
            self.heap[i], self.heap[smallerChild] = self.heap[smallerChild], self.heap[i]
            i = smallerChild

    def extractMin(self):
        if self.size == 1:
            return

        min = self.heap[1]
        #shift last element to root element
        self.heap[1] = self.heap[self.size]
        #remove last element
        self.heap.pop()
        self.size -= 1

        #get root element into correct position
        self.heapify_down(1)

        return min

    def insert(self, element):
        self.size += 1
        self.heap.append(element)

        #get element into right place
        self.heapify_up(self.size)
