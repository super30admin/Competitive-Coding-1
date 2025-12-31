#Here assuming one element is missing for sure.

#version 1
def missingNumber(arr):
    low = 0
    high = len(arr)-1
    
    while low <= high:
      mid = low + (high-low)//2

      if arr[mid] == mid+1:
        low = mid+1
      else:
        high = mid-1
    if low == len(arr):#if nothing is missing
        return -1  
    return low+1 #can be mid+1 as well

#how to write the code if all elements are present and nothing is missing?

if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5, 6, 8]
    print(missingNumber(arr))

#version 2
def missingNumber(arr):
    low = 0
    high = len(arr)-1
    
    while low < high:
      mid = low + (high-low)//2

      if arr[mid] == mid+1:
        low = mid+1
      else:
        high = mid
    if arr[low] == low + 1:
        return -1 #nothing is missing, low won't reach end as it exists before low == high
    return low+1

if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5, 6, 8]
    print(missingNumber(arr))

#Time Complexity O(logn)
# Space Complexity: O(1)