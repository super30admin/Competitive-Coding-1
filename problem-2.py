# time complexity: O(n^2)
# space complexity: O(n)

class Node:
        def __init__(self, val=None, next=None ):
            self.val=val
            self.next=next
class pLL:
    
    def pLinkedList(self,list):
        
        head=None
        for x in list:
            if head==None:
                head=Node(x,None)
            else:
                if x< head.val:
                    temp=head
                    head=Node(x,temp)
                else:
                    temp=head
                    prev=temp
                    while(temp!=None):
                        if x<temp.val:
                            break
                        else:
                            prev=temp
                            temp=temp.next
                    prev.next=Node(x, temp)

        temp=head
        while(temp!=None):
            print(temp.val)
            temp=temp.next

obj=pLL()
obj.pLinkedList([3,4,2,6,7,5,1])






