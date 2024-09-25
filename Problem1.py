# Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.


# Examples:
# Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
# Output : 5
arr = [1, 2, 3, 4, 6, 7, 8]

def find_missing_number(arr):
  l, r = 0, len(arr) - 1

  while l <= r:
    mid = (l + r) // 2
    
    if arr[mid] == mid + 1:
      l = mid + 1
    else:
      r = mid - 1
    
  return l+1  

print(find_missing_number(arr))
    