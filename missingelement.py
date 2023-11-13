def missingelement(nums):
    low=0
    high=len(nums)-1
    
    if len(nums)==0:
        return -1
    
    while(low<=high):
        mid =int((low+high)/2)
        
        if (mid==low or nums[mid-1]<nums[mid]-1):
            return nums[mid]-1
        elif (mid==high or nums[mid+1]>nums[mid]+1):
            return nums[mid]+1
        elif mid+nums[low]<nums[mid]:
            high=mid-1
        else:
            low=mid + 1
            
    return -1