# Time Complexity : O(log n)
# Space Complexity : O(1)

class Solution:
    def missingNumber(self, nums):
        
        # Start traversing from low to high
        low = 0
        high = len(nums) - 1
        while low < high:
          
           # finding the middle element
            mid = low + (high - low) // 2
            
            # Finding the difference at the middle, low and high position, with the value at that place with it's index, 
            #this way we can check which way to proceed, either left or righ sub-array
            # IF value is same, then we know values are in order, so we move to the opposite sub-array
            diff_low = nums[low] - low
            diff_mid = nums[mid] - mid
            diff_high = nums[high] - high
            
            if diff_mid != diff_low:
                high = mid - 1
            else:
                low = mid + 1
                
        # If difference from the mid is greater than 1, we return position at that number - 1, else val + 1
        if diff_mid > 1:
            return nums[mid] - 1
        else:
            return nums[mid] + 1
s = Solution()
a = [5,6,7,8,9,11,12]
res = s.missingNumber(a)
print(res)
