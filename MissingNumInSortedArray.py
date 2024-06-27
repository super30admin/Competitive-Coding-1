#To find the missing number in a sorted array of unique integers using binary search, we initialize low and high pointers to the start and end of the array, respectively. Within a loop, we compute the middle index mid and check if the element at mid matches mid. If they are equal, the missing number must be to the right, so we update low to mid + 1; otherwise, it's to the left, so high becomes mid - 1. This continues until low exceeds high, at which point low indicates the smallest index where the index does not match the element, revealing the missing number. This approach operates in O(log n) time complexity due to binary search and O(1) space complexity, using minimal extra memory.


def find_missing_number(nums):
    low, high = 0, len(nums) - 1
    
    while low <= high:
        mid = (low + high) // 2
        
        # If the middle index matches the element value, missing number is on the right side
        if nums[mid] == mid:
            low = mid + 1
        else:
            high = mid - 1
    
    # The missing number is found when low index exceeds high
    return low

nums = [0, 1, 2, 4, 5, 6, 7]
missing_number = find_missing_number(nums)
print("The missing number is:", missing_number)