# find the missing element sorted array
# No duplicates

def find_missing_element(arr):
    if not arr:
        return None
    '''
    perform general binary search on the elements. Find out the index value of mid and low
    Find out the difference between indexes vs array values.
    Perform the same on high and mid values, and hence return the element average of mid element value and low/high value which will return the missing element
    '''
    low = 0
    high = len(arr)

    while low<high:
        mid = (low+high)>>1
        if abs(arr[mid]-arr[mid-1])==2:
            return (arr[mid]+arr[mid-1])//2
        elif abs(arr[mid]-arr[mid+1])==2:
            return (arr[mid]-arr[mid+1])//2

        if abs(mid-low) < abs(arr[mid]-arr[low]):
            high = mid-1
        else:
            low = mid+1


    return None

#driver code
print(find_missing_element([1,2,4,5]))
print(find_missing_element([1,2,3,4,5,7]))
print(find_missing_element([1,3,4,5,6,7]))
print(find_missing_element([]))

'''
time complexity - O(logn) n - number of elements in an array
Space complexity - O(1) 
'''