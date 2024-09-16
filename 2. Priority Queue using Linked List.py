class Node:
    def __init__(self, value, priority):
        self.data = value
        self.priority = priority
        self.next = None

class PriorityQueue:
    def __init__(self):
        self.head = None

    def isEmpty(self):
        if self.head is None:
            return True
        else:
            return False

    # Lower the value of the priority, higher the priority
    def push(self, value, priority):
        if self.isEmpty():
            self.head = Node(value, priority)
            return
        else:
            if self.head.priority > priority:
                new_node = Node(value, priority)
                new_node.next = self.head
                self.head = new_node
                return
            # Traverse the queue and find the right placce for the node
            else:
                temp = self.head
                while temp.next:
                    if priority <= temp.next.priority:
                        break
                    temp = temp.next
                new_node = Node(value, priority)
                new_node.next = temp.next
                temp.next = new_node
                return

    # Removes the element with the highest priority
    def pop(self):
        if self.isEmpty():
            return
        else:
            self.head = self.head.next
            return

    def print_queue(self):
        if self.isEmpty():
            return "Empty"
        else:
            temp = self.head
            while temp:
                print(temp.data, end = " ")
                temp = temp.next
            print('\n')

pq = PriorityQueue()
pq.push(4,1)
pq.push(5,2)
pq.push(6,3)
pq.push(7,0)
pq.print_queue()
pq.pop()
pq.print_queue()
