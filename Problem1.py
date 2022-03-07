# Find the Missing element in array.
# Array always start from 1 and have a different of 1 between each element
# Array is sorted


# Time Complexity: O(logn)


#arr = [1,3,4,5,6,7,8,9]

start = 0
end = len(arr) -1

while(start<=end):
    
    mid = (start + end) // 2
    
    if arr[end] - arr[mid] == end - mid: #7-4 == 5-2  4 -1 == 2-0
        if arr[mid] - arr[mid -1] > 1:
            print arr[mid] - 1
            break
        end = mid - 1
    else:
         if arr[mid -1] - arr[mid] > 1:
            print arr[mid] - 1
            break
         start = mid + 1