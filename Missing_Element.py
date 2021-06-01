# Time Complexity: O(log n)
# Space Complexity: O(1)

class MissingElement:

    def getMissingElement(self, arr):
        low = 0
        high = len(arr) - 1
        # After defining low and high we will change the low
        # and high position till the difference between them is not 1
        while (high - low) != 1:
            mid = low + (high - low) / 2

            if (mid + arr[0]) == arr[mid]:
                low = mid
            else:
                high = mid

        return arr[high] - 1

trial = MissingElement()
arr = [2, 3, 5, 6, 7]
print(trial.getMissingElement(arr))


