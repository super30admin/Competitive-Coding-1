# Design minheap, using array

'''
Heap shall have 3 operations:
    1. Extract root (min for minheap, max for maxheap)
    2. extractMin: remove the min/max element from minheap/maxheap
    3. insert: insert a new element
'''

class minheap:
    
    def __init__(self, 
