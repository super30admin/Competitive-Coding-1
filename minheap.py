
# Time Complexity : Insert - O(n), extractMin() - O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -
'''
I have implemented 3 utility functions to fetch left, right, and parent index of a give index. 
The function min_heapify converts a given node into heap, by swapping with the minimum children.
ExtractMin, pop out the first value on the array/list which implicitly denotes the heap

'''

class MinHeap():

    def __init__(self):

        self.list = []

    def get_left(self, A, i):

        left = (2*i)+1
        if left < len(A):
            return left

    def get_right(self, A, i):

        right = (2*i)+2
        if right < len(A):
            return right 

    def get_parent(self, A, i):

        parent = int((i-1)//2)
        if parent >= 0 and parent < len(A):
            return parent

    def min_heapify(self, A, i):

        left = self.get_left(A,i)
        right = self.get_right(A, i)

        min_v = i
        if left is not None and A[left] < A[min_v]:
            min_v = left

        if right is not None and A[right] < A[min_v]:
            min_v = right

        if min_v != i:
            temp = A[min_v]
            A[min_v] = A[i]
            A[i] = temp

            self.min_heapify(A, min_v)

    def insert(self, x):

        self.list.append(x)

        n = len(self.list)
        for i in range(int(n//2)-1,-1,-1):
            self.min_heapify(self.list, i)


    def getMin(self):
        
        if len(self.list) >= 1:
            return self.list[0]

    def extractMin(self):
        
        if len(self.list) >= 1:
            size = len(self.list) - 1

            temp = self.list[0]
            self.list[0] = self.list[size]
            self.list[size] = temp

            min_element = self.list.pop()

            self.min_heapify(self.list, 0)

            return min_element





