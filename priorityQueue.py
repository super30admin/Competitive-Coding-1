'''
Time Complexity: Below
Space Complexity: Below
Did this code successfully run on Leetcode : Yes
Explanation: Create a linked list and create the list based on the priority of the element ie the least priority will
be at the start. We start from the beginning and attach the node if its the least priority, we do so if we also want to
attach it in middle. For pop just move the head to head.next
'''
class Node:
    def __init__(self, value,priority):
        self.value = value
        self.priority = priority
        self.next = None

class priorityQueue:
    def __init__(self):
        self.head = None

    '''
    Time Complexity: O(n)
    Space Complexity: O(n)
    '''
    def push(self, value, priority):
        temp = Node(value,priority)
        if self.head ==None:
            self.head = temp
            return
        cur = self.head

        if cur.priority > priority:
            temp.next = self.head
            self.head = temp
            return

        while cur.next!=None and cur.next.priority<priority:
            cur = cur.next

        temp.next = cur.next
        cur.next = temp

        return

    '''
    Time Complexity: O(1)
    Space Complexity: O(1)
    '''
    def pop(self):
        temp = self.head
        self.head = self.head.next
        return temp.priority

queue = priorityQueue()
queue.push(1,3)
queue.push(1,4)
queue.push(1,1)
queue.push(1,2)
print(queue.pop())
print(queue.pop())
print(queue.pop())