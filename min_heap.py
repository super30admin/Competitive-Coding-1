# heapq design using heapq
# internally heapq datastructure implementes complete binary tree.
# what if we use heapq if they ask us to implement min-heap and show to the interviewer?

import heapq
import sys

class MinHeap:
    def __init__(self):
        self.arr = []

    def parent(self, i):
        return int((i-1)/2)
    
    def insert(self, key):
        heapq.heappush(self.arr, key)

    def decrease_to_minimum(self, key):
        self.arr[key] = -sys.maxsize-1

        while (key != 0 and self.arr[self.parent(key)] > self.arr[key]):
            self.arr[key], self.arr[self.parent(key)] = self.arr[self.parent(key)], self.arr[key]

    def delete(self, key):
        self.decrease_to_minimum(key)
        self.extract_out()

    def extract_out(self):
        heapq.heappop(self.arr)

    def min_heap(self):
        return self.arr[0]

    def print(self):
        print(self.arr)

if __name__ == "__main__":
    mh = MinHeap()
    mh.insert(7)
    mh.insert(11)
    mh.insert(9)
    mh.print()
    mh.delete(1)
    mh.insert(3)
    mh.print()