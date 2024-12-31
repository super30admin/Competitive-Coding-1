# find the missing element in an array that has a range 1 to n - 1
# space complexity: O(1)
# time complexity - O(log n)
# Approach used is Binary Search

def findMissingElement(nums):
    # binary search on the nums array
    if (len(nums) == 1):
        return -1
    
    low = 0
    n = len(nums) - 1
    high = n
    
    # so the array should be starting with 1 else, 1 itself is missing
    if nums[low] != 1:
        return 1
    
    # checking for the element at the last index
    # if the last element is not as expected, then it is missing
    if nums[n] == n + 1:
        return n + 2
    
    # binary search loop
    while (low <= high):
        # computing mid
        mid = (low + high) // 2
        
        # if the element on the left is not 1 less, then it is missing
        if(nums[mid - 1] != nums[mid] - 1):
            return nums[mid] - 1
        # if the element on the left is not 1 more, then it is missing
        if (nums[mid + 1] != nums[mid] + 1):
            return nums[mid] + 1

        # checking the indices
        # if the index of mid element is 1 less, then it means the missing element does not exist on the left side    
        if (mid == nums[mid] - 1):
            # left side does not have the missing element
            # move to right
            low = mid + 1
        else:
            # move the list to left
            high = mid - 1
            
    
    return -1
            
    
a = [1, 2, 3, 4, 5]
print(findMissingElement(a))       
            
    