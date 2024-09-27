"""
A Min-Heap is a complete binary tree in which the value in each internal node is smaller than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored an index k,
then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Time complexity: O(1) for all operations, except for remove, insert and display it will take O(logn), n is the height of the tree
Space Complexity: O(n)
"""
# creating a class name MinHeap
class MinHeap:
    # creating Heap obj
    def __init__(self, capacity):
        self.capacity = capacity
        self._size = 0
        self.heap = [0 for i in range(self.capacity + 1)]
        self.root = 1
     
    def parents(self, index):
        """
        returns the parent of the current node at place index
        """
        return self.heap[(index)//2]
    
    def left_child(self, index):
        """
        returns the left child of the index
        """
        return self.heap[(2*index)]
    
    def right_child(self, index):
        """
        returns the right child of the index
        """
        return self.heap[(2*index) + 1]
    
    def is_leaf_node(self, index):
        """
        returns true if the node is the leaf node
        """
        return (index >= self._size//2 and index <= self._size)
        
        
    def swap_nodes(self, node1, node2):
        """
        swap the position of the two nodes
        """
        self.heap[node1], self.heap[node2] = self.heap[node2], self.heap[node1]

    def min_heapify(self, index):
        """
        heapifies the given index position, by checking the parent, if the parent is greater, it will swap
        """
        # if the node is not a leaf node and its children are smaller than the parent node
        if not self.is_leaf_node(index):
            if self.heap[index] > self.left_child(index) or self.heap[index] > self.right_child(index):
                # if left child is smaller than right, heapify the left side
                if self.left_child(index) < self.left_child(index):
                    self.swap_nodes(index, (2*index))
                    self.min_heapify(2*index)
                # if the right child is smaller    
                else:
                    self.swap_nodes(index, (2*index)+1)
                    self.min_heapify((2*index)+1)
                    
                    
    def insert(self, elem):
        """
        Function to insert an element at the right place in the heap tree
        """
        if self._size >= self.capacity:
            return 
        
        self._size += 1
        print("size: ", self._size)
        self.heap[self._size] = elem
        curr = self._size
        
        # check the right place for the new elem
        while self.heap[curr] < self.parents(curr):
            print("self.heap[curr]:", self.heap[curr])
            print("self.parents(curr):", self.parents(curr))
       
            self.swap_nodes(curr, (curr)//2)
            curr = (curr)//2
            
            
    def display(self):
        """
        Print the elements in the heap
        """
        for i in range(1, (self._size//2)+1):
            print(" PARENT : "+ str(self.heap[i])+" LEFT CHILD : "+ 
                                str(self.heap[(2 * i)])+" RIGHT CHILD : "+
                                str(self.heap[(2 * i) + 1]))
            
    def remove(self):
        """
        Function to remove the min elements in the heap
        """
        rem = self.heap[self.root]
        self.heap[self.root] = self.heap[self._size]
        self._size -= 1
        self.min_heapify(self.root)
        return rem
    
    
   
    def minHeap(self):
        """
        function to build the min heap using min_heap function
        """
        for i in range(self._size//2, 0, -1):
            self.min_heapify(i)
  
    