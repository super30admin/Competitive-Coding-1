'''
Time Complexity -->
push --> O(n)
pop() --> O(1) since the head is poped
peek() --> O(1) since the top element is peepked

Approach-->
The priority is given and based on that data we try to link the list
here i have choosen 1 has the greated priority and others have least
'''

class Node:
    def __init__(self, priority):
        self.priority = priority
        self.next = None
    

        

class Priority:
    def __init__(self):
        self.head = None
    
    def push(self, p):
        if self.head==None:
            self.head = Node(p)
            return 
        else:
            curr = self.head
            if p<curr.priority:
                newNdoe = Node(p)
                newNdoe.next = self.head
                self.head = newNdoe
            else:
                while curr.next:
                    if curr.next.priority<p:
                        curr = curr.next
                    else:
                        newNdoe = Node(p)
                        newNdoe.next = curr.next
                        curr.next = newNdoe
                        return
    
    def pop(self):
        if self.head==None:
            print("List is empty")
            return
        else:
            tmp = self.head
            self.head = self.head.next
            return tmp.priority
    
    def peek(self):
        if self.head!=None:
            return self.head.priority


arr = [3,4,2,6,7,5,1]
prior = Priority()

for i in range(len(arr)):
    prior.push(arr[i])
val = prior.pop()
print(val)
print(prior.head.priority)
print(prior.peek())
    

