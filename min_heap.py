#Initial commit doesnt work will fix after class
import collections
import sys

class Min_heap(object):
    def __init__(self):
        self.min_heap=collections.deque([-sys.maxsize])

    def find_parent(self,index):
        return self.min_heap[index//2]

    def insert(self, element):
        # insert an element into a Min_heap
        self.min_heap.append(element)
        idx=len(self.min_heap)-1
        while(idx>0 and self.find_parent(idx)>self.min_heap[idx]):
            self.min_heap[idx],self.min_heap[idx//2]=self.min_heap[idx//2],self.min_heap[idx]
            idx=idx//2

                
    def remove(self,idx):
        #remove an element from the min heap
        self.min_heap[1],self.min_heap[-1]=self.min_heap[-1],self.min_heap[1]
        self.min_heap.pop()
        idx=1
        while(idx*2<len(self.min_heap) or idx*2+1<self.min_heap):
            if idx*2+1<len(self.min_heap) and self.min_heap[idx*2+1]<self.min_heap[idx*2]:
                self.min_heap[idx*2+1],self.min_heap[idx]=self.min_heap[idx],self.min_heap[idx*2+1]
                
            else:
                self.min_heap[idx*2],self.min_heap[idx]=self.min_heap[idx],self.min_heap[idx*2]
                idx*=2

    def get_min(self):
        return self.min_heap[1]

