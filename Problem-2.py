# Python3 implementation of Min Heap

import sys

class MinHeap:

	def __init__(self, maxsize):
		self.maxsize = maxsize
		self.size = 0
		self.Heap = [0]*(self.maxsize + 1)
		self.Heap[0] = -1 * sys.maxsize
		self.FRONT = 1

	# Function to return the position of
	# parent
	def parent(self, pos):
		return pos//2

	# Function to return the position of
	# the left child
	def leftChild(self, pos):
		return 2 * pos

	# Function to return the position of
	# the right child
	def rightChild(self, pos):
		return (2 * pos) + 1

	# Function that returns true if the passed
	# node is a leaf node
	def isLeaf(self, pos):
		if pos >= (self.size//2) and pos <= self.size:
			return True
		return False

	def swap(self, fpos, spos):
		self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos]


	def minHeapify(self, pos):

		if not self.isLeaf(pos):
			if (self.Heap[pos] > self.Heap[self.leftChild(pos)] or
			self.Heap[pos] > self.Heap[self.rightChild(pos)]):


				if self.Heap[self.leftChild(pos)] < self.Heap[self.rightChild(pos)]:
					self.swap(pos, self.leftChild(pos))
					self.minHeapify(self.leftChild(pos))

				# Swap with the right child and heapify
				# the right child
				else:
					self.swap(pos, self.rightChild(pos))
					self.minHeapify(self.rightChild(pos))

	# Function to insert a node into the heap
	def insert(self, element):
		if self.size >= self.maxsize :
			return
		self.size+= 1
		self.Heap[self.size] = element

		current = self.size

		while self.Heap[current] < self.Heap[self.parent(current)]:
			self.swap(current, self.parent(current))
			current = self.parent(current)

	
	# Function to build the min heap using
	# the minHeapify function
	def minHeap(self):

		for pos in range(self.size//2, 0, -1):
			self.minHeapify(pos)

	def remove(self):

		popped = self.Heap[self.FRONT]
		self.Heap[self.FRONT] = self.Heap[self.size]
		self.size-= 1
		self.minHeapify(self.FRONT)
		return popped
