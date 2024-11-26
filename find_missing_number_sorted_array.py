# find_minimum_rotated_sorted_array
# time complexity: O(logN)
# space complexity: O(1)
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : Tried one approach didn't work for some cases. Is there any
# other way to do this problem ? Any other approach?


def find_minimum(nums):
    left = 0
    right = len(nums) - 1
    while right - left >= 2:
        mid = (left + right) // 2
        mid_diff = nums[mid] - mid
        left_diff = nums[left] - left
        right_diff = nums[right] - right
        if mid_diff != left_diff:
            right = mid
        else:
            left = mid

    return (nums[left] + nums[right]) // 2


if __name__ == "__main__":
    nums1 = [3, 4, 6]  # output 5
    missing_num1 = find_minimum(nums1)
    nums2 = [1, 2, 3, 4, 5, 6, 8, 9]
    missing_num2 = find_minimum(nums2)
    print("The missing number for the array" + str(nums1) + "\n" + "=" + str(missing_num1))
    print("The missing number for the array" + str(nums2) + "\n" + "=" + str(missing_num2))
