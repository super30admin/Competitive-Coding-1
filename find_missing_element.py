"""Given array contains values in the range of 1-n in sorted manner, but one element is missing.
We can identify a pattern here that, before missing number, the delta between index and value will
be 1, but after missing number the delta will be >1."""

class Solution:
    def find_missing_element(self, nums):
        size = len(nums)-1
        low, high=0, size

        while(low<=high):
            mid = low+(high-low)//2
            if nums[mid]-nums[mid-1]>1: # Compare mid and left neighbour
                return nums[mid] -1 
            elif nums[mid+1]-nums[mid]>1: # Compare mid and right neighbour
                return nums[mid]+1
            
            if nums[mid]-mid ==1:
                low = mid+1
            else:
                high =mid-1
        return 1234
    
if __name__=="__main__":
    nums = [1,2,3,4,5,6,7,8,9,10,11,13]
    sol = Solution()
    print(sol.find_missing_element(nums))