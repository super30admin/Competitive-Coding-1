# Time : O(logN)
# Space : O(1)

def find_missing_number(nums):
    l,r = 0, len(nums) - 1
 
    expected_difference = nums[0]

    while l <= r:
        mid = l + (r-l)//2 

        difference = abs(mid - nums[mid])

        if difference > expected_difference:
            # The missing number lies to the left of mid
            r = mid - 1
        else:
            # The missing number lies to the right of mid
            l = mid + 1
    
    return nums[r] + 1