


class Node:

    def __init__(self,val,priority):
        self.data = val
        self.priority = priority
        self.next = None

class PriorityQueue:

    def __init__(self) -> None:
        self.head = None
    
    def push(self, val , priority):

        if self.head == None:

            node = Node(val,priority)

            self.head = node

            return
        else:
            temp = self.head
            while temp.next:

                if priority <= temp.next.priority:
                    break
                temp = temp.next
            new_node = Node(val,priority)
            new_node.next = temp.next
            temp.next = new_node
            return
    def pop(self):

        if self.isEmpty():
            return
        else:
            self.head = self.head.next
            return


pq = PriorityQueue()
pq.push(2,1)
pq.push(3,2)
pq.push(4,3)
pq.push(4,8)



