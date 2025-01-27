# Sorted array :- find the missing number of sorted array
# Array = [1,2,3,4,6]

# always starts from 1

# always have a missing number


#  find length and compare with missing number and return 




def search(arr, size):

    low, high = 0, size-1


    while low < high:
       
        mid = (low+high)//2
        print(low,high,mid)
        if (arr[mid] == arr[0]+mid):
            low = mid +1
        else:
            high = mid-1
    return arr[0] +low



arr = [1,2,3,4,6]

print(search(arr,len(arr)))





