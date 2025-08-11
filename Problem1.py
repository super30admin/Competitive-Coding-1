'''
Missing in a Sorted Array of Natural Numbers
Last Updated : 21 Jul, 2025
Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n. There are no duplicates in the array. One of the integers is missing in the array. Find the missing integer. 
Examples: 

Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
Output : 5
Explanation: The missing integer in the above array is 5 

Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
Output : 7
Explanation: The missing integer in the above array is 7 
'''

def missingNumber(arr):
    n = len(arr)
    
    # Extreme cases
    if arr[0] != 1:
        return 1
    if arr[n - 1] != n + 1:
        return n + 1
        
    # Implementing binary search
    lo, hi = 0, n - 1
    while hi - lo > 1:
        mid = (lo + hi) // 2
        if arr[lo] - lo != arr[mid] - mid:
            hi = mid
        elif arr[hi] - hi != arr[mid] - mid:
            lo = mid
    return arr[lo] + 1

if __name__ == "__main__":
    arr = [1, 2, 3, 4, 6, 7, 8]
    print(missingNumber(arr))