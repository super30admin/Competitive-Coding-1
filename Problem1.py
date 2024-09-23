#Problem Name: Interview Problem: Find Missing Number in a sorted array

#Logic:
# 1. binary search
# 2. find mid; if left of mid or right of mid not less than or greater than than mid; return the missing number
# 3. if nums[mid] - 1== mid; missing element on the right side, so go to right
# 4. if nums[mid] - 2== mid; missing element on the left side so go to left  

def getMissingNumber(nums):
    low = 0
    high = len(nums)-1

    while(low<=high):
        mid = low + (high-low)//2

        if mid < len(nums) - 1 and nums[mid + 1] - nums[mid] > 1:
            return nums[mid] + 1 
        elif mid > 0 and nums[mid] - nums[mid - 1] > 1:
            return nums[mid] - 1 

        if nums[mid] - 1 == mid:
            low = mid + 1

        elif nums[mid] - 2 == mid:
            high = mid - 1
    return "No Missing Number Found"

# Driver code
arr = [1,2,3, 5,6,7,8,9,10,11]
print("missing_number",getMissingNumber(arr))