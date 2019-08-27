def FindElement(arr):
    low = 0
    high = len(arr)-1
    mid = 0
    while (high-low >= 2):
        mid = low + (high-low)/2
        midIndex = arr[mid] - mid
        lowIndex = arr[low] - low
        highIndex = arr[high] - high
        if midIndex != lowIndex:
            high = mid
        elif midIndex != highIndex:
            low = mid
    return (arr[low]+arr[high])/2

arr = [3,5,6,7,8,9]
print(FindElement(arr))
