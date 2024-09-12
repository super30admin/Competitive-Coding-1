#time complexity: O(n)
#space complexity: O(n)

class Node:
    def __init__(self, priority):
        self.priority=priority
        self.next=None

class LinkedList:
    def __init__(self):
        self.head=None

    def push(self, priority):
        self.priority=priority
        new_node=Node(priority)

        if self.head==None:
            self.head=new_node
        else:
            temp=self.head
            while(temp.next!=None and temp.next.priority<priority):
                temp=temp.next

            new_node.next=temp.next
            temp.next=new_node
        
    def pop(self):
        if self.head==None:
            print("list is empty")
        else:
            self.head=self.head.next

    def print_list(self):
        if self.head==None:
            print("list is empty")
        else:
            current=self.head
            while(current!=None):
                print(current.priority)
                current=current.next

link=LinkedList()
link.print_list()
print("****")
link.push(10)
link.push(90)
link.push(20)
link.print_list()
print("****")
link.pop()
link.pop()
link.print_list()
print("****")
link.pop()
link.print_list()
