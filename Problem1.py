def solution(nums):
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = low + (high - low) // 2
        prevval = nums[mid] - 1
        nextval = nums[mid] + 1 
        if mid == 0 or nums[mid - 1] < prevval: 
            return prevval
        elif mid != 0 and nums[mid + 1] > nextval:
            return nextval
        elif nums[mid] == mid + 1:
            low = mid + 1
        else:
            high = mid - 1
    return -1
print(solution([2,3]))