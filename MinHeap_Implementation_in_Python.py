# Created by Aashish Adhikari at 11:30 AM 12/31/2020

'''
Python implementation of Min Heap data structure

Time Complexity:
heapify() : O(logn) since the depth of a binary tree is logn.
insert() : O(logn) since we start from the leaf level and reach the node.
getMin() : O(1) since a single lookup
extractMin() : O(logn) since we perform heapify() on the root node once.

Space Complexity:
All methods take O(1).

'''


import sys

class MinHeap:
    # Heaps are typically implemented with array-like data structures since the positions of children nodes can be
    # uniquely mapped onto array indices using the index of the parent.

    def __init__(self, maxsize):
        self.maxsize = maxsize
        self.size = 0

        self.heap = [sys.maxsize]* (self.maxsize + 1) # doing maxsize + 1 because while inserting, we want to start from the bottom
                                            # of the heap tree and thus add the imbalanced element at a positi

    def heapify(self, node_to_heapify):

        # Replace the root node with MAX
        self.heap[0] = sys.maxsize

        # Heapify needs to be done from the root node to half the total nodes because of the property of a binary tree
        last_node_index_to_heapify = (self.size // 2) - 1 # minus 1 since the index starts from 0.




        # Heapify until the root node, root corresponds to index 0 of the array
        while node_to_heapify <= last_node_index_to_heapify:
            left_child_idx = (2 * node_to_heapify) + 1
            right_child_idx = left_child_idx + 1

            if self.heap[node_to_heapify] <= self.heap[left_child_idx] and self.heap[node_to_heapify] <= self.heap[right_child_idx]:
                break
            elif self.heap[node_to_heapify] <= self.heap[left_child_idx] and self.heap[node_to_heapify] > self.heap[right_child_idx]:
                # swap the parent with the right child
                self.heap[node_to_heapify], self.heap[right_child_idx] = self.heap[right_child_idx], self.heap[node_to_heapify]
                # update the node to heapify
                node_to_heapify = right_child_idx


            else:
                # swap the parent with the left child
                self.heap[node_to_heapify], self.heap[left_child_idx] = self.heap[left_child_idx], self.heap[node_to_heapify]
                # update the node to heapify
                node_to_heapify = left_child_idx




    def insert(self, element):
        '''Inserts an element to the minheap. TC :  O(log N)'''

        if self.size == self.maxsize:
            exit()

        # put the element at the end of the heap (not at the end of the array that simulates the heap)
        self.heap[self.size] = element

        self.size += 1

        # heapify the parent of this node
        current_node_index = self.size - 1
        parent_index  = ( current_node_index - 1 )//2

        curr = self.size-1

        while self.heap[parent_index] > self.heap[curr] and parent_index >= 0:
            self.heap[parent_index], self.heap[curr] = self.heap[curr], self.heap[parent_index]
            curr = parent_index
            parent_index = (parent_index - 1)//2






    def getMin(self):
        '''Returns the minimum element of Min Heap without removing from the minheap. TC :  O(1)'''
        return self.heap[0]





    def extractMin(self):
        '''Returns the minimum element of the min heap by removing from the minheap. TC :  O(log N)'''

        # Copy the minimum element to a temporary variable
        temp = self.heap[0]
        # Replace the root with MAX value and then heapify until the leaf level is reached
        self.heapify(0)

        return temp





    # Driver Code
if __name__ == "__main__":

    print('The minHeap is ')
    minHeap = MinHeap(20)
    minHeap.insert(5)
    minHeap.insert(3)
    minHeap.insert(17)
    minHeap.insert(10)
    minHeap.insert(84)
    minHeap.insert(19)
    minHeap.insert(6)
    minHeap.insert(22)
    minHeap.insert(9)

    print(minHeap.heap)
    print("The Min val is " + str(minHeap.extractMin()))
