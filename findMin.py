#Time Complexity: O(N)
#Space Complexity: O(1)

def findMissingElement(arr): ##elemnets range from 1 to n - 1
    low = 0
    n = len(arr)
    high = n - 1
    #if missing elemnet is the last element
    if arr[n - 1] == n:
      return  n + 1
    while low <= high:
      mid = low + (high - low) // 2
      if mid + 1 == arr[mid]:  ##Right half
        if mid != n - 1 and arr[mid + 1] != mid + 2:
           return mid + 2
        low = mid + 1
      else:   ## Left half
        if mid != 0 and arr[mid - 1] != mid: #Check the immediate element next to the mid on the Left side
           return mid + 1
        high = mid - 1

arr = [1,2,3,4,5,6]
findMissingElement(arr)