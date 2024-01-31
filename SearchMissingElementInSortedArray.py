# Time complexity: o(log(n))
# Space complexity: o(1)

# def searchMissingElementInSortedArray(nums: list):
#     low = 0
#     high = len(nums) - 1

#     while high - low > 1:
#         mid = low + (high - low)//2

#         if nums[mid] - mid == nums[low] - low:
#             low = mid
#         else:
#             high = mid

#     return nums[low] + 1


def searchMissingElementInSortedArray(nums: list):
    low = 0
    high = len(nums) - 1

    while low <= high:
        mid = low + (high - low)//2

        if nums[mid] - mid > 1:
            high = mid - 1
        else:
            low = mid + 1

    return nums[mid] - 1


arr = [1, 2, 4, 5, 6, 7, 8]
print(searchMissingElementInSortedArray(arr))
