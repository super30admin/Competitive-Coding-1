"""
TC ->O(log N)
SC ->O(1)

Logic:
Compute the mid-index and check if the element at mid greater than the value mid+1.
If yes, we can ignore the right side and move to left half.
If no, move to the right half.
Eventually the l and h pointers will cross and the value we need is l+1
The logic is based on the fact that the input array contain values from 1 to n-1 and no duplicates
"""


def find_missing_element(arr):
    l = 0
    h = len(arr) - 1

    while l <= h:
        mid = l + (h - l) // 2
        if arr[mid] > mid + 1:
            h = mid - 1
        elif arr[mid] <= mid + 1:
            l = mid + 1
    return l + 1


def run_tests():
    test_cases = [
        ([1, 2, 3, 4, 5, 7], 6),  # Missing in middle
        ([1, 2, 3, 5], 4),  # Missing in middle
        ([1, 3, 4, 5, 6], 2),  # Missing near start
        ([2, 3, 4, 5, 6], 1),  # Missing at start
        ([1, 2, 3, 4, 5], 6),  # Missing at end
    ]

    for i, (arr, expected) in enumerate(test_cases):
        result = find_missing_element(arr)
        assert result == expected, f"Test case {i + 1} failed: expected {expected}, got {result}"
        print(f"Test case {i + 1} passed ✅")


if __name__ == '__main__':
    run_tests()
