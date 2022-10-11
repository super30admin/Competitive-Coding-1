# Time Complexity: O(log(n))
# Aproach: if the condition on line 12 is met then move right
# else move left till you converge

nums1 = [1,2,3,4,6,7,8,9,10,11,12]
nums2 = [2,4,5,6,7,8]
class Solution:
    def find_missing(self,nums):
        start = 0
        end = len(nums)-1
        while start <= end:
            mid = (start + end) // 2
            if nums[mid] == mid - start + nums[start]:
                start = mid + 1
            else:
                end = mid - 1 
        return nums[end]-1
print("Given input : {0}".format(nums2))
print("answer: {0}".format(Solution().find_missing(nums2))) 