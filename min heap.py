'''
Every parent node can have at most 2 children
Must be a complete tree. It must be filled from left ot right and every level must be full, with the exception of the last level not needing to be full
Min Heap - Every parent's key must be smaller than it's children nodes
Max Heap - Every parent's key must be greater than it's children nodes

Time Complexity for get min element - O(1) as it returns the root node
Time Complexity for remove min element - O(logN) as it removes the min and replaces with the last element of array and executes the heapify_down function
Time Complexity for insert element - O(logN) as we add the new element at the end of the array, if it is less than it's parent , we need to traverse up to fix the violated heap property
'''


class MinHeap:
    def __init__(self, capacity):
        self.storage = [0] * capacity
        self.capacity = capacity
        self.size = 0

    def get_parent_ind(self, index):
        return (index - 1)//2

    def parent(self, index):
        return self.storage[self.get_parent_ind(index)]

    def get_left_child(self, index):
        return 2*index + 1

    def get_right_child(self, index):
        return 2*index + 2

    def has_parent(self, index):
        return self.get_parent_ind(index) >= 0

    def has_left_child(self, index):
        return self.get_left_child(index) < self.size

    def left_child(self, index):
        return self.storage[self.get_left_child(index)]

    def has_right_child(self, index):
        return self.get_right_child(index) < self.size

    def right_child(self, index):
        return self.storage[self.get_right_child(index)]

    def is_full(self):
        return self.capacity  == self.size

    def swap(self, ind1, ind2):
        self.storage[ind1], self.storage[ind2] = self.storage[ind2], self.storage[ind1]

    def insert(self, data):
        if self.is_full():
            raise("Heap is Full")
        self.storage[self.size] = data
        self.size += 1
        self.heapify_up()

    # def heapify_up(self):
    #     index = self.size - 1
    #     while self.has_parent(index) and self.parent(index) > self.storage[index]:
    #         self.swap(self.get_parent_ind(index), index)
    #         index = self.get_parent_ind(index)

    def heapify_up(self):
        index = self.size - 1
        if self.has_parent(index) and self.parent(index) > self.storage[index]:
            self.swap(self.get_parent_ind(index), index)
            self.heapify_up(self.get_parent_ind(index))

    # def remove_min(self):
    #     if self.size == 0:
    #         raise("Empty Heap")
    #
    #     data = self.storage[0]
    #     self.storage[0] = self.storage[self.size-1]
    #
    #     self.size -= 1
    #     self.heapify_down()
    #     return data
    #
    # def heapify_down(self):
    #     index = 0
    #     while self.has_left_child(index):
    #         small_child_index = self.get_left_child(index)
    #         if self.has_right_child(index) and self.right_child(index) < self.left_child(index):
    #             small_child_index = self.get_right_child(index)
    #         if self.storage[index] < self.storage[small_child_index]:
    #             break
    #         else:
    #             self.swap(index, small_child_index)
    #         index = small_child_index

    def remove_min(self):
        if self.size == 0:
            raise("Empty Heap")

        data = self.storage[0]
        self.storage[0] = self.storage[self.size-1]

        self.size -= 1
        self.heapify_down(0)
        return data

    def heapify_down(self, index):
        smallest = index
        if self.has_left_child(index) and self.storage[smallest] > self.left_child(index)
            smallest = self.get_left_child(index)
        if self.has_right_child(index) and self.storage[smallest] > self.right_child(index):
            smallest = self.get_right_child(index)
        if smallest != index:
            self.swap(smallest, index)
            self.heapify_down(smallest)

    def get_min(self):
        if self.size > 0:
            return self.storage[0]
        else:
            raise("Empty Heap")














