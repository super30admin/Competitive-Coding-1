# Time Complexity :O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :No
# Any problem you faced while coding this :No


# Your code here along with comments explaining your approach
#saw the diff between the index and val is constant or not. if not then the number is missing

def missingElement(nums):
    low = 0
    high = len(nums)-1
    while high-low >= 2:
        mid = (low + high)//2
        if (mid - nums[mid] != low - nums[low]):
            high = mid 
        else:
            low = mid
    return (nums[low] + nums[high])/2    
print(missingElement([1,2,3,4,5,7,8]))