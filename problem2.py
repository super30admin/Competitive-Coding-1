# Time Complexity : 
#push : O(n), pop : O(1)
# Space Complexity : 0(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

class Pnode:
     
  def __init__(self, value, p):
       
    self.data = value
    self.priority = p
    self.next = None

class PriorityQueue:
    def __init__(self):
         
        self.head = None
    def push(self, value, priority):
        if self.isEmpty() == True:
            self.head = Pnode(value,priority)
        else:
            if self.head.priority > priority:    
                newNode = Pnode(value,priority) 
                newNode.next = self.head
                self.head = newNode   
            else:
                temp = self.head
                while temp.next:                   
                    if priority <= temp.next.priority:
                        break
                     
                    temp = temp.next
                 
                newNode = Pnode(value,priority)
                newNode.next = temp.next
                temp.next = newNode  
    def pop(self): 
        if self.isEmpty() == True:
            return None
        else: 
            temp = self.head
            self.head = self.head.next
            return temp.priority              