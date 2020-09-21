# O(log(n)) time and O(1) space where n is length of array
def missingNumber(array):
    left = 0
    right = len(array) - 1
    while left < right:
        mid = (left + right) // 2
        if array[mid] - mid != 1:
            right = mid
        else:
            left = mid + 1
    return left + 1

print(missingNumber([1,3,4,5,6,7,8]))