// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : couldnt find on leetcode
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach: used binary search


def missing(arr, n):
  l = 0
  h = len(arr)-1

  while l<h:
    mid = (l + h)//2

    if arr[mid]-1 != mid and arr[mid-1]!=arr[mid]-1:
      return arr[mid]-1
    
    if arr[mid]-1 != mid and arr[mid-1]==arr[mid]-1:
      h = mid-1
    else:
      l = mid+1
  return n+1
