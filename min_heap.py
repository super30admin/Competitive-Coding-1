class min_heap(object):
    def __init__(self):
        self.arr=[]
    
    def getMin(self):
        if len(self.arr)>0:
            return self.arr[0]

    def insert(self,value):
        if len(self.arr)==0:
            self.arr.append(value)
        
        else:
            l=0
            r=len(self.arr)-1
            print(r)
            while l<=r:
                mid = (l+r)//2
                if mid==0:
                    print('y')
                    if value>self.arr[mid]:
                        self.arr.append(value)
                        r+=1
                    else:
                        self.arr.append(value)
                        self.arr.swap[0],self.arr.swap[1] = self.arr.swap[1],self.arr.swap[0]
                        r+=1
                    
                elif self.arr[mid]>value and self.arr[mid-1]<value:
                    self.arr.append(value)
                    r+=1
                    i = len(self.arr)-1
                    while i>=mid:
                        self.arr[i],self.arr[i-1]=self.arr[i-1],self.arr[i]
                        i-=1
                elif self.arr[mid]>value and self.arr[mid-1]>value:
                    l=mid+1
                else:
                    r = mid-1
        print(self.arr)

    def extractMin(self):
        self.arr = self.arr[1:(len(self.arr)-1)]


obj = min_heap()
obj.insert(1)
obj.insert(2)
obj.insert(3)
obj.insert(5)
obj.insert(4)
[1,2,3,5,6,7,8,9,4]