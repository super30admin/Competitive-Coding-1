#Time: O(logn)
# Space: O(1)
# did the code run? yes
# since the given is sorted, using binary search find the two indices where the number was missed.
# return the missing number

def find_missing_number(arr):
    left, right = 0, len(arr) - 1 #1,2,4,5,6
    while left + 1 < right:
        mid = left + (right - left) // 2
        if arr[mid] - mid == 1:
            left = mid
        else:
            right = mid
    if arr[left]-left==1:
        return arr[right]-1
    else:
        return arr[left]-1

arr = [1, 2, 4, 5, 6, 7, 8, 9]
missing_number = find_missing_number(arr)
print("Missing number is:", missing_number)