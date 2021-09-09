# Find missing number in a sorted array

# // Time Complexity : O(lg n) where n is the number of elements in the array 
# // Space Complexity : O(1)  
# // Did this code successfully run on Leetcode : haven't tried
# // Any problem you faced while coding this : finding how to constraint the search space

def search(low,high):

    while low <= high:
        mid = low + (high-low)//2
        if mid + 1 != arr[mid] and (mid == 0 or mid == arr[mid-1]):
            return mid + 1
        elif mid + 1 == arr[mid]: # everything good so far - go right
            low = mid + 1
        else:
            # go left
            high = mid - 1
    return -1



if __name__=="__main__":
    arr = [1,2,3,4,5,6,8]
    # arr = [1,2,4,5,6,7,8]
    # arr = [1,2,3,5,6,7,8]
    print(search(0,len(arr)-1))