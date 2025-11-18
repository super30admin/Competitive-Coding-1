"""
We check if the difference between the number and the index is not 1, then we return the shift the right pointer and left pointer accordingly to the condition
the SC for this is O(1) ad tc is o(logn) due to binary search
"""


# #find missing integer in array of 1 to n

def solution(arr):
    left = 0
    right = len(arr) - 1

    while right - left > 1:
        mid = left + (right - left) // 2
        if arr[left] - left != arr[mid] - mid:
            right = mid
        else: 
            left = mid
    return arr[left] + 1 #since answer is gauranteed to be there

arr = [1, 2, 3, 5, 6, 7]
print(solution(arr))

