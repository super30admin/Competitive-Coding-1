# Time Complexity :  O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No, Don't have a premium subscription :(
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class Solution(object):
    # check if middle element  is 1 greater than left neighbor and
    # 1 lesser than right neighbour, if not return the missing element
    # else based on index and element check if missing element is
    # in left or right part of array and move pointers accordingly
    def missingElement(self, arr):
        if arr == None:
            return -1
        left = 0
        right = len(arr)-1
        while left <= right:
            mid = left + (right - left) / 2
            if mid > 0 and arr[mid]-1 != arr[mid-1]:
                return arr[mid]-1
            elif mid < len(arr)-1 and arr[mid]+1 != arr[mid+1]:
                return arr[mid]+1
            elif arr[mid] - 1 == mid:
                left = mid + 1
            else:
                right = mid - 1


arr = [1,3,4,5,6,7]
s = Solution()
print(s.missingElement(arr))
