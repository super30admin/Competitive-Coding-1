"""
getMin() is o(1) accessing element in root 

extractMin and remove is O(Log N ) because we need to heapify to maintain Heap property
"""


import sys 
  
class MinHeap:
	def __init__(self, maxsize): 
		self.maxsize = maxsize
		self.size = 0
		self.Heap = [0]*(self.maxsize + 1)
		self.Heap[0] = -1 * sys.maxsize 
		self.FRONT = 1


	def parent(self,pos):
		return (pos-1)//2

	def leftChild(self,pos):
		return 2*pos 
        
	def rightChild(self, pos): 
		return (2 * pos) + 1


	def isLeaf(self, pos): 
		if pos >= (self.size//2) and pos <= self.size: 
			return True
		return False

	def swap(self, fpos, spos):
		self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos] 

	def insert(self,element):
		if self.size>=self.maxsize:
			return
		self.size+=1
		self.Heap[self.size]=element
		current=self.size

		while self.Heap[current]<self.Heap[self.parent(current)]:
			self.swap(current, self.parent(current)) # swap the curr and its parent if parent node value is gt 
			current=self.parent(current) #set the currpos to parent's pos 
        
	def Print(self):
		for i in range(1, (self.size//2)+1):
			print(" PARENT : "+ str(self.Heap[i])+" LEFT CHILD : "+ 
                                str(self.Heap[2 * i])+" RIGHT CHILD : "+
                                str(self.Heap[2 * i + 1])) 
  

	def minHeapify(self, pos): 
        #For non-leaf node , check with its left child and right child
		if not self.isLeaf(pos): 
			if (self.Heap[pos] > self.Heap[self.leftChild(pos)] or self.Heap[pos] > self.Heap[self.rightChild(pos)]):
				if self.Heap[self.leftChild(pos)] < self.Heap[self.rightChild(pos)]: #if left is smthan right child 
					self.swap(pos, self.leftChild(pos)) #swap curr node with left and heapify 
					self.minHeapify(self.leftChild(pos))
				else: 
					self.swap(pos, self.rightChild(pos)) #Swap with the right child and heapify 
					self.minHeapify(self.rightChild(pos))

	def minHeap(self): 
		for pos in range(self.size//2, 0, -1): 
			self.minHeapify(pos) 
  
	def remove(self):
		popped = self.Heap[self.FRONT]
		self.Heap[self.FRONT] = self.Heap[self.size] #put last node to the root value and heapify
		self.size-= 1
		self.minHeapify(self.FRONT)
		return popped 

if __name__ == "__main__": 
      
    minHeap = MinHeap(15) 
    minHeap.insert(5) 
    minHeap.insert(3) 
    minHeap.insert(17) 
    minHeap.insert(10) 
    minHeap.insert(84) 
    minHeap.insert(19) 
    minHeap.insert(6) 
    minHeap.insert(22) 
    minHeap.insert(9) 
    minHeap.minHeap() 
  
    minHeap.Print() 
    print("The Min val is " + str(minHeap.remove())) 

