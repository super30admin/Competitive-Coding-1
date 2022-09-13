def findmissingnumber(arr):
    
    low = 0
    high = len(arr) - 1

    while(low <= high):
        mid = low + (high - low) // 2
        lowvalue = arr[low] - low
        midvalue = arr[mid] - mid
        highvalue = arr[high] - high

        if(lowvalue != midvalue or midvalue != highvalue):
            if (lowvalue == midvalue):
                low = mid + 1
            else:
                high = mid - 1
        
        if(lowvalue == midvalue == highvalue):
            if(low == mid == high):
                return arr[high] - 1 
            else:
                return arr[low] - 1
        
arr = [1,2,3,4,5,6,8]
print(findmissingnumber(arr))
