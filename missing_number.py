def search(arr, size):
    """
    :rtype integer number-Missing number
    :time complexity : O(log(n))
    :space complexity : O(1)
    :logic - if value at particular index minus index number is equal to 1 then surely numbers are continuous 
    """
    low=0
    high=size-1
    #Binary search
    while high>=low:
        mid=(low+high)//2
        # check if in first half value at first index minus index number is not equal to 
        # value at mid index minus mid index number
        if (arr[low]-low) != arr[mid] -mid:
            high=mid
        elif arr[high] - high!= arr[mid] - mid:
            low=mid
        return arr[low]+1

