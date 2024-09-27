# Time Complexity : O(lgN)
# Space Complexity : O(1)


def missingVal(nums):
    """
    O(N) -LS
    """
    if not nums:
        return -1
    left = 0
    right = len(nums)-1
    # while left<=right:
    #     mid = left + (right-left)//2
    #     #if the element isn't at is supposed index
    #     if nums[mid] != mid+1:
    #         return mid+1
    #     elif nums[mid] - nums[left] != mid - left: #there is a missing element in the left side
    #         right = mid - 1
    #     else: #theres a missing element on the right side
    #         left = mid + 1
    while left < right:
        mid = left + (right-left)//2
        if right - left + 1 == 2:
            return nums[left]+1
        if nums[right] - nums[mid] > right - mid:
            left = mid 
        else:
            right = mid
    return nums[left] + 1
    
    """
    #[1 2 3 5 6 7 8]
    3 != 5
    4 = 4
    """


print(missingVal([1,2,3,5,6,7,8]))
print(missingVal([1,2,3,4,6,7,8]))
print(missingVal([1,2,3,4,5,6,7,8,10]))
print(missingVal([1,2,3,4,5,6,8,9,10]))