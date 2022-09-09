
#using Library functions : 

# from heapq import heapify, heappush, heappop

# heap = []
# heapify(heap)

# # Adding items using heappush
# heappush(heap, 1)
# heappush(heap, 5)
# heappush(heap, 10)
# heappush(heap, 20)

# # value of minimum element
# print("Head value of heap(Min Eleement) : "+str(heap[0]))

# # elements of the heap
# print("The heap elements : ")
# for i in heap:
# 	print(i, end = ' ')
# print("\n")

# element = heappop(heap)

# # printing the elements of the heap
# print("The heap elements : ")
# for i in heap:
# 	print(i, end = ' ')
# print("\n")




#Min heap
import sys


class MinHeap:
	def __init__(self,capacity):
		self.capacity = capacity
		self.size = 0
		self.Heap = [0] * (self.capacity+1)
		self.Heap[0] = -1 * sys.maxsize
		self.FRONT = 1
		

	def parent(self,index):
		return index//2

	def leftChild(self,index):
		return 2* index
	
	def rightChild(self,index):
		return (2 * index)+1
	
	def isLeaf(self,index):
		return index * 2 > self.size

	def swap(self,index1,index2):
		self.Heap[index1], self.Heap[index2] = self.Heap[index2], self.Heap[index1]


	def minHeapify(self,index):
		if not self.isLeaf(index):
			if (self.Heap[index] > self.Heap[self.leftChild(index)] or 
               self.Heap[index] > self.Heap[self.rightChild(index)]):
  
                # Swap with the left child and heapify the left child
				if self.Heap[self.leftChild(index)] < self.Heap[self.rightChild(index)]:
					self.swap(index, self.leftChild(index))
					self.minHeapify(self.leftChild(index))
  
                # Swap with the right child and heapify the right child
				else:
					self.swap(index, self.rightChild(index))
					self.minHeapify(self.rightChild(index)) 

	def insert(self,data):
		if self.size >= self.capacity:
			return
		self.size += 1
		self.Heap[self.size] = data

		current = self.size

		while self.Heap[current] < self.Heap[self.parent(current)]:
			self.swap(current, self.parent(current))
			current = self.parent(current)

	def remove(self):
		popped = self.Heap[self.FRONT]
		self.Heap[self.FRONT] = self.Heap[self.size]
		self.size -= 1
		self.minHeapify(self.FRONT)
		return popped

	def minHeap(self):
		for index in range(self.size//2,0,-1):
			self.minHeapify(index)


	
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
	minHeap.insert(1)
	minHeap.minHeap()
  
	print("The Min val is " + str(minHeap.remove()))