# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : problem not on leetcode

from typing import List
def search(arr: List[int], size: int) -> int:
    l, r = 0, size - 1

    while l <= r:
        m = l + (r - l) // 2

        # If the middle element is not on
	    # the middle index, then the missing element is mid + 1.
        if arr[m] != m + 1 and arr[m - 1] == m: 
            return m + 1

        # This case means that the missing element is
	    # not to the left. So search the right.	
        if (arr[m] == m + 1):
            l = m + 1; 

		# This case means that the missing element is not
		# to the right. So search the left.
        else:
            r = m - 1      
    return -1






# Driver Code
a = [1, 2,  4, 5, 6,7, 8]
n = len(a)
 
print("Missing number:", search(a, n))