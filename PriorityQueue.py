class MinHeap:
  class Node:
    def __init__(self, val):
      self.val = val
      self.next = None

  def __init__(self):
    self.head = None

    
  def put(self, val):
    newNode = self.Node(val)
    if self.head == None:
      self.head = newNode
      return

    curr = self.head
    prev = None
    while curr != None and curr.val <= val:
      prev = curr
      curr = curr.next

    newNode.next = curr

    if prev == None:
      self.head = newNode
    else:
      prev.next = newNode
      
    

  def pop(self):
    if self.head == None:
      return -1
    
    hold =  self.head.val
    self.head = self.head.next

    return hold

  
  def readMin(self):
    if self.head == None:
      return -1
    else:
      return self.head.val
  
  def printHeap(self):
    l = []
    curr = self.head
    while curr != None:
      l.append(curr.val)
      curr = curr.next
    
    print(l)





''' Testing Code'''
heap = MinHeap()
print(heap.readMin())
for i in range(5, -1, -1):
  heap.put(i)

heap.printHeap()
print("Pop: ", heap.pop())
print("ReadMin: ", heap.readMin())
print("Pop: ", heap.pop())
print("Pop: ", heap.pop())
print("ReadMin: ", heap.readMin())
print("Pop: ", heap.pop())
