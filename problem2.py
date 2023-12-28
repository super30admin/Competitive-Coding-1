#time complexity = O(logN) where N is number of nodes in the heap
#Space complexity: O(N) where N is the max size of the heap



class MinHeap:

    def __init__(self,maxsize):
        self.maxsize = maxsize 
        self.size = 0
        self.Heap = [0]*(self.maxsize + 1)
        self.FRONT = 1
        

    def parent_node(self,pos):
        return pos//2

    def leftchild_node(self,pos):
        return 2 * pos
    
    def rightchild_node(self,pos):
        return 2 * pos + 1
    
    def isLeafNode(self,pos):
        return pos*2 > self.size
    
    def heapify(self, pos):
        if not self.isLeafNode(pos):
            if self.Heap[pos] > self.Heap[self.leftchild_node(pos)]or self.Heap[pos] > self.Heap[self.rightchild_node(pos)]:
                if  self.Heap[self.leftchild_node(pos)] < self.Heap[self.rightchild_node(pos)]:
                    self.Heap[pos], self.Heap[self.leftchild_node(pos)] = (
                        self.Heap[self.leftchild_node(pos)],
                        self.Heap[pos],
                    )
                    self.heapify(self.leftchild_node(pos))
                else:
                    self.Heap[pos], self.Heap[self.rightchild_node(pos)] = (
                        self.Heap[self.rightchild_node(pos)],
                        self.Heap[pos],
                    )
                    self.heapify(self.rightchild_node(pos))
    
    def add_Node(self,node):

        if self.size >= self.maxsize:
            return
        
        self.size +=1
        self.Heap[self.size] = node
        current_node = self.size

        while self.Heap[current_node] < self.Heap[self.parent_node(current_node)]:
            self.Heap[current_node], self.Heap[self.parent_node(current_node)] = self.Heap[self.parent_node(current_node)], self.Heap[current_node]
            current_node = self.parent_node(current_node)

    def Print(self):
        for i in range (1,(self.size)//2+1):
            print(
                "Parent Node "
                + str(self.Heap[i])
                + " Left Child Node "
                + str(self.Heap[2 * i])
                + " Right Child Node "
                + str(self.Heap[2 * i + 1])
            )

    def minHeap(self):
        for pos in range(self.size//2, 0, -1):
            self.heapify(pos)

    def remove(self): 
 
        pop_value = self.Heap[self.FRONT] 
        self.Heap[self.FRONT] = self.Heap[self.size] 
        self.size-= 1
        self.heapify(self.FRONT) 
        return pop_value

if __name__ == "__main__": 
    minHeap = MinHeap(15) 
    minHeap.add_Node(5) 
    minHeap.add_Node(10) 
    minHeap.add_Node(15) 
    minHeap.add_Node(20) 
    minHeap.add_Node(30) 
    minHeap.add_Node(40) 
    minHeap.add_Node(6) 
    minHeap.minHeap() 
  
    minHeap.Print() 
    print("The Min val is " + str(minHeap.remove())) 









