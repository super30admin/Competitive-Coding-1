# program to find the missing element in a sorted array
# Explanation: I used binary search to compare the middle element with the next expected element, since we know the array is sorted
# Time Complexcity: O(log n)
# Space Complexcity: O(1)

arr = [1,2,3,5,6,7,8]

def find_missing_element(arr):
    
    low = 0
    high = len(arr) - 1
    
    while(low <= high):
        mid = low + (high - low)//2
        
        if(arr[mid] != mid + 1):
            high = mid - 1
        
        else:
            low = mid + 1
    
    return low + 1

missing_element = find_missing_element(arr)
print("The missing element is ", missing_element)
    
