# Time Complexity : O(logn) where n is the number of elements in the list
# Space Complexity : O(1)
# Did this code successfully run on LeetCode :  yes
# Any problem you faced while coding this : no


def findMissingNumberSortedArray(arr: list):
    size = len(arr)
    left = 0
    right = size - 1
    mid = 0

    # we use binary search
    while (right - left) > 1:

        #Computing mid
        mid = (left + right) // 2

        print(arr[left] - left, arr[right] - right, arr[mid] - mid)

        #check differnece of the current left and mid number with its position, since it is sorted we will have to get
        #equal value
        #If not we will make the right to move to mid
        #Same we for mid and right, if not we have to move left to mid
        if (arr[left] - left) != (arr[mid] - mid):
            right = mid
        elif (arr[right] - right) != (arr[mid] - mid):
            left = mid

    return mid + 1


arr = [1, 2, 3, 4, 5, 6, 7, 8]

print(findMissingNumberSortedArray(arr))
