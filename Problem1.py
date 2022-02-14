# TimeComplexity - O(log n)
# SpaceComplexity - O(1)

def missingEle(array):
    start=0
    end=len(array)-1

    while(start<=end):
        mid=start+(end-start)//2
        if(array[mid]!=mid+1):
            end=mid-1
        else:
            start=mid+1
    return start+1
    
print(missingEle([1,2,3,4,5,7]))