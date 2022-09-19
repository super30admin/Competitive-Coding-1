#Time Complexity: O(logn)
#Space Complexity: O(1)

def search(nums):
    low = 0
    high = len(nums) - 1
    while low < high:
        mid = (low + high) // 2
        if (nums[low] - low) != (nums[mid] - mid):
            high = mid - 1
        elif (nums[high] - high) != (nums[mid] - mid):
            low = mid + 1
    return nums[low] + 1
    

nums = [1,2,3,5,6,7,8,9,10]
missing_index = search(nums)
print("Missing Index is: ",missing_index)

