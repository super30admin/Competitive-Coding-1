# My approach o(logn) 
def missing_number(nums):
    l, h = 0, len(nums)-1
    if nums[0] != 1:
        return 1
    if h!=l and nums[h]!=h+1 and nums[h] - nums[h-1] == 2:
        return nums[h-1] +1 
    while l <= h:
        mid = l + (h-l)//2
        if (mid+1) != nums[mid]:
            if (mid!= 0 and (nums[mid]-nums[mid-1]) == 2):
                return nums[mid-1]+1
            elif (mid != len(nums)-1 and nums[mid+1] - nums[mid] == 2):
                return nums[mid] +1
            else:
                h = mid-1
        else:
            l = mid+1
    return -1

# approach 2 
# def missing_number(arr):
#     n = len(arr)
    
#     # Extreme cases
#     if arr[0] != 1:
#         return 1
#     if arr[n - 1] != (n + 1):
#         return n + 1
        
#     # implementing binary search
#     lo, hi = 0, n - 1
#     while  hi-lo > 1:
#         mid = (lo + hi) // 2
#         if (arr[lo] - lo) != (arr[mid] - mid):
#             hi = mid
#         elif (arr[hi] - hi) != (arr[mid] - mid):
#             lo = mid
#     return (arr[lo] + 1)

arr = [1, 2, 3, 4, 6, 7, 8]
print(missing_number(arr))