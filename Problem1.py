# // Time Complexity : O(log(n)) because ninary search
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : NA
# // Any problem you faced while coding this : No

# An array without duplicate elements. Find missing elemnt.
# We know that '1' element is missing. We need to eliminate one half of the array to use binary search. 
# We can check the difference between values and compare it with difference between indexes
# If one side doesnt have he missing element, we know its on the other side. Rinse and repeat.
# [1, 2, 3,^5, 6, 7, 8] OG array
# [0, 1, 2, 3, 4, 5, 6] index
#  Output = 4

class Solution:
    def missingItem(self, arr:list) -> int:
        
        if arr == []:
            return "no elements"
        if len(arr) == 1:
            return "only 1 elemnt"
        
        high = len(arr)-1
        low = 0

        
        while high-low>1:
            mid = low +(high-low)//2	           
            if arr[mid] - arr[low] != mid - low:   # left of mid is missing 
                high = mid                                  
            else:                                  # right of mid is missing
                low = mid                          
            
        return arr[low]+1


print(Solution().missingItem([1,2,3,5,6,7,8]))
print(Solution().missingItem([5,7]))
print(Solution().missingItem([1]))
print(Solution().missingItem([]))

