def find_missing_number(arr: list) -> int:
    """
        // Time Complexity: O(logn)
        // Space Complexity: O(1)
        // Did this code successfully run on Leetcode :
            N/A
        // Any problem you faced while coding this :
            Done as per Jaspinder's solution.
            My solution was working only for values
            starting from 1
    """
    if not arr:
        return -1
    low = 0
    high = len(arr) - 1
    # until we have two elements
    # the average of two numbers is the missing number
    # the low and high index should be next to each other
    while (high - low) >= 2:
        mid = (low + high) // 2
        # if the number is missing in the left half
        # the difference will be 1 between the mid
        # and low values else zero when the left
        # half is sorted
        if (arr[mid] - mid) != (arr[low] - low):
            high = mid
        else:
            # else the number is missing in the right half
            low = mid
    return (arr[low] + arr[high]) // 2

    # Old solution works only when the array starts
    # from 1
    # if arr[mid + 1] - arr[mid] == 2:
    #     return arr[mid] + 1
    # if arr[mid] == mid + 1:
    #     low = mid
    # elif arr[mid] != mid + 1:
    #     high = mid


if __name__ == '__main__':
    # print(find_missing([1, 3, 4, 5, 6, 7, 8, 9, 10]))
    print(find_missing_number([1, 2, 3, 5, 6]))
    print(find_missing_number([1, 2, 3, 4, 5, 7]))
    print(find_missing_number([1, 2, 3, 4, 5, 6, 7, 9]))
    print(find_missing_number([1, 2, 3, 4, 5, 6, 7, 9]))
    print(find_missing_number([3, 4, 5, 6, 7, 9]))
    print(find_missing_number([6, 8]))
    print(find_missing_number([2, 4]))
