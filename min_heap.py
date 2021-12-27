'''

T.C: O(logn) - heapify, insert, extractMin ; O(1) - getMin
S.C: O(n)

Intution: heap sort when the array is feaded as input initially; Return top element when getmin is called; 
for extract min, exchange the first element with last element, pop and then heapify;
for insert, append to the last, then switch with first element and then heapify;

'''
class MinHeap:
    def __init__(self, arr) -> None:
        self.arr = arr
        self.arr_len = len(arr)
        self.sort()
    
    def heapify(self, idx):
        small = idx
        left = idx + 1
        right = idx + 2

        if left < self.arr_len and self.arr[idx] > self.arr[left]:
            small = left
        
        if right < self.arr_len and self.arr[right] < self.arr[small]:
            small = right
        
        if small != idx:
            self.arr[idx], self.arr[small] = self.arr[small], self.arr[idx]
            self.heapify(small)

    def sort(self):
        for idx in range(self.arr_len//2, -1, -1):
          self.heapify(self.arr, idx)
        
        for idx in range(self.arr_len - 1, 0, -1):
            self.arr[idx], self.arr[0] = self.arr[0], self.arr[idx]
            self.heapify(idx)
    
    def getMin(self):
        return self.arr[0] if self.arr else -1
    
    def extractMin(self):
        self.arr[self.arr_len - 1], self.arr[0] = self.arr[0], self.arr[self.arr_len - 1]
        min = self.arr.pop()
        self.arr_len -= 1
        self.heapify(0)
        return min
    
    def insert(self, val):
        self.arr.append(val)
        self.arr_len += 1
        self.arr[0], self.arr[self.arr_len - 1] = self.arr[self.arr_len - 1], self.arr[0]
        self.heapify(0)


        
