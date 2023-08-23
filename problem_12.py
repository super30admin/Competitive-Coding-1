class minheap:
    def __init__(self):
        self.heap=[None]
        self.current_size=-1
    def insert(self,i): # see that min ele is always at 0th position --- o(1)
        #print("vvv",i)
        if self.heap == [None]: #iniial insertion
            #print("vvv1", i)
            self.heap[0]=i
            self.current_size=len(self.heap)-1
        else: #if its not the first element
            #print("vvv2", i)
            self.heap.append(i)
            #self.percUp(i)
            self.current_size = len(self.heap) - 1 #updating current size to get j values
            j=self.current_size
            while (j//2  >= 0 and i != 0) and ((j//2) <= self.current_size): #to handle edge case of j=1 and j=0 and to see thate we dont get array out of bound error
                #print("vvv3", i)
                k=j
                if j%2==0: #for the heap poperty to satisfy with j being even
                    #print("vvv4", i)
                    if self.heap[j] < self.heap[(j//2) - 1]:
                        #tmp = self.heap[i//2 -1]
                        #print("vvv5", i)
                        self.heap[(j // 2 )- 1],self.heap[j] = self.heap[j],self.heap[j // 2 - 1]
                        j= (j // 2) - 1
                    else:
                        #print("vvv8", i)
                        break;

                else: #for the heap poperty to satisfy with j being odd
                    #print("vvv5", i)
                    if self.heap[j] < self.heap[(j // 2) ]:
                        #print("vvv6", i)
                        self.heap[j // 2 ], self.heap[j] = self.heap[j], self.heap[j // 2 ]
                        j= (j // 2)
                    else:
                        #print("vvv7", i)
                        break;

    def del_min(self): # to find the min child of the heap with
        min=self.get_min()
        self.heap[0]=self.heap[self.current_size] #move the last element up and purce down
        self.heap.pop()
        self.current_size = len(self.heap) - 1
        i=0
        while (2*i+1) <= self.current_size:
            if (self.heap[i]>self.heap[2*i+1]) and (2*i+1) <= self.current_size: #check the left leaf
                self.heap[i],self.heap[2*i+1]=self.heap[2*i+1],self.heap[i]
                i=2*i+1
            elif (self.heap[i]>self.heap[2*i+2]) and ((2*i+2) <= self.current_size):# check for right leaf
                self.heap[i], self.heap[2 * i + 2] = self.heap[2 * i + 2], self.heap[i]
                i=2*i+2
            else:
                break;


    def get_min(self): #0(1)
        return self.heap[0]
    def print_heap(self):
        return self.heap
c= minheap()
c.insert(2)
c.insert(3)
print(c.print_heap())
c.insert(4)
print(c.print_heap())
print(c.get_min())
#c.insert(4)
c.insert(17)
c.insert(16)
c.insert(15)
c.insert(5)
c.insert(6)
print(c.print_heap())
print(c.get_min())
c.del_min()

print(c.get_min())

print(c.print_heap())
c.insert(7)
print(c.get_min())

print(c.print_heap())
