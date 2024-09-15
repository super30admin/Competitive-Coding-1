class LinkedList:
    def __init__(self,value,priority):

        self.next = None
        self.value = value
        self.priority = priority


class PriorityQueue:

    def __init__(self):
        self.head = None

    def isEmpty(self):
        return self.head is None

    def push(self, value, priority):
        temp = LinkedList(value, priority)
        curr = self.head
        if self.isEmpty():
            self.head = temp
        else:
            if curr.priority > priority:
                temp.next = curr
                self.head = temp
            else:
                while curr.next is not None and curr.next.priority < priority:
                    curr = curr.next

                if curr.next is None:
                    curr.next = temp
                else:
                    temp.next = curr.next
                    curr.next = temp

    def pop(self):
        if self.head is not None:
            temp = self.head
            self.head = self.head.next
            return temp.value
        else:
            return -1


pq = PriorityQueue()
pq.push(1,3)
pq.push(3,2)
pq.push(7,5)
print(pq.isEmpty())
print(pq.pop())
print(pq.isEmpty())
print(pq.pop())
print(pq.isEmpty())
print(pq.pop())
print(pq.isEmpty())
print(pq.pop())






