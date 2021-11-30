def search_missing_element(l):
    """
    1. Perform the binary search
    2. Find the middle element and index of the middle element.
    3. Similarly take the difference between index and low, and index and high
    4. Move the low or high pointers to the side whose difference is not same
    5. Stop the binary search when only two elements will remain i.e difference between low and high is equal to 1

    Time Complexity = O(n)
    Space Complexity = O(1)
    """
    low = 0
    high = len(l) - 1
    while(high - low >=2):
        mid = low + (high - low) // 2
        midIdxDiff = l[mid] - mid
        leftIdxDiff = l[low] - low
        rightIdxDiff = l[high] - high
        if(leftIdxDiff != midIdxDiff):
            high = mid
        else:
            low = mid
    return (l[low] + l[high]) // 2

result = search_missing_element([1,2,3,4,5,7])
print(result)