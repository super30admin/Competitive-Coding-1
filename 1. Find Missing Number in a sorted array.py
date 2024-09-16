# Missing element in a sorted array
# Time Complexity = O(logn) as we're using Binary Search to find the missing element
# Space Complexity = O(1) as we're not using any extra space
# The idea is to compare the difference between the element and its index and based on that, we have to reduce our search space.

def missing_number_bs(arr, size):
    low = 0
    high = size-1

    while (high - low >= 2):
        mid = low + (high-low)//2
        midIdxDiff = arr[mid] - mid
        lowIdxDiff = arr[low] - low
        highIdxDiff = arr[high] - high

        if midIdxDiff != lowIdxDiff:
            high = mid
        elif midIdxDiff != highIdxDiff:
            low = mid
    return (arr[low]+ arr[high]) //2


arr = [1,2,3,4,5,7,8]
size = len(arr)
arr1 = [5,6,8,9,10]
size1 = len(arr1)

print("Missing Number:", missing_number_bs(arr, size))
print("Missing Number:", missing_number_bs(arr1, size1))