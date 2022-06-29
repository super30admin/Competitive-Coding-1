from pip import List
def search(list : List[int]):
    if(len(list)==0):
        return None
    elif(len(list)==1 or list[0]!=1):
        return 1
    low = 0
    high = len(list)-1
    while(low<high):
        mid = int(low + (high-low)/2)
        if(low+1 ==high):
            if(list[low]-low != 1):
                return list[low]-1
            else:
                return list[low]+1
        if(list[mid]-mid ==1):
            low = mid
        else:
            high = mid

list = [1,3,4,5]
print(search(list))