import heapq

class MinHeap:
    def __init__(self, arr=None):
        "Initialize heap with an optional list."
        self.heap = arr if arr else []
        heapq.heapify(self.heap)  

    def push(self, val):
        "Insert an element into the heap"
        heapq.heappush(self.heap, val)

    def pop(self):
        "Remove and return the smallest element"
        return heapq.heappop(self.heap) if self.heap else None

    def peek(self):
        "Return the smallest element without removing it"
        return self.heap[0] if self.heap else None


