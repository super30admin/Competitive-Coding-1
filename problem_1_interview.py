# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:
    def searchMissingElem(self, sortedArry):
        # checks if array is empty 
        if len(sortedArry) == 0:
            return -1

        start, end = 0, len(sortedArry)-1
        while(start <= end):
            #handles for all elements are present & first element is missing
            if(sortedArry[start] - (start) == sortedArry[end] - (end) == 1):  
                return -1
            mid = (start + end ) // 2

            
            if (sortedArry[mid] - mid == 1): #left side has no missing element
                start = mid + 1
            else: #right side has no missing element
                end = mid - 1
        
        return start+1

obj = Solution()
# val = obj.searchMissingElem([1,2,3,4,5,7,8,9])
# val = obj.searchMissingElem([1,2,3,4,5,6,7,8,9])
# val = obj.searchMissingElem([1,2,3,4,5,6,7,8])
# val = obj.searchMissingElem([2,3,4,5,6,7,8])
val = obj.searchMissingElem([])
print("missing elem ->", val)