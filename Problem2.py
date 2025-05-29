#Designed and implemented a Min Heap data structure in Python using a dynamic list.
class MinHeap:
    def __init__(self):
        self.heap=[]
    def parent(self,i):
        return(i-1)//2
    def leftChild(self,i):
        return 2 *i+1
    def rightChild(self,i):
        return 2 * i+2
    def swap(self,i,j):
        self.heap[i],self.heap[j]=self.heap[j],self.heap[i]
    def insert(self,val):
        self.heap.append(val)
        index=len(self.heap)-1

        while index>0 and self.heap[index]<self.heap[self.parent(index)]:
            self.swap(index,self.parent(index))
            index=self.parent(index)
    
    def removeMin(self):
        if len(self.heap)==0:
            return None
        
        min_val=self.heap[0]
        last_val=self.heap.pop()

        if len(self.heap)>0:
            self.heap[0]=last_val
            self.heapify(0)
        return min_val
    
    def heapify(self,i):
        smallest=i
        left=self.leftChild(i)
        right=self.rightChild(i)

        if left<len(self.heap) and self.heap[left]<self.heap[smallest]:
            smallest=left
        if right<len(self.heap) and self.heap[right]<self.heap[smallest]:
            smallest=right

        if smallest !=i:
            self.swap(i,smallest)
            self.heapify(smallest)
    
    def peekMin(self):
        if len(self.heap)==0:
            return None
        return self.heap[0]
    
if __name__== "__main__":
    h=MinHeap()
    h.insert(10)
    h.insert(4)
    h.insert(15)
    h.insert(1)

    print("Min Element:",h.peekMin())
    print("Removed:",h.removeMin())
    print("New Min:",h.peekMin())


