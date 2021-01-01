# Created by Aashish Adhikari at 11:03 AM 12/31/2020
'''
Time Complexity: Since a binary search, O(logn)
Space Complexity: O(1)


'''


def search(arr, size):
    left = 0
    right = size-1
    while left <= right:

        mid = left + (right-left)//2

        if arr[mid] == mid + 1:
            if arr[mid] + 1 < arr[mid+1]:
                return arr[mid] + 1
            else:
                left = mid + 1
        else:
            right = mid -1




# Driver Code
a = [1, 2, 3, 4, 5, 6, 7, 8, 10]
n = len(a)

print("Missing number:", search(a, n))