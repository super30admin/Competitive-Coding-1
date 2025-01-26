"""
Find missing number from a sorted array

Binary search approach
TC - O(log n)
SC - O(1)
"""
arr = [1, 2, 3, 4, 5, 6, 8]


def missingNumber(nums):
    # base case
    if nums is None or len(nums) == 0: return -1

    n = len(nums)
    low = 0
    high = n - 1

    while low <= high:
        mid = low + (high - low) // 2

        if nums[mid] == mid + 1:
            # left is correct. element missing on right side
            low = mid + 1
        else:
            if nums[mid - 1] == mid:
                return mid + 1
            else:
                high = mid - 1


if __name__ == '__main__':
    print(missingNumber(arr))
