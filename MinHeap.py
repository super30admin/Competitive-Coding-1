# Implement Minheap (https://www.geeksforgeeks.org/min-heap-in-java/)
# Time complexity: Insert=O(logn); Remove=O(logn); n = length of the array
# Space complexity: O(1)
# Approach: Complete Binary Tree 

class MinHeap:

	def __init__(self, maxsize):
		self.maxsize = maxsize
		self.size = 0
		self.Heap = maxsize * [0]
		self.Heap[0] = float('-inf')


	# Returns parent of the current node
	def parent(self, pos):
		return pos // 2

	# Return left child of the current node
	def leftChild(self, pos):
		return (2 * pos)

	# Return right child of the current node
	def rightChild(self, pos):
		return (2 * pos) + 1

	# Checks if current node is a leaf node
	def isLeaf(self, pos):
		if (pos >= (self.size // 2) and  pos <= self.size):
			return True
		
		return False

	# Swap nodes on given positions
	def swap(self,pos1, pos2):
		self.Heap[pos1], self.Heap[pos2] = self.Heap[pos2], self.Heap[pos1]

	# Heapify the array
	def heapify(self, pos):

		# Node must be a non-leaf node and greater than its child nodes
		if not self.isLeaf(pos):
			if ( (self.Heap[pos] > self.Heap[self.leftChild(pos)] )
				or (self.Heap[pos] > self.Heap[self.rightChild(pos)]) ):

				# If left child is greater than right child 
				if self.Heap[self.leftChild(pos)] < self.Heap[self.rightChild(pos)]:
					self.swap(pos,self.leftChild(pos))
					self.heapify(self.leftChild(pos))

				# If right child is greater than left child
				else:
					self.swap(pos, self.rightChild(pos))
					self.heapify(self.rightChild(pos))

	# Insert node into heap
	def insert(self, item):
		if (self.size >= self.maxsize):
			return 

		self.size += 1
		self.Heap[self.size] = item
		curr = self.size

		# Maintain min heap propery afte insertion
		while self.Heap[curr] < self.Heap[self.parent(curr)]:
			self.swap(curr, self.parent(curr))
			curr = self.parent(curr)

	# Create a min heap
	def minHeap(self):
		for pos in range((self.size // 2), 1):
			self.heapify(pos)

	# Remove node from heap
	def remove(self):
		popped = self.Heap[1]
		self.Heap[1] = self.Heap[self.size]
		self.size -= 1
		self.heapify(1)
		return popped

	def print(self): 
	    for i in range(1, (self.size // 2)+1): 
	        print(" PARENT : " + str(self.Heap[i])
	        		+ " LEFT CHILD : " + str(self.Heap[2 * i]) 
	        		+ " RIGHT CHILD :" + str(self.Heap[2 * i + 1])) 
	        print()

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

	minHeap.print()
	print(minHeap.remove())


				 



