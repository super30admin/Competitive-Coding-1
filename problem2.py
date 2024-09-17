#Time complexity is: O(logn) fro insert and delete, O(1) for size and getMin
#Space complexity is: O(n)
#Ran the code successfully on leetcode compiler
#Faced no issues while coding

#Working on heap 
class MinHeap(object):
    def __init__(self):
        self.heap=[]
    #method to retrun minimumvalue in the heap
    def getMin(self):
        return self.heap[0]
    
    #retruning the size of the heap
    def size(self):
        return len(self.heap)
    
    #inserting the values into the heap
    def insert(self,num):
        self.heap.append(num)
        #bubbling up the values in the heap to meeth the parent codition
        self.__bubbleUp(self.size()-1)

    #removing the elements from the heap    
    def remove(self):
        self.heap[0],self.heap[self.size()-1]=self.heap[self.size()-1],self.heap[0]
        print(self.heap.pop())
        self.__bubbleDown(0)

    #performing bubbleup operation such that value at the parent is less than the children    
    def __bubbleUp(self,ind):
        if(ind==0):
            return
        self.par=(ind-1)//2
        if(self.par>0 and self.heap[ind]<self.heap[self.par]):
            self.heap[ind],self.heap[self.par]=self.heap[self.par],self.heap[ind]
            self.__bubbleUp(self.par)

    #performing bubbledown operation after removal of an element to meet parent condition        
    def __bubbleDown(self,ind):
        self.left=2*ind+1
        self.right=2*ind+2 
        self.temp=ind
        
        if(self.left<self.size() and self.heap[self.left]<self.heap[self.temp]):
            self.temp=self.left
            
        if(self.right<self.size() and self.heap[self.right]<self.heap[self.temp]):
            self.temp=self.right
        
        if(self.temp==ind):
            return
        #Swapping the values
        self.heap[ind],self.heap[self.temp]=self.heap[self.temp],self.heap[ind]
        self.__bubbleDown(self.temp)
        

obj=MinHeap()
arr=[15,28,16,32,31,20]
for i in arr:
    obj.insert(i)
    print(obj.heap)

for i in arr:
    obj.remove()
    print(obj.heap)

            
            
            