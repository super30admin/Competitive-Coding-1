# Time Complexity : O(log(N))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def search(self,arr, size):
        if(arr[0] != 1):
            return 1
        if(arr[size-1] != (size+1)):
            return size+1
    
        a = 0
        b = size - 1
        mid = 0
        while b > a + 1:
            mid = (a + b) // 2
            if (arr[a] - a) != (arr[mid] - mid):
                b = mid
            elif (arr[b] - b) != (arr[mid] - mid):
                a = mid
        return arr[a] + 1