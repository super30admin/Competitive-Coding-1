#Time Complexity : O(log n)
#Space Complexity : O(1)
class MinHeap:
     def __init__(self):
         self.heap=[]
        
     def getMin(self):
         return self.heap[0]
     
     def insert(self,ele):
         self.heap.append(ele)
         self.bubbleUp(self.size()-1)
    
     def remove(self):
         self.heap[0],self.heap[self.size()-1]=self.heap[self.size()-1],self.heap[0]
         temp=self.heap.pop()
         self.bubbleDown(0)
         return temp
        
     def size(self):
         return len(self.heap)
      
     def moveUp(self,idx):
         if idx==0:
             return
         par=(idx-1)//2
         if par>=0 and self.heap[idx]<self.heap[par]:
             self.heap[idx],self.heap[par]=self.heap[par],self.heap[idx]
             self.moveUp(par)
            
     def moveDown(self,idx):
         left=2*idx+1
         right=2*idx+2
         temp=idx
         if left < self.size() and self.heap[left] < self.heap[temp]:
             temp=left
         if right < self.size() and self.heap[right] < self.heap[temp]:
             temp=right
         if temp==idx:
             return
         self.heap[idx],self.heap[temp]=self.heap[temp],self.heap[idx]
         self.moveDown(temp)
          
 obj=MinHeap()
 arr=[20, 10, 30, 40, 10]
 for i in arr:
     obj.insert(i)
     print(obj.heap)
      
 for i in arr:
     print(obj.remove())
 print(obj.heap)
