# the problem is to find the missing element in the array.
# we know that the array is sorted. So now it can be done in brute force using linear search by comapring index and element if index of element is one less than element itself, then element is in tis right plce.
# but I used binary search to further reduce the time complexity to log(n)
# If mid is at its correct position, the left array is sorted so I look for elment in right subarray, else in left array
# when low and high are at same place then r4eturn that index+1 which is missing value.
#Time complexity: O(Log(n))
#Space Complexity: O(n)
def selectArr(arr):
    if (arr is None or len(arr)==0):
        return -1
    low = 0
    high = len(arr) - 1
    while (low  <=  high):
        mid = int((low+high)/2)
        if (arr[mid]-1 == mid):
            low = mid + 1
        elif (mid == 0 or mid == len(arr)-1 or low == high):
            return mid + 1
        else:
            high = mid 
    return -1

arr = [1,3,4,5,6,8]
elem = selectArr(arr)
print(elem)