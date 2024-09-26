def missingElement(array):
    low = 0
    high = len(array) - 1

    while (low + 1 < high):
        middle = (low + high) // 2

        if(array[middle] == middle + 1):
            low = middle
        else: 
            high = middle
        
    return array[low] + 1

print(missingElement([1,2,3,5,6,7]))