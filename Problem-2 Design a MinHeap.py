# // Time Complexity : O(log n)
# // Space Complexity : O(log n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach


class Node():
    def __init__(self, data, right=None, left=None):
        self.data = data
        self.right = None
        self.left = None

class MinHeap():

    def __init__(self, data):
        self.insert(data)
        print(data)

    def insert(self, data):
        print('hi')        
        

H = MinHeap([1,2,3,4,5,6])