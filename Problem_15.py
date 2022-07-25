# Time Complexity : O(log n) for binary search
# Space Complexity : O(1) auxiliary space needed
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

def search(nums):
    low= 0
    high = len(nums)-1
    # Note that nums is sorted and elements are in range 1 to n
    if nums[low]!= 1:
        return low # If the first element is not 1 then 1 is missing
    if nums[high]!= len(nums)+1:
        return high # If the last element is not len(nums)+1 then it is missing
    while(low<=high):
        mid = low+(high-low)//2
        if((nums[mid]-mid)==1):
            low = mid+1 # If the difference between mid element and mid index is 1 then the missing element is in the right half
        else:
            high = mid-1 # Otherwise it is in the left half
    return low+1 # At the low index will have the element (low+1)+1 in it. So low+1 element is the missing element
        
 
 
# Driver Code
a = [1, 2, 3, 4, 5, 6, 8]
 
print("Missing number:", search(a))