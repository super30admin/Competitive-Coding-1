class Heap:
    
    def __init__(self,size):
        self.list = (size+1) *[None]
        self.heapsize = 0
        self.maxsize = size +1
        
def peek(root):
    if not root:
        return
    else:
        return root.list[1]
    
def length(root):
    if not root:
        return
    else:
        return root.heapsize
    
    
def levelorder(root):
    if not root:
        return
    else:
        for i in range(1,root.heapsize+1):
            print(root.list[i])
            
def heapifyinsert(root, index, heaptype):
    parent = index//2
    if index <=1:
        return
    if heaptype == "Min":
        if root.list[index] < root.list[parent]:
            root.list[index],root.list[parent] = root.list[parent], root.list[index]
        heapifyinsert(root,parent,heaptype)
    if heaptype == "Max":
        if root.list[index] > root.list[parent]:
            root.list[index],root.list[parent] = root.list[parent], root.list[index]
        heapifyinsert(root,parent,heaptype)
        
        
        
def insert(root, value, heaptype):
    if root.heapsize+1 == root.maxsize:
        return "Heap is full"
    root.list[root.size+1] = value
    root.heapsize +=1
    heapifyinsert(root, root.heapsize, heaptype)
    return "Value has been added"

    
def heapifyextract(root, index, heaptype):
    left = index *2
    right = index *2 +1
    swap =0
    
    if root.heapsize < left:
        return
    elif root.heapsize ==left:
        if heaptype== "Min":
            if root.list[index] > root.list[left]:
                root.list[index], root.list[left] =root.list[left], root.list[index]
                
            return
        else:
            if root.list[index] < root.list[left]:
                root.list[index], root.list[left] =root.list[left], root.list[index]
                
            return
    else:
        if heaptype == "Min":
            if root.list[left] < root.list[right]:
                swap = left
            else:
                swap = right
            if root.list[index] > root.list[swap]:
                root.list[index], root.list[swap] =root.list[swap], root.list[index]
                
        else:
            if root.list[left] > root.list[right]:
                swap = left
            else:
                swap = right
            if root.list[index] < root.list[swap]:
                root.list[index], root.list[swap] =root.list[swap], root.list[index]
            heapifyextract(root,swap,heaptype)    
                
            
def extract(root,heaptype):
    if root.heapsize==0:
        return
    else:
        ans = root.list[1]
        root.list[1] = root.list[root.heapsize]
        root.list[root.heapsize] = None
        root.heapsize -=1     
        heapifyextract(root, 1, heaptype)
        return ans
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
