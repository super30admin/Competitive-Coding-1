# Time Complexity : O(logN) Binary Search
# Space Complexity : O(1) no extra memory allocated, only constant variables are used


def getMissingValue(nums):
    low, high = 0, len(nums)-1
    while(high-low>= 2):
        mid = low + (high-low)//2
        if nums[mid]-mid != nums[low]-low:
            high = mid
        else:
            low = mid
    return (nums[high]+ nums[low])//2




nums=[1,2,3,4,5,6,7,9]
print(getMissingValue(nums))