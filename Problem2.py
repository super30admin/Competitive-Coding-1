# Problem 2 Design Min Heap
# Time Complexity: O(log N) for insert function where N is the no.of elements stored 
#                : O(log N) for extract_min function where N is the no.of elements stored
#                : O(1) for get_min as we are directly looking for the min value
# Space Compelxity: O(1) as everything is happening in the same self.heap list

class MinHeap:
    def __init__(self):
        self.heap=[]
    
    def _heapify_up(self,index):
        while index > 0:
            parent_index=(index-1)//2
            if self.heap[index]<self.heap[parent_index]:
                self.heap[index],self.heap[parent_index]=self.heap[parent_index],self.heap[index]
                index=parent_index
            else:
                break

    def insert(self,val):
        self.heap.append(val)
        last_index=len(self.heap)-1
        self._heapify_up(last_index)
    
    def get_min(self):
        return self.heap[0] if len(self.heap)>0 else None 

    def _heapify_down(self,index):
        length=len(self.heap)
        while 2*index+1<length:
            left_child=2*index+1
            right_child=2*index+2
            smallest=left_child

            if right_child<length and self.heap[right_child]<self.heap[left_child]:
                smallest=right_child
            if self.heap[index]<=self.heap[smallest]:
                break
            else:
                self.heap[index],self.heap[smallest]=self.heap[smallest],self.heap[index]
                index=smallest

    def extract_min(self):
        if len(self.heap)==0:
            return None
        if len(self.heap)==1:
            return self.heap.pop()
        min_val=self.heap[0]
        self.heap[0]=self.heap.pop()
        self._heapify_down(0) 
        return min_val


if __name__ == "__main__":
    my_heap = MinHeap()
    my_heap.insert(30)
    my_heap.insert(10)
    my_heap.insert(20)
    my_heap.insert(5) 
    print("Smallest number is:", my_heap.get_min()) 
    print("Pulling them out:")
    print(my_heap.extract_min())
    print(my_heap.extract_min()) 
    print(my_heap.extract_min())
    print(my_heap.extract_min()) 