'''
T.C: O(logn)
S.C: O(1)

Intution: Difference between the index and the value is greater than 1 if they have been changed in any half using binary search
'''
def find_missing(nums, arr_len):
    if len(nums) == arr_len:
        return -1
    num_len = arr_len - 2
    if not num_len:
        return -1
    
    start, end = 0, num_len - 1
    
    while start <= end:
        mid = start + (end - start) // 2
        
        if not (mid == 0 or (nums[mid] - nums[mid - 1] == 1)):
            if nums[mid] - mid != 1:
                return nums[mid - 1] + 1
            else:
                return nums[mid] - 1
        elif not (mid == num_len - 1 or (nums[mid + 1] - nums[mid]) == 1):
            if nums[mid] - mid != 1:
                return nums[mid - 1] + 1
            else:
                return nums[mid] + 1
        
        if (nums[start] - start) or (nums[mid] - mid) != 1:
            end = mid - 1
        elif (nums[end] - end) != 1:
            start = mid + 1
    
    return nums[num_len] + 1

print(find_missing([1,2,4,5,6,7], 7))
print(find_missing([1,2,3,5,6,7], 7))
print(find_missing([1,2,3,4,5],5))