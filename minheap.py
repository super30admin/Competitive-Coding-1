# TC: O(log n) SC:O(1)
class MinHeap:

    def ParentNode(self, index): #TC: O(1) SC:O(1)
        return (index - 1) // 2

    def LeftNode(self, index): #TC: O(1) SC:O(1)
        return (2 * index) + 1

    def RightNode(self, index): #TC: O(1) SC:O(1)
        return (2 * index) + 2

    def peek(self, index):  #TC: O(1) SC:O(1)
        return Min_heap[index]

    def size(self): #TC: O(1) SC:O(1)
        return len(Min_heap)

    def Print(self): #TC: O(n) SC:O(1)
        for i in range(len(Min_heap)):
            print(Min_heap[i])

    def add(self, value):  # TC: O(log n) SC:O(1)
        if len(Min_heap) == 0:
            Min_heap.append(value)
        else:
            Min_heap.append(value)
            curr_index = len(Min_heap) - 1
            while curr_index > 0 and Min_heap[curr_index] < Min_heap[self.ParentNode(curr_index)]:
                temp = Min_heap[curr_index]
                Min_heap[curr_index] = Min_heap[self.ParentNode(curr_index)]
                Min_heap[self.ParentNode(curr_index)] = temp
                curr_index = self.ParentNode(curr_index)


# Example usage
Min_heap = []
heap = MinHeap()
heap.add(5)
heap.add(3)
heap.add(7)
heap.add(1)
heap.Print()
