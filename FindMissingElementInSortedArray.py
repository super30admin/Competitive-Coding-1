# Time Complexity : O(log n)
# Space Complexity : O(1)

def findMissingElement(array):
    low = 0
    high = len(array) - 1
    
    while low+2 <= high:
        mid = low + (high - low)//2

        if (array[low] - low) == (array[mid] - mid):
            low = mid
        else:
            high = mid

    return (array[low] + array[high])//2

print(findMissingElement([1,2,3,5]))