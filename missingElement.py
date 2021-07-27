
array = [5,6,8]
def missingElement(array):


    low = 0
    high = len(array) - 1

    while((high - low)>=2 ):
        mid = low + (high - low)//2
        midIndex = array[mid] - mid
        highIndex = array[high] - high
        lowIndex = array[low] - low
        if(midIndex!=lowIndex):
            high = mid
        elif(midIndex!=highIndex):
            low = mid
    return (array[high] + array[low]) //2

print(missingElement(array))
        

    


