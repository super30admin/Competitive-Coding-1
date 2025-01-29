# Problem : Find missing number in sorted array
# The array should have at least 2 elements as average of those elements will be the missing integer.
# We will store the difference of the middle, first and last element with its index as it will help
# to determine whether the missing integer is on the left side / right side of the array following 
# Binary Search
# If the mid difference is not equal to the first element difference the we search in the left side of
# the array else the right part of the array.
# Finally we will return the average as it will be the missing integer. Since array is sorted and from
# 1 to n, the integers will have a constant difference evaluating with the element and its index. 

def missing_element(nums):
    low = 0
    high = len(nums) - 1
    if (nums == None or len(nums)) == 0: return -1 #Edge case if array has one / no element
    while (high - low >= 2): 
    #if array has 2 elements then we will take the average and return the missing number
        mid = low + (high - low) // 2
        #Store the diff of mid element with index
        mid_index_diff = nums[mid] - mid
        #Store the diff of first element with index
        low_index_diff = nums[low] - low
        #Store the diff of last element with index
        high_index_diff = nums[high] - high
        # If mid difference is not equal to low diff, the missing integer is on the left side of the 
        # array
        if mid_index_diff != low_index_diff:
            high = mid
        else:
        # If mid difference is not equal to high diff, the missing integer is on the right side of the 
        # array    
            low = mid    
    # Return the average as it will be the missing element
    return (nums[low] + nums[high]) / 2
 
nums = [1, 3, 4, 5, 6, 7, 8]
result = missing_element(nums)
print(result)
