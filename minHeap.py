# Difficulties whle solving this  problem: Tough to visualize heap building and insert/remove the minimum element. Will get this doubt cleared.
# How to go onelayer up to swap if the new elemnt is smaller?
# How to delete the minimum element?  
class Node:
    def __init__(self,val):
        self.val = val
        self.left = None
        self.right = None
class minHeap:
    def __init__(self):
        self.hlist  = list()
    
    def insert(self,val):
        if self.val:
            if self.val < val and self.left is None:
                self.left = Node(val)
                self.hlist.append(self.left)
            elif self.val < val and self.right is None:
                self.right = Node(val)
                self.hlist.append(self.right)
            elif self.val > val and self.left is None:
                self.left = Node(val)
                self.hlist.append(self.left)
                self.val , self.left.val = self.left.val, self.val
            else:
                self.right = Node(val)
                self.hlist.append(self.right)
                self.val , self.right.val = self.right.val, self.val
    
    def getMin(self):
        #Return root as it will be smallest element
        return self.hlist[0]

root = Node(5)
m = minHeap()
m.insert(root)
m.insert(9)
m.insert(11)
m.insert(7)
mi = m.getMin()
        

                





