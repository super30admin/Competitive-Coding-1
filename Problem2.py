# Time Complexity: O(N) for insertion, O(1) for peek and pop
# Space Complexity: O(N)

# PriorityQueue using Linked List
class PQListNode:
    def __init__(self, data=None, priority=None):
        self.data = data
        self.priority = priority
        self.next = None

class PriorityQueue:
    def __init__(self):
        self.front = None

    def isEmpty(self):
        if self.front == None:
            return True
        else:
            return False

    # Here for priority we consider the lower number to be of higher priority
    def enqueue(self, data, priority):

        if self.isEmpty():
            self.front = PQListNode(data,priority)
        else:
            if self.front.priority > priority:
                current = self.front
                self.front = PQListNode(data,priority)
                self.front.next = current
            else:
                current = self.front
                while current.next:
                    if current.next.priority > priority:
                        break
                    current = current.next
                new_node = PQListNode(data,priority)
                new_node.next = current.next
                current.next = new_node

    def dequeue(self):

        if self.isEmpty():
            return
        else:
            self.front = self.front.next

    def peek(self):

        if self.isEmpty():
            return
        else:
            return self.front.data