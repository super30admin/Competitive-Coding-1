# find missing number in a sorted array
# time complexity : 0 (logn)
# space compexity : 0(1)


def find_missing(nums):
    n = len(nums)
    if n == 0:
        return -1

    low = 0
    high = n - 1

    while high > low +1 :
        mid = int(low + (high - low)/2)

        if (nums[mid] - mid) != (nums[low] - low):
            high = mid 

        elif (nums[mid] - mid )!=(nums[high] - high):
            low = mid
        
    return nums[low] +1 
#nums = [1,3]
#nums = [1,2,3,5,6]
#nums = [1,2,3,4,6,7]
nums = [1,3,4,5]
print(find_missing(nums))
