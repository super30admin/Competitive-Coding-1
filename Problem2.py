class Solution(object):
    def missingNumber(self, nums):
        """
        Time complexity: O(log n)
        Space complexity: O(1)
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()  # Sort the input list in ascending order

        if nums[0] != 0:  # Check if the first element is not 0
            return 0

        if nums[len(nums) - 1] != len(nums):  # Check if the last element is not n
            return len(nums)

        low = 0
        high = len(nums) - 1
        mid = 0

        while high - low >= 2:  # Perform binary search till difference between high and low is at least 2
            mid = low + (high - low) // 2

            # difference between the middle,low and hig element with its index
            midIdxDiff = nums[mid] - mid
            lowIdxDiff = nums[low] - low
            highIdxDiff = nums[high] - high

            if midIdxDiff != lowIdxDiff:  # If the difference is not equal to their index difference
                high = mid  # Adjust the high index to mid
            elif midIdxDiff != highIdxDiff:  # If the difference between is not equal to their index difference
                low = mid  # Adjust the low index to mid

        # Return the missing number as the average of low and high
        return (nums[low] + nums[high]) // 2
