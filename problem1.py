#Missing number in a sorted array
#Sample Input=[1,2,3,4,5,6,8,9], [5,7]
#Linear search would be searchng elements are in correct position or not for each number staring 1
#Time O(log n)
#Space O(1)
def binarySearch(arr):
    low=0
    high=len(arr)-1
    if (arr[low]!=1):
        return 1
    if (arr[low]-low)==(arr[high]-high):
        return arr[high]+1
    while(low<=high):
        mid=(high+low)//2
        
        if (arr[mid]!=mid+1):
            high=mid-1
        else:
            low=mid+1
    
    return arr[high]+1
arr=[1,2,3,4,5,6,8,9]
print(binarySearch(arr))

arr=[2,3,4,5,6,7,8]
print(binarySearch(arr))

arr=[1,2,3,4,5,6,7,8]
print(binarySearch(arr))


arr=[1,2,3,5,6,7,8]
print(binarySearch(arr))

arr=[1,2,6,7,8]
print(binarySearch(arr))
#Outputs: 7, 1, 9, 4, 3
