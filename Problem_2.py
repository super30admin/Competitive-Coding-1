class minheap():
	def __init__(self):
		self.heap = []
	
	def parent(self, index):
		return (index-1)//2
	
	def lchild(self, index):
		return (2*index)+1
		
	def rchild(self, index):
		return (2*index)+2
	
	def swap(self, index1, index2):
		self.heap[index1], self.heap[index2] = self.heap[index2], self.heap[index1]
		
	def minheapify(self, trigger, index):
		if trigger == 1:
			parent = self.parent(index)
			while parent>=0 and self.heap[parent]>= self.heap[index]:
				self.swap(parent, index)
				index = parent
				parent = self.parent(index)
		else:
			size = len(self.heap)-1
			lchild = self.lchild(index)
			rchild = self.rchild(index)
			while lchild<size:
				if rchild<size:
					if self.heap[lchild]<self.heap[rchild]:
						if self.heap[lchild]<self.heap[index]:
							self.swap(lchild, index)
							index = lchild
					else:
						if self.heap[rchild]<self.heap[index]:
							self.swap(rchild, index)
							index = rchild
				else:
					self.swap(lchild, index)
					index = lchild
				lchild = self.lchild(index)
				rchild = self.rchild(index)
	
	def insert(self, x):
		self.heap.append(x)
		self.minheapify(1, len(self.heap)-1)
		
	def display(self):
		print(self.heap)
		
	def extractMin(self):
		if len(self.heap)>0:
			x = self.heap[0]
			self.swap(0, len(self.heap)-1)
			self.heap.pop()
			self.minheapify(2, 0)
			return x
		else:
			return 'Heap empty'
		
	def getMin(self):
		try:
			return self.heap[0]
		except:
			return "Empty heap"


minh = minheap()
import random
for x in range(random.randint(7,20)):
	minh.insert(random.randint(1,100))

print('display')
minh.display()
print("getMin",minh.getMin())
print("extractMin",minh.extractMin())
print('display')
minh.display()

'''time complexity - inserting - O(n)
				   - display - O(1)
				   - getMin - O(1)
				   - extractmin - delete - O(logn)'''

#space complexity - O(1)