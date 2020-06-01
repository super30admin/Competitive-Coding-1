#Time Complexity - O(logn)
#Space Complexity - O(1)
def getMissingNumber(nums):
    low = 0
    high = len(nums) - 1
    while low < high:
        mid = low + (high-low)//2
        if nums[mid] - mid != 1:
            high = mid
        else:
            low = mid + 1
    print(low+1)