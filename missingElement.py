


def getMissingElement(array):

    low = 0 
    high =  len(array) -1

    while (high - low ) >=2 :
        mid = (low + high) //2
        lowDifference = (array[low] - low) 
        highDifference = (array[high] - high) 
        midDifference = (array[mid] - mid) 

        if lowDifference != midDifference:
            high = mid -1
        elif highDifference != midDifference:
            low = mid + 1
        
    return (array[low] + array[high] )//2

print(getMissingElement([1,3,4,5,7]))