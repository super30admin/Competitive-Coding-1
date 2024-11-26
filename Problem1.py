# TimeComplexity - O(log n)
# SpaceComplexity - O(1)

# Approach 1
def missingElement(array):
    start=0
    end=len(array)-1
    if len(array) == 0:
        return -1
    while(start<=end):
        mid=start+(end-start)//2
        if(array[mid]!=mid+1):
            end=mid-1
        else:
            start=mid+1
    return start+1

print(missingElement([1,3,4,5,6]))

# Approach 2
def missingElement(arr):
    start=0
    end=len(arr)-1
    if len(arr) == 0:
        return -1
    while(end - start >= 2):
        mid=start+(end-start)//2
        midIdxDiff = arr[mid] - mid
        startIdxDiff = arr[start] - start
        endIdxDiff = arr[end] - end
        if(midIdxDiff != startIdxDiff):
            end=mid
        elif(midIdxDiff != endIdxDiff):
            start=mid

    return (arr[start]+ arr[end])//2

print(missingElement([1,2,3,4,6]))