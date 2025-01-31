# Insert (push): Push elements onto push_stack.
# Extract Min (pop): If heap_stack is empty, transfer elements from push_stack to heap_stack, keeping them sorted (like a heap).
# Peek Min (top): The top of heap_stack will always have the minimum element.
# Time Complexity:
# PushO(1) (Simply appending to push_stack)
# Pop: O(NlogN) (Sorting when transferring elements)
# Top:(NlogN) (Same as pop since it sorts when transferring)
# Space complexity of this approach is O(N)
class MinHeapWithStacks:
    def __init__(self):
        self.push_stack = []  # Main stack for pushing elements
        self.heap_stack = []  # Stack to store elements in min-heap order

    def push(self, val):
        self.push_stack.append(val)

    def pop(self):
        if not self.heap_stack:
            while self.push_stack:
                self.heap_stack.append(self.push_stack.pop())
            self.heap_stack.sort(reverse=True)  # Sorting to maintain min-heap order
        
        return self.heap_stack.pop() if self.heap_stack else None

    def top(self):
        if not self.heap_stack:
            while self.push_stack:
                self.heap_stack.append(self.push_stack.pop())
            self.heap_stack.sort(reverse=True)
        
        return self.heap_stack[-1] if self.heap_stack else None

    def is_empty(self):
        return not self.push_stack and not self.heap_stack

# Example Usage
heap = MinHeapWithStacks()
heap.push(3)
heap.push(1)
heap.push(5)
heap.push(2)
print(heap.pop())  # Output: 1 (min element)
print(heap.pop())  # Output: 2
print(heap.top())  # Output: 3 (next min element)

