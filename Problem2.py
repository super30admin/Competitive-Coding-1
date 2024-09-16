# getMin(): Time Complexity of this operation is O(1).
# extractMin(): Time Complexity of this Operation is O(Log n) as this operation needs to maintain the heap property (by calling heapify()) after removing the root.
# insert(): Inserting a new key takes O(Log n) time.

class MinHeap:
    def __init__(self,capacity):
        self.capacity = capacity
        self.size = 0
        self.heap = [0]*capacity

    def hasparent(self,index):
        pindex = (index-1)//2
        return  pindex >=0 
    def isfull(self):
        return self.size == self.capacity

    def hasleftchild(self,index):
        return 2*index +1 < self.size
    
    def hasrightchild(self,index):
        return (2*index) +2 <self.size

    

    def get_parent(self,index):
        return (index-1)//2
    def swap(self,i1,i2):
        temp = self.heap[i1]
        self.heap[i1] = self.heap[i2]
        self.heap[i2] = temp

    def heapify(self):
        last_ind = self.size -1 #last inserted index
        while(self.hasparent(last_ind) and (self.heap[self.get_parent(last_ind)] > self.heap[last_ind])):
            self.swap(self.get_parent(last_ind),last_ind)
            last_ind = self.get_parent(last_ind)
    def heapifydown(self):
        if self.size ==0:
            return
        index = 0
        while(self.hasleftchild(index)):
            smallchildindex = (2 * index ) + 1
            if self.hasrightchild(index) and (self.heap[(2 *index)+2] < self.heap[smallchildindex]):
                smallchildindex = (2 *index)+2
            if self.heap[index] < self.heap[smallchildindex]:
                break
            else:
                self.swap(index,smallchildindex)
            index = smallchildindex


    def insert(self,data):
    
        if self.isfull():
            print("Heap is full, cant insert {}".format(data))
            return
        self.heap[self.size] = data
        self.size +=1
        self.heapify()
    def getMin(self):
        if self.size==0:
            print("heap is empty")
            return
        print("MIn Element is {}".format(self.heap[0]))
        return self.heap[0]
    def print(self):
        for i in range(self.size):
            print(self.heap[i],end='\t')
        print("\n")

    def ExtractMin(self):
        if self.size ==0:
            print("heap is empty, cant remove")
            return
        popped = self.heap[0]
        self.swap(0,self.size-1)
        self.size -=1
        self.heapifydown()
        return popped


hmap = MinHeap(7);
hmap.getMin()
hmap.insert(5);
hmap.insert(3);
hmap.getMin()
hmap.insert(17);
hmap.print();
hmap.insert(10);
print("Before minheap")
hmap.print();
hmap.ExtractMin()
print("After MINHEAP")
hmap.print();
hmap.insert(84);
hmap.insert(19);
hmap.print();
hmap.insert(6);
hmap.insert(22);
print("Before minheap")
hmap.print();
hmap.ExtractMin()
print("After MINHEAP")
hmap.print();
print("Before minheap")
hmap.print();
hmap.ExtractMin()
print("After MINHEAP")
hmap.print();
hmap.insert(9);
hmap.print();
hmap.getMin()
hmap.print();