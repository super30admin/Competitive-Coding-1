#space complexity: O(n) for both push and pop
#time complexity: O(n) for push and O(1) for pop
#While pushing the element with the lowest priority stays at the top. while popping the element at the top is returned.
class Node:
    def __init__(self,priority) -> None:
        self.priority=priority
        self.next=None
class PriorityQueue:
    def __init__(self) -> None:
        self.head=None
    def push(self,priority):
        node=Node(priority)
        if(self.head==None):
            self.head=node
        else:
            
            curr=self.head
            nxt=curr.next
            if(curr.priority>priority):
                self.head=node
                node.next=curr
                return
            while(nxt):
                if(nxt.priority>priority):
                    node.next=nxt
                    curr.next=node
                    return
                nxt=nxt.next
                curr=curr.next
            curr.next=node
    def pop(self):
        if(self.head==None):
            return "Cannot pop"
        temp=self.head
        data=temp.priority
        self.head=temp.next
        del(temp)
        return data

            
    def show(self):
        curr=self.head
        while(curr):
            print(curr.priority)
            curr=curr.next
        


q=PriorityQueue()
q.push(4)
q.push(5)
q.push(2)
print("popped priority is"+str(q.pop()))
q.show()