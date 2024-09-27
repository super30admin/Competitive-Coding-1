#************************ Missing Number **************************
# Time Complexity : O(n) n is the number of values in nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# If the numbers start from 1 to n, then we can calculate 
#the sum of n numbers using the formula n*(n+1)//2 and by subtracting the sum of numbers gives the missing number in the array

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)+1
        total = (n*(n+1))//2
        return total-sum(nums)



# *************************** Another Solution *****************************

#************************ Missing Number **************************
# Time Complexity : O(logn) n is the number of values in nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# with low = 0 and high = len(nums)-1, we can return -1 if there are no missing elements by taking difference between numbers and indexes.
# Here I have used binary search by taking mid element, and the difference between numbers is not equal to difference between indexes we will move our pointer to that side.
#and when ever low == high , we are returning the low pointer +1

def missingNumber(nums):
	if not nums:
		return -1
	
	low = 0
	high = len(nums)-1
	
	if nums[high] - nums[low] == high -low:
		return -1
	
	while low<high:
		mid = (low+high)//2
		
		if low == mid:
			return nums[low]+1
		
		if nums[mid]-nums[low] > mid-low:
			high = mid
		else:
			low = mid
	return nums[low]+1


        
        
