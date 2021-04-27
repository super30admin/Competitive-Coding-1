class Heap:

	def __init__(self):

		self.array = []

	def getParentIndex(self,childIndex):
		return (childIndex - 1) //2

	def insert(self,value):

		self.array.append(value)
		self.siftUp()

	def siftUp(self):
		parentIndex = self.getParentIndex(len(self.array)-1)
		childIndex = len(self.array)-1
		while parentIndex >= 0 and self.array[childIndex] < self.array[parentIndex]:
			self.array[childIndex],  self.array[parentIndex] = self.array[parentIndex], self.array[childIndex]
			childIndex = parentIndex
			parentIndex = self.getParentIndex(childIndex)


	def remove(self):

		#Removing the first element
		self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]  
		valueRemoved = self.heap.pop()
		self.siftDown()
		return valueRemoved
		
	def siftDown(self):
		lastIndex = len(self.array) -1
		self.array[indexToBeDeleted],  self.array[lastIndex] = self.array[lastIndex], self.array[indexToBeDeleted]
		self.array.pop(-1)

		parentIndex = 0
		childOneIndex = 2 * parentIndex + 1

		while parentIndex <= len(self.array)-1:#Not greather than length of array
			childOneIndex = 2 * parentIndex + 1

			childOneIndex = 2 * parentIndex + 2

			if self.array[childTwoIndex]  == float("inf") or  self.array[childOneIndex] < self.array[childTwoIndex]:
				indexToBeSwapped = childOneIndex
			else:
				indexToBeSwapped = childTwoIndex

			if self.array[indexToBeSwapped] < self.array[parentIndex]:
	
				self.array[indexToBeSwapped],  self.array[parentIndex] = self.array[parentIndex], self.array[indexToBeSwapped]
				parentIndex = indexToBeSwapped
			else:
				break
	def getArray(self):
		return self.array

	def getMin(self):
		return self.array[0]

nums = Heap()
nums.insert(8)
nums.insert(7)
print(nums.getMin())
print(nums.getArray())
nums.insert(6)
nums.insert(5)
nums.insert(4)
nums.insert(3)
print(nums.getMin())
print(nums.getArray())
nums.insert(2)
print(nums.getMin())
print(nums.getArray())
nums.insert(1)
print(nums.getMin())
print(nums.getArray())