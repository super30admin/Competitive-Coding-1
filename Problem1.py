# Time Complexity : O(logN) for binary search
# Space Complexity : O(1) as no extra space
# Did this code successfully run on Leetcode : I did not find this exact question on LC
# Any problem you faced while coding this : It took some time to understand the logic of 
# how to exactly apply binary search here

def binsearch(arr) -> int:
    lo = 0
    hi = len(arr) - 1
    while (hi - lo) > 1:
        mid = (lo + hi) // 2
        if (arr[lo] - lo) == (arr[mid] - mid):
            lo = mid
        elif (arr[hi] - hi) == (arr[mid] - mid):
            hi = mid
    return arr[lo] + 1


a = [1, 2, 3, 5, 6, 7]
    
print('The missing number is '+ str(binsearch(a)))