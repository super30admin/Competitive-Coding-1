# Time Complexity: O(n log n)
# Space Complexity: O(1)

# Time Complexity: O(nlogn + log n) = O(n log n)
# Space Complexity: O(1)
class Solution:
    def missingNumber(self, nums):
        # sort the elems in nums
        nums.sort()
        l = 0
        h = len(nums) - 1
        
        while h - l >= 2:
            m = l + (h-l) // 2
            midindd = nums[m] - m
            leftindd = nums[l] - l
            rightindd = nums[h] - h
            # if the index-value diff are not same then
            # check which part does not have same diff
            # if mid and left diff are not same
            if midindd != leftindd:
                # update h with m to traverse the left sub-arr
                h = m
            # if mid and right diff are not same
            elif midindd != rightindd:
                # update l with m to traverse the right sub-arr
                l = m
        # return the average of elem at l and h as the missing number
        return (nums[l] + nums[h])//2
if __name__ == '__main__':
    r = Solution()
    print(r.missingNumber([2,1,5,3,6,7,8]))