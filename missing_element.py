# Time Complexity: O(log n)
# Space Complexity: O(1)

class Main:
    def find_missing_number(nums):
        if not nums:
            return -1

        low = 0
        high = len(nums) - 1
        # Perform binary search to find the missing number
        while low <= high:
            mid = low + (high - low) // 2
            # If nums[mid] is equal to mid + 1, the missing number is to the right
            if nums[mid] == mid + 1:
                low = mid + 1
            else:
                # Otherwise, the missing number is to the left
                high = mid - 1
        # Return the missing number
        return low + 1
