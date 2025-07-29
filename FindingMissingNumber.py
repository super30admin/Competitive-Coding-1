class MissingNumberFinder:
    def __init__(self, arr):
        # Initialize the class with the input array
        self.arr = arr
        self.size = len(arr)

    def find_missing_number(self):
        # Set initial low and high pointers for binary search
        low = 0
        high = self.size - 1

        # Continue the loop until there are at least 2 elements between low and high
        while high - low >= 2:
            # Calculate the middle index
            mid = low + (high - low) // 2

            # Calculate the difference between the value and index at mid, low, and high
            # In a perfect sequence, arr[i] - i should be constant
            mid_diff = self.arr[mid] - mid
            low_diff = self.arr[low] - low
            high_diff = self.arr[high] - high

            # If the difference at mid and low don't match,
            # then the missing number is in the left half
            if mid_diff != low_diff:
                high = mid
            # Otherwise, it's in the right half
            elif mid_diff != high_diff:
                low = mid

        # After the loop, the missing number lies between arr[low] and arr[high]
        # Since the array is of consecutive numbers with one missing,
        # the missing number is the average of arr[low] and arr[high]
        return (self.arr[low] + self.arr[high]) // 2

if __name__ == "__main__":
    # A sorted array with one missing number (should be 7)
    arr = [1, 2, 3, 4, 5, 6, 8]

    # Create an instance of the finder class
    finder = MissingNumberFinder(arr)

    # Find and print the missing number
    missing_number = finder.find_missing_number()
    print("Missing number:", missing_number)
