class Solution:
    def missingNumber(self, nums):
        nums.sort()
        low = 0
        high = len(nums) - 1

        while (low < high):
            med = low + (high - low) // 2
            diffMed = nums[med] - med
            diffLow = nums[low] - low

            if(low == high - 1):
                break

            if(diffLow <  diffMed):
                high = med

            else:
                low = med


        return (nums[low] + nums[high]) // 2
    


nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
result = Solution()
output = result.missingNumber(nums)
print(output)


            

            
           
