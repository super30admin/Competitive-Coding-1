//MinHeap Problem
//time complexity to get minimum=O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinHeap:
	def __init__(self,maxsize):
		self.maxsize=maxsize
		self.size=0
		self.front=1
		self.heap=[0]*(self.maxsize+1)

	def parent(self,pos):
		return pos//2

	def leftChild(self,pos):
		return pos*2

	def rightChild(self,pos):
		return (pos*2+1)

	def isleaf(self,pos):
		if pos>=(self.size//2) and (pos<=self.size):
			return True
		else:
			return False

	def swap(self,pos1,pos2):
		self.heap[pos1],self.heap[pos2]=self.heap[pos2],self.heap[pos1]

	def minHeapify(self,pos):               
		if not self.isleaf(pos):
			if self.heap[pos]> self.heap[self.leftChild(pos)] or self.heap[pos]> self.heap[self.rightChild(pos)]:
				if self.heap[self.leftChild(pos)]<self.heap[self.rightChild(pos)]:
					self.swap(pos,self.leftChild(pos))
					self.minHeapify(self.leftChild(pos))
				else:
					self.swap(pos,self.rightChild(pos))
					self.minHeapify(self.rightChild(pos))

	def insert(self,element):           // Time Complexity : O(log n)
		if self.size>=self.maxsize:
			return
		self.size+=1
		self.heap[self.size]=element
		curr=self.size
		while self.heap[curr]<self.heap[self.parent(curr)]:
			self.swap(curr, self.parent(curr))
			curr=self.parent(curr)

	def Print(self):
		for i in range(1,(self.size//2)+1):
			print(" parent:"+str(self.heap[i])+
				  "   leftChild:"+str(self.heap[2*i])+
				  "   rightChild:"+str(self.heap[(2*i)+1]))

	def minHeap(self):                      
		for pos in range(self.size//2,0,-1):
			self.minHeapify(pos)

	def remove(self):                   // Time Complexity : O(log n)
		popped= self.heap[self.front]
		self.heap[self.front]=self.heap[self.size]
		self.size-=1
		self.minHeapify(self.front)
		return popped

if __name__ == "__main__":
     
    print('The minHeap is ')
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


