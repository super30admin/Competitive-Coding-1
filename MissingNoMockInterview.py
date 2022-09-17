nums = [1,2,4,5,6,7,8]


def binarySearchMissingNo(nums):
    
    left = 0
    right = len(nums) - 1
    
    if len(nums) == 1:
        if nums[0] == 1:
            return 2
        else:
            return 1
        
    if nums[-1] == len(nums):
        return len(nums) + 1
    
    while left <= right:
        mid = (left+right)//2
        
        if nums[mid] == mid + 1:
            left = mid + 1
        elif nums[mid] != mid + 1:
            right  = mid - 1
            if mid != 0:
                if nums[mid-1] == mid:
                    return (mid + 1)
                
print(binarySearchMissingNo(nums))

# Time Complexity: O(log(n)) because I user Binary search
# Space Complexity: O(1) because I didn't use any extra space
        
