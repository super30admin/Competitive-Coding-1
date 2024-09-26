class Node:
  def __init__(self, data):
    self.data = data 
    self.next = None

class PriorityQueueUsingLinkedLists:
  def __init__(self):
    self.head = Node(None)

  def push(self, value):
    if self.head.data is None:
      self.head = Node(value)
      return
    else:
      prev = None
      curr = self.head
      # print("curr.data",curr.data)
      while curr and curr.data > value:
          prev = curr
          curr = curr.next 
      new_node = Node(value)
      if prev == None: # if the new node is greater than all nodes 
        new_node.next = self.head
        self.head = new_node
      else:
        temp = prev.next
        prev.next = new_node 
        new_node.next = temp

  def pop(self):
    if not self.head:
      return 
    curr_head = self.head
    temp = self.head.next 
    self.head.next = None
    self.head = temp
    return curr_head.data

  def isEmpty(self):
    pass

  def printLL(self):
    print("Printing the contents of the PQ")
    if self.head:
      curr = self.head
      while curr:
        print(curr.data)
        curr = curr.next

pq = PriorityQueueUsingLinkedLists()
pq.push(3)
pq.push(2)
pq.push(1)
pq.push(1)
pq.push(2)
pq.push(3)
pq.push(7)
pq.push(5)
pq.push(6)
pq.push(7)
print("Before popping")
pq.printLL()
pq.pop()
pq.pop()
print("After popping")
pq.printLL()
# pq.isEmpty()
