# Findind missing element in a sorted array from 1 to n

# Time-complexity: O(log(n))
# Space-complexity: O(1)

def missing(nums):
    # if len(nums) == 0: return -1
    # if len(nums) == 1: return -1

    left, right = 0, len(nums) - 1
    while((right-left) != 1): # Until they are not close to each other
        mid = (left+right)//2
        # Not consistent
        if nums[mid] - mid != nums[left] - left: 
            right = mid
        # Consistent
        else:
            left = mid
    return nums[left] + 1 if nums[left]+1 != nums[right] else -1 # Return -1 if nothing is missing


ans = missing([1,2,4,5])
print(ans)