#tc: insert O(logn)
#remove:O(logn)
#getMin:O(1)
#getSize:O(1)


class MinHeap:

    def __init__(self) -> None:
        self.heap=[]

    def getSize(self):
        return len(self.heap)
    
    def getMin(self):
        return self.heap[0]
    

    def bubbleUp(self,ind):

        if ind==0:
            return 
        parent= (ind-1)//2
        #if current ele is less than to parent
        if parent>=0 and self.heap[parent]>self.heap[ind]:
            #swap
            self.heap[ind],self.heap[parent]=self.heap[parent],self.heap[ind]

            #apply bubble up on the parent's parent
            self.bubbleUp(parent)
    

    def insert(self,n):
        #append at end
        self.heap.append(n)

        self.bubbleUp(self.getSize()-1)

    def bubbleDown(self,i):
#check the position of left and right child of current
        leftChild=2*i+1
        rightChild=2*i+2
        temp=i

        if leftChild<len(self.heap) and self.heap[leftChild]< self.heap[temp]:
            #set temp to leftchild
            temp=leftChild

        if  rightChild<len(self.heap) and self.heap[rightChild]<self.heap[temp]:
            temp=rightChild
       
        if temp==i:
            return
                    #i.e either left is small or right is small
        self.heap[i],self.heap[temp]=self.heap[temp],self.heap[i]
        self.bubbleDown(temp)

    def remove(self):
        #swap first element with last
        self.heap[0],self.heap[self.getSize()-1]=self.heap[self.getSize()-1],self.heap[0]
        temp=self.heap.pop()
        #check the ordering from root
        self.bubbleDown(0)
        return temp

obj=MinHeap()
arr=[15,28,16,32,31,20]

for i in arr:
    obj.insert(i)
    print(obj.heap)
for i in arr:
    print(obj.remove())
    print(obj.heap)
    




    

    

    