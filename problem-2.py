# time complexity: O(n^2)
# space complexity: O(n)
# node class 
class Node:
        def __init__(self, val=None, next=None ):
            self.val=val
            self.next=next
# priority linked list class 
class pLL:
    
    def pLinkedList(self,list):
        
        head=None
        # looping throug all the list 
        for x in list:
            # if first elemnt place head 
            if head==None:
                head=Node(x,None)

            else:
                # if val is less than head than place node at head and mve head 
                if x< head.val:
                    temp=head
                    head=Node(x,temp)
                else:
                    # loop linke lits unitl the position is found 
                    temp=head
                    prev=temp
                    while(temp!=None):
                        if x<temp.val:
                            break
                        else:
                            prev=temp
                            temp=temp.next

                    # place the eleent next to the prev element  
                    prev.next=Node(x, temp)
        # loop through the linked list to check if every thing is placed correctly  
        temp=head
        while(temp!=None):
            print(temp.val)
            temp=temp.next

obj=pLL()
obj.pLinkedList([3,4,2,6,7,5,1])






