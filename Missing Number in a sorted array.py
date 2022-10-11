class Solution:
    # Google Problem : https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
	# Time Complexity : O(log n)
	# Space Complexity : O (1)
    def findMissing(self, arr) -> int:
        s = 0
        e = len(arr)-1
        
        if arr[0] != 1:
            return (1)
            
        while s<=e:
            m = int((s+e)/2)
            if arr[m] - arr[m-1] == 2:
                return( arr[m]-1)
            if m+1 == arr[m]:
                s = m+1
            else:
                e = m-1
        return(-1)

#res = Solution().findMissing([1,2,3,4,6])
#print(res)