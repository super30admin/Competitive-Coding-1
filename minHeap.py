"""
Min Heap

Refer this link for properties - https://www.geeksforgeeks.org/binary-heap/

Parentnode = i-1/2
left node = 2i+1
right node = 2i+2

Insert = insert the node at the last position and bubble it up

Delete = swap the first and the last element, remove the last element (new min), and bubble down the first element

Refer this link for code - https://www.geeksforgeeks.org/min-heap-in-java/
"""


heap = [1,3,6,5,9,8]
temp = 0
def swap(pos1,pos2):
    temp = heap[pos1]
    heap[pos1] = heap[pos2]
    heap[pos2] = heap[pos1]

def insert(heap : list, element: int) -> list:
    heap.append(element)
    parent= (heap.index(element) -1 )//2
    position = heap.index(element)

    while(heap[parent]>heap[element]):
        swap(parent, position)
        position = parent 
        parent = (heap.index(heap[position]) -1 )//2
       
    return heap

def getMin (heap : list) -> int :
    return heap[0]

def extractMin(heap : list) -> list :
    lastnode = heap[len(heap)-1]
    # rootnode = heap[0]
    # swap the root node and the last node values
    swap(len(heap)-1, 0)
    # position of parent of last node(node that will be deleted)
    pos = (lastnode-1)//2 
    #  position of parent of parent of last node
    parentpos = (pos -1)//2
    heap.remove(heap[len(heap)-1])

    while(parentpos>pos):
        swap(pos, parentpos)
        pos = parentpos
        parentpos = (pos -1)//2

    return heap


print(heap)
print("inserting value - 2 ")
newheap = insert(heap, 2)
print(newheap)
print('getMin--')
min = getMin(heap)
print(min)
print('extract min')
newheap = extractMin(heap)
print(newheap)
