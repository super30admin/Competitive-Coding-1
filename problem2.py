import sys 

class MinHeap: 

	def __init__(self, maxsize): 
		self.maxsize = maxsize # maxsize the heap could accummulate
		self.size = 0
		self.Heap = [0]*(self.maxsize + 1) 
		self.Heap[0] = -1 * sys.maxsize # since we are using 1-based indexing
		self.FRONT = 1 # front of the heap where the min will be stored

	def parent(self, pos): # rturn position of parent node
		return pos//2

	def leftChild(self, pos): #return position of leftchild
		return 2 * pos 

	def rightChild(self, pos): # return pposition of rightchild
		return (2 * pos) + 1

	def isLeaf(self, pos): # to check if the node is leaf node or not
		return pos*2 > self.size 


	def swap(self, fpos, spos): # swap two nodes
		self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos] 

	# Function to heapify the node at pos 
	def minHeapify(self, pos): 

		if not self.isLeaf(pos): # to check if the node is leaf or not if it is not then
			if (self.Heap[pos] > self.Heap[self.leftChild(pos)] or # to check if its > left and right child
			self.Heap[pos] > self.Heap[self.rightChild(pos)]): 


				if self.Heap[self.leftChild(pos)] < self.Heap[self.rightChild(pos)]: 
					self.swap(pos, self.leftChild(pos)) # swap with left and heapify it
					self.minHeapify(self.leftChild(pos)) 

				else: # else wirh right child
					self.swap(pos, self.rightChild(pos)) 
					self.minHeapify(self.rightChild(pos)) 


	# Function to insert a node into the heap 
	def insert(self, element): 
		if self.size >= self.maxsize :  # to check if the heap is already full 
			return # if yes then return it
		self.size+= 1 #otherwise incerase the size of the loop and 
		self.Heap[self.size] = element  #insert the number

		current = self.size 

		while self.Heap[current] < self.Heap[self.parent(current)]: # if the inserted no is < parent
			self.swap(current, self.parent(current)) # swap it
			current = self.parent(current) # this process continues until the new number >= its parent's value

	# Function to print the contents of the heap 
	def Print(self): 
		print(self.Heap) # first value will be the least possible value and the min value will be at
                         # the root and the empty spaces will be 0's 

	def minHeap(self): # this func is used to build and maintain the minheap 

		for pos in range(self.size//2, 0, -1): 
			self.minHeapify(pos) 


	def remove(self): 

		popped = self.Heap[self.FRONT] # pop the front element in the heap to return and remove min
		self.Heap[self.FRONT] = self.Heap[self.size] #last num goes to the front temporarily
		self.size-= 1 #reduce the size of the heap
		self.minHeapify(self.FRONT) #now heapify the new temp root to its correct pos by calling mu=inHeapify
		return popped #return the min num

# Driver Code 
if __name__ == "__main__": 
	print('The minHeap is ') 
	minHeap = MinHeap(12) 
	minHeap.insert(4) 
	minHeap.insert(2) 
	minHeap.insert(16) 
	minHeap.insert(9) 
	minHeap.insert(53) 
	minHeap.insert(18) 
	minHeap.insert(5) 
	minHeap.insert(20) 
	minHeap.insert(8) 
	minHeap.minHeap() 

	minHeap.Print() 
	print("The Min val is " + str(minHeap.remove())) 
