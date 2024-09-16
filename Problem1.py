#Find missing number in given array.
def missingNumbers(arr):
    low=0
    high=len(arr)-1
    if len(arr)==0:
        return -1
    while low+1<high:
        mid=low+(high-low)//2
        if arr[mid]-mid!=1:
            high=mid
        else:
            low=mid
            
    return (arr[low]+arr[high])//2

print(missingNumbers([1,2,3,4,6]))
#TC: O(log n)
#SC: O(1)