# TC = O(logn)
# SC = O(1)
# Using binary search, key is to monitor index and element value. If the the difference between index and element is equal to 1- it means there has been no break uptill then. If it is more than 1(~2) there is a missing number on or before this index. We need to narrow down search up untill we have to low and high pointers next to each other. The average of them or nums[low] + 1 gives the missing number.
def findMissing(nums):
    if nums[0] != 1:
        return 1
    low, high = 0, len(nums)-1
    while low < high:
        mid = low + (high - low)//2
        # found condition
        if high - low == 1:
            return nums[low] + 1
        # no break untill now, change low pointer to mid
        elif nums[mid] - mid == 1:
            low = mid
        else:
            high = mid
    
nums = [1,2,3,5,7]
print(findMissing(nums))
        
