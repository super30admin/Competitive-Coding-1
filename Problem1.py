'''
Time Complexity: O(log(n)) 
Space Complexity: O(1)
Run on Leetcode: YES
'''
def solution(arr):
    low = 0
    high = len(arr) - 1
    if arr[high] - 1 == high:
        return high + 2
    while low <= high:
        mid = low + (high - low)//2
        if arr[mid - 1] + 1 != arr[mid]:
            return arr[mid] - 1
        elif arr[mid - 1] == mid:
            low = mid + 1
        else:
            high = mid - 1