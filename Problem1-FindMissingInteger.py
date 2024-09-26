# Provide an array of n-1 integers in the range of 1 to n with no duplicates in list,
# One of the integers is missing in the list. Write a code to find the missing integer

# Time complexity: O(log(n))
# Space complexity: O(1)
# Approach: while high-low >=2, check if difference between a[low] and low is equal to a[mid] and mid,
# if yes, meaning number is missing on other side and increment low to mid, else decrement high to mid.
# So choosing sublist where difference between index and num is greater than 1, there a number is missing.
# Number missing must be the average of a[low] and a[high].

def findElem(a):
    low = 0
    high = len(a) - 1
    while (high - low >= 2):
        mid = low + (high - low) // 2
        if ((a[low] - low) != (a[mid] - mid)):
            high = mid
        elif ((a[high] - high) != (a[mid] - mid)) :
            low = mid
    return ((a[low] + a[high]) // 2)
    
print(findElem([1,2,3,4,5,6,8]))