# Question: https://www.geeksforgeeks.org/java/min-heap-in-java/
# Time Complexity : O(n)
# Space Complexity : O(n)

class Solution():
    def __init__(self, capacity):
        self.heap = [0]
        self.size = 0
        self.capacity = capacity

    def parent(self, position):
        return position//2
    
    def left_child(self, position):
        return (2 * position)
    
    def right_child(self, position):
        return (self.left_child(position) + 1)
    
    def isLeaf(self, position):
        if position > self.size // 2:
            return True
        else:
            return False
    
    def swap(self, child, parent):
        self.heap[child], self.heap[parent] = self.heap[parent], self.heap[child]
        
    def insert(self, value):
        if self.size >= self.capacity:
            return

        self.size += 1
        self.heap.append(value)
        current = self.size

        while self.heap[current] < self.heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)

    def print_heap(self):
        for i in range(1, self.size+1):
            print(self.heap[i])

    def remove(self):
        if self.size == 0:
            return None
        
        removed_value = self.heap[1]
        self.heap[1] = self.heap[self.size]
        self.size = self.size - 1
        self.heapify(1)
        return removed_value

    def heapify(self, position):
        if not self.isLeaf(position):
            left = self.left_child(position)
            right = self.right_child(position)
            smallest = position

            if left <= self.size and self.heap[left] < self.heap[smallest]:
                smallest = left
            if right <= self.size and self.heap[right] < self.heap[smallest]:
                smallest = right

            if smallest != position:
                self.swap(position, smallest)
                self.heapify(smallest)


obj = Solution(capacity=10)
obj.insert(5)
obj.insert(3)
obj.insert(17)
obj.insert(10)
obj.insert(84)
obj.insert(19)
obj.insert(6)
obj.insert(22)
obj.insert(9)
obj.print_heap()
sol1 = obj.remove()
print("Removed:", sol1)
obj.print_heap()