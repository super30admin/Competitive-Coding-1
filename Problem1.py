#Time complexity = O(logn) since we use binary search to
#halve the search space every time
#space complexity = O(1)
def missingInt(ar):
    beg = 0
    end = len(ar) - 1
    
    while beg < (end- 1) :
        mid = (beg + end) // 2
        #if(ar[beg] - beg > 1)
        
        diff = ar[mid] - mid   #diff of mid element with its index
        
        if (arr[mid - 1] - (mid - 1) != diff):
            end = mid 
        else:  
            beg = mid
   

    return ar[beg] + 1
 
arr = [1,2,3,5,6,7,8]
 
print("Missing element in the array is ", missingInt(arr))