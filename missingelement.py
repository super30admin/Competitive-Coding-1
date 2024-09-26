def missingnums(nums):
    start=0
    end=len(nums)-1
    #binary search to find missing element
    while(start<=end):
        mid=start+(end-start)//2
        #condition to find if starting element 1 is missing
        if (mid==0) and (nums[mid]!=1):
            return 1
        #condition to find missing number that is left of mid
        if (mid>1) and (nums[mid]-nums[mid-1]!=1):
            return (nums[mid]-1)
        #condition to find missing number that is right of mid
        if (mid<(len(nums)-1)) and (nums[mid+1]-nums[mid]!=1):
            return (nums[mid]+1)
        #condition to reduce search area to right of mid
        if (mid-start)==(nums[mid]-nums[start]):
            start=mid+1
        #condition to reduce search area to left of mid
        else:
            end=mid-1
    #returning -1 if there is no missing element
    return -1