
'''
Algorithm 

1. get min --> will be at 0th position

2. Parents and child nodes will be in the following relation 
   parent index = i lc= 2*i+1 rc=2*i+2
   
3. append use bubble up to move the element to correct position

4. remove use bubble down function to adjust the elements

'''


class min_heap:
    
    def __init__(self):
        self.L=[]
        
    def getmin(self):
        # SC O(1)
        # TC O(1)
        return self.L[0]
    
    def size(self):
        # SC O(1)
        # TC O(1)
        return len(self.L)
    
    def insert(self,val):
        # SC O(1)
        # TC O(log(n))
        self.L.append(val)
        pos=self.size()-1
        self.bubble_up(pos)
        
    def remove(self):
        # SC O(1)
        # TC O(log(n))
        self.L[0],self.L[self.size()-1] =self.L[self.size()-1],self.L[0]
        return_value =self.L.pop()
        
        self.bubble_down(0)
        
        return return_value
    
    def bubble_up(self,index):
        if index==0:
            pass
        
        parent = (index-1)//2
        
        if parent>0 and self.L[index] < self.L[parent]:
                self.L[index],self.L[parent]=self.L[parent],self.L[index]
                self.bubble_up(parent)
    def bubble_down(self,ind):
        print(ind)
        lc=2*ind+1
        rc=2*ind+2
        
        temp=ind
        
        if lc < self.size() and self.L[lc] < self.L[ind]:
            temp=lc
            
        if rc < self.size() and self.L[rc] < self.L[ind]:
            temp=rc
            
        if temp == ind:
            return
        
        self.L[ind],self.L[temp] =self.L[temp],self.L[ind]
        self.bubble_down(temp)
        
        
k=min_heap()

for i in [15,28,16,32,31,20]:
    k.insert(i)
    print(k.L)
    
for i in [15,28,16,32,31,20]:
    k.remove()
    print(k.L)
            



