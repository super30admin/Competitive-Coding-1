#TC: push:O(n), pop:O(1)
#SC: O(n)
class Node():
    def __init__(self, val, priority):
        self.val=val
        self.priority=priority
        self.next=None

class PriorityQueue():
    def __init__(self):
        self.head=Node(-1,-1)   #dummy head

    def push(self, new_val, new_priority):
        itr = self.head
        while itr.next!=None and itr.next.val<new_val: itr=itr.next
        new_node=Node(new_val, new_priority)
        new_node.next=itr.next
        itr.next=new_node

    def pop(self):
        if self.head.next==None:
            return -1
        popped=self.head.next
        self.head=self.head.next
        return popped.val,popped.priority

    def print(self):
        print("Printing the List:")
        itr=self.head
        while itr.next!=None:
            print(itr.next.val,itr.next.priority, end=", "); itr=itr.next
        print()

ll=PriorityQueue()
ll.push(0,0)
ll.push(1,1)
ll.push(2,2)
ll.push(3,3)
ll.push(5,5)
ll.push(4,4)
ll.print()
print("Popped Value:",ll.pop())
print("Popped Value:",ll.pop())
ll.print()
