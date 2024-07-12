# find missing number when array is sorted   
#Time Complexity O(logN)
# Space complexity O(1)
def findMissingNumber(arr):
    start = 0
    end = len(arr)-1
    while start <= end :
        mid = start +(end - start)//2
        if arr[mid] == mid+1:
            start = mid+1
        else:
            end = mid-1
    return start +1
# Test the function
arr = [1, 2, 3, 4, 5, 7, 8, 9, 10]
missing_number = findMissingNumber(arr)
print(f"The missing number is: {missing_number}")



# with variation. now numbers are not sorted
# they are in random position between 1 to n and one number missing then find the number
# #Time Complexity O(N)
# Space complexity O(1)
def findMissingNumber(arr):
    n = len(arr)+1 #(if number is not missing )
    n_sum = n*(n+1)//2 #(sum of all n natural numbers)
    arr_sum = sum(arr)
    return n_sum - arr_sum
arr = [1, 7, 3, 4, 5, 8, 2, 9, 10] # 6 is missing
missing_number = findMissingNumber(arr)
print(f"The missing number is: {missing_number}")
