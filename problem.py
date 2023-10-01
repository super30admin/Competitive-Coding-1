# TC: O(logn)
# SC: no extra space used, O(1)

def missingElement(nums):
    low = 0
    high = len(nums) - 1

    while low <= high:
        mid = (low + high) // 2

        # if there is only one element in the array, nothing is missing, return -1
        if len(nums) == 1:
            return -1

        # check if right neighbor is just one up of mid element. If not, that is the missing element
        if (nums[mid + 1] - nums[mid] != 1) or (mid == 0 and nums[mid + 1] - nums[mid] != 1):
            return nums[mid] + 1

        # check if left neighbor is just one short of mid element, If not that is the missing element
        elif nums[mid] - nums[mid-1] != 1:
            return nums[mid] - 1

        # if left & right neighbors of mid are correct, identify which side to discard for BS.
        # if high-mid idx != element at high - element at mid that means some element is missing on right side. Thus, discard left
        elif (high - mid) != (nums[high] - nums[mid]):
            low = mid + 1

        # if mid-low idx != element at mid - element at mid that means some element is missing on left side. Thus, discard right
        elif (mid - low) != (nums[mid] - nums[low]):
            high = mid - 1

        else:
            return -1  # if both sides do not have any missing element


nums = [1, 3, 4, 5, 7]
print(missingElement(nums))
