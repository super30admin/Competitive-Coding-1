########## Find missing element in sorted array in a range (Asked in Mock Interview) ######


# Brute force solution
# get the min and the max. generate range and check if element exists
# time complexity -> O(n) and space complexity ->O(n)
def find_missing_in_range(nums):
    if not nums:
        return -1
        
    min_element= nums[0]
    max_element= nums[-1]
    
    checker = set()
    
    for i in nums:
        checker.add(i)
    
    for num in range(min_element,max_element+1):
        if num not in checker:
            return num
        
    if min_element > 1:
        return min_element - 1
    else:
        return max_element + 1

print(find_missing_in_range([1]))
print(find_missing_in_range([2, 3, 4, 5, 6, 7, 8, 9]))

# Optimal solution
# perform binary search and for every mid check if the element to the element to the 
# left is not one less than mid then the left element + 1 is the missing element
# or if the element to the right is not one greater than mid then the missing element is
# right element -1. Otherwise if the difference in the index of the low and mid is equal to
# the difference in the number at low and number at mid means all the element to the left 
# are there and the missing to the right and similarly we check for the right.

# time complexity -> O(log(n)) and space complexity ->O(1)
def find_missing_using_binary_search(nums): 
    l = 0 
    r = len(nums)-1
    
    if nums[0] > 1:
        return nums[0] - 1
    
    if len(nums)-1==(nums[-1]-nums[0]):
        return nums[-1]+1
    
    while l <= r:
        mid = (l+r)//2
        if nums[mid] != nums[mid-1]+ 1 or nums[mid] != nums[mid+1] -1:
            if nums[mid] != nums[mid-1]+ 1:
                return nums[mid-1]+1
            else:
                return nums[mid+1]-1
        if nums[mid] - nums[l] == mid - l:
            l = mid + 1
        else:
            r = mid - 1
            
    return nums[-1] + 1

print(find_missing_using_binary_search([1]))
print(find_missing_using_binary_search([2, 3, 4, 5, 6, 7, 8, 9]))
print(find_missing_using_binary_search([1, 2, 3, 4, 5, 6, 8, 9]))
print(find_missing_using_binary_search([1, 2, 3, 4, 5, 6, 7, 8, 9]))
