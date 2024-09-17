
"""
https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
Here I compared the indexes and their respective element.
1. Started with the mid element.
2. Choose one side:
    -> if the difference between index and element is 1..keep iterating till the extreme element
    -> If difference is not 1: return the element whose value would be 1 less
        than the current high/low position.(Since loop stops after low==high)

Time Complexity: O(logN)
Space Complexity: O(1)
Any Difficulties while solving: Yes, I was not able to think of this approach
even after given hints from the interviewer.
"""
def search(ar, size):
    low = 0
    high = size - 1

    if ar == None or len(ar) == 0:
        return -1
    while(low<=high):

        mid = (high+low) // 2

        if ar[mid] - mid == 1:
            low = mid + 1
        else:
            high = mid - 1
    return ar[low] - 1


a = [1, 2, 3, 4, 5, 6, 8, 9]
n = len(a)

print("Missing number:", search(a, n))

