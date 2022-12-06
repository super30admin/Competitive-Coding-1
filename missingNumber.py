def missingNumber(givenList):

    if len(givenList) == 0:
        return -1
    low = 0 
    high = len(givenList)-1

    while low<= high:

        mid = low +(high-low)//2

        if givenList[mid] - mid > 1:
            if givenList[mid-1] - (mid-1) == 1:
                return givenList[mid-1]+1            
            else:
                high = mid-1           
        else:
            low = mid+1

    return -1

print(missingNumber([1,2,3,4,5,6,8,9])) 
