'''
Time Complexity-->
O(logn)

Space Compelxity -->
O(1) constant time

Approach -->
check the length of the array from the middle element from left and right if any mismatch go towars that direction

'''


def missingNumber(nums, l, r):
    while l<r:
        mid=(l+r)//2
        val = nums[mid]
        if nums[mid-1]!=val-1:
            return val-1
        elif nums[mid+1]!=val+1:
            return val+1

        left_len = (mid-l)+1
        right_len = (r-mid)+1
        actual_left = (nums[mid]-nums[l])+1
        actual_right = (nums[r]-nums[mid])+1

        #left side
        if left_len!=actual_left:
            r = mid-1
        else:
            l = mid+1
    # val = nums[l]
    # if nums[l-1]!=val-1:
    #     return val-1
    # else:
    #     return val+1








    
    
    
nums = [1,3,4,5,6,7,8,9]
val = missingNumber(nums, 0, len(nums)-1)
print(val)




