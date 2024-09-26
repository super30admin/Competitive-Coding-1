class PriorityQueue:
  class Node:
    def __init__(self, data):
      self.data = data
      self.next = None

  def __init__(self):
    self.head = None

    
  def put(self, data):
    #   create new node
    newNode = self.Node(data)
    # set up LL head
    if self.head == None:
      self.head = newNode
      return
    # perform a while loop until you get the current to the point that data is not greater than 
    # itself
    curr = self.head
    prev = None
    while curr != None and data >= curr.data:
      prev = curr
      curr = curr.next

    # assign the the newnode.next to current
    # if it's largest element then it'll be none otherwise it'll ve a value
    newNode.next = curr
    if prev == None:
      self.head = newNode
    else:
      prev.next = newNode
      
    

  def pop(self):
    if self.head == None:
      return -1
    popedValue =  self.head.data
    self.head = self.head.next

    return popedValue

  
  def readMin(self):
    if self.head == None:
      return -1
    else:
      return self.head.data
  
  def printHeap(self):
    ll = []
    curr = self.head
    while curr != None:
      ll.append(curr.data)
      curr = curr.next
    print(ll)