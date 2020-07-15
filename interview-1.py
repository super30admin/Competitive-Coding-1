# problem 1 : Given a list of n-1 integers and these integers are in the range of 1 to n. 
# There are no duplicates in list. One of the integers is missing in the list.
# https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
# Time Complexity : O(log n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach
def search(nums):
	start, end = 0, len(nums) - 1
	while start < end :
		mid = start + (end - start) // 2
		if nums[mid] == mid + 1:
			start = mid + 1
		else:
			end = mid
	return start + 1

nums = [1, 2, 3, 4, 5, 6, 8] 

print("Missing number:", search(nums)) 

# problem 1 : Min Heap in Java
# https://www.geeksforgeeks.org/min-heap-in-java/
# Time Complexity : getMin() : O(1), extractMin() and insert(): O(log n) 
# Space Complexity : O(1) if not considering the space required to store the heap
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach

class minHeap:
	def __init__(self, maxsize):
		self.maxsize = maxsize
		self.size = 0
		self.heap = [0] * (self.maxsize + 1)
		self.heap[0] = -1
		self.front = 1

	# to get parent index
	def parent(self, pos):
		return pos // 2

	# to get left child
	def leftChild(self,pos):
		return pos * 2

	# to get right child
	def rightChild(self,pos):
		return (pos * 2) + 1

	# check node is leaf
	def isLeaf(self, pos):
		if pos >= (self.size // 2) and pos <= self.size:
			return True
		return False

	# for swapping
	def swap(self, pos1, pos2):
		self.heap[pos1], self.heap[pos2] = self.heap[pos2], self.heap[pos1]

	# heapify function
	def heapify(self, pos):
		if not self.isLeaf(pos):
			left = self.leftChild(pos)
			right = self.rightChild(pos)
			if self.heap[left] < self.heap[pos] or self.heap[right] < self.heap[pos]:
				if self.heap[left] < self.heap[right]:
					self.swap(left, pos)
					self.heapify(left)
				else:
					self.swap(right, pos)
					self.heapify(right)

	# insert function:
	def insert(self,num):
		if self.size >= self.maxsize:
			print("maximum heap size reached. Cannot add")
			return
		self.size += 1
		self.heap[self.size] = num 
		current = self.size
		while self.heap[current] < self.heap[self.parent(current)]:
			self.swap(current, self.parent(current))
			current = self.parent(current)

	# to print heap
	def printHeap(self): 
		for i in range(1, (self.size//2)+1): 
			print(" PARENT : "+ str(self.heap[i])+" LEFT CHILD : "+
								str(self.heap[2 * i])+" RIGHT CHILD : "+
								str(self.heap[2 * i + 1])) 


	# to build min heap from given list
	def minHeap(self): 
		for pos in range(self.size//2, 0, -1): 
			self.heapify(pos) 

	# to remove top element:
	def remove(self):
		popped = self.heap[self.front]
		self.heap[self.front] = self.heap[self.size]
		self.size -= 1
		self.heapify(self.front)
		return popped 




if __name__ == "__main__": 
	
	print('The minHeap is ') 
	minHeap = minHeap(15) 
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

	minHeap.printHeap() 
	print("The Min val is " + str(minHeap.remove())) 
