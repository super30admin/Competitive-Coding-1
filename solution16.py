def getmin(a):
    if(len(a)>0):
        print(a[1])
    
def downHeapify(a,pos):
    if(len(a)==2):
        print(a[1])
    elif(pos<len(a)/2):
        if(a[pos]>a[pos*2] or a[pos]>a[(pos*2)+1]):
            if(pos*2<=len(a)-1 or a[pos*2]<a[(pos*2)+1]):
                temp=a[pos]
                a[pos]=a[pos*2]
                a[pos*2]=temp
                downHeapify(hp,pos*2)
            else:
                temp=a[pos]
                print(temp)
                a[pos]=a[(pos*2)+1]
                a[(pos*2)+1]=temp
                downHeapify(hp,(pos*2)+1)

def extractMin(a):
    if(len(a)>0):
        if(len(a)==1):
            a.pop(0)
            print(a)
        else:
            last=a[-1]
            a[1]=last
            del a[-1]
            downHeapify(a,1)
            print(a[1:])
            
def insert(elem,a):
    if(len(a)==0):
        a.append(elem)
        print(a)
    else:
        a.append(elem)
        pos=len(a)-1
        while(a[pos]<a[pos//2]):
            temp=a[pos]
            a[pos]=a[pos//2]
            a[pos//2]=temp
            pos=pos//2
        print(a[1:])
    
hp=[0]
insert(10,hp)
insert(40,hp)
getmin(hp)
insert(50,hp)
insert(5,hp)
getmin(hp)
extractMin(hp)
extractMin(hp)
extractMin(hp)
extractMin(hp)