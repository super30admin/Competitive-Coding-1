'''
Question: Find the missing element in a sorted nums array which should 
have values from {1,n}
Approach:
    1) Brute Force : Linear search, check index == nums[index]+1? False ->return index+1, 
    2) Optimized : Binary Search
        - while low<high:
            nums[mid] > mid+1
                # left partition has missing element
                high = mid
            else:
                # right partition has missing element
                low = mid+1
        - Return low+1 
Time Complexity : O(log N) 
Space Complexity : O(1)

Follow up :
    - What if instead of nums having {1,n} has {k, k+n}
        - eg: [11,12,13,15,16,17,18], Output = 14 
    - Answer:
        - offset : nums[0] = k
        - check nums[mid] > mid+1 + offset
        - return offset + (low+1)
    - Edge Case:
        - [12] 
'''

class Solution:
    def find_missing_element(self,nums):
        low = 0
        high = len(nums)-1

        while low<high:
            mid = low + (high-low)//2 # int overflow

            if nums[mid]>mid+1:
                # left partition
                high = mid
            else:
                # right partition
                low = mid+1
        
        return low+1 
    
# Test cases
mySol = Solution()
nums1 = [1,2,3,5,6,7,8]
print("Output 1",mySol.find_missing_element(nums1)) # 4

nums2 = [1,2,3,4,5,6,8] # size =7
print("Output 2", mySol.find_missing_element(nums2)) # 7

nums3 = [2] # size = 1
print("Output 3", mySol.find_missing_element(nums3)) # 1
