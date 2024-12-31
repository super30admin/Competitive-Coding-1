#Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer. 
#Examples: 
#Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
#Output : 5
#Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
#Output : 7

#Time complexity: O(logn)
#Space complexity: O(1)

arr = [1, 2, 3, 5, 6, 7, 8]

low = 0
high = len(arr)-1

def BinarySearch(arr, low, high):
    while low<=high:
        mid = (low+high)//2
        if arr[mid] != mid+1:
            return mid
        elif arr[mid-1] != mid:
            high = mid-1
        else:
            low=mid+1
    return mid

if arr[low] != 1:
    print(1)
elif arr[high] == len(arr):
    print("all good")
else:
    res = BinarySearch(arr,low,high)+1
    print(res)