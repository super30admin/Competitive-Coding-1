# Ques: Given an array of numbers from 1,2,3...n, find the missing number in this array.
# No duplicates, always sorted, increasing order

# The following takes O(log n) time and O(1) space
def search(nums):
    low = 0
    high= len(nums)-1

    while low<=high:
        
        mid = low+(high-low)//2

        if mid == nums[mid]-1:
            low = mid+1
        else:
            high = mid-1

    return low+1

# Test code
nums= [1,2,3,4,5,6,8]
print(search(nums))
