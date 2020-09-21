def missing_number(nums):
    l , r= 0, len(nums)-1
    while(l<=r):
        mid=l+(r-l)//2
        if nums[mid]==mid+1:
            l=mid+1
        else:
            r=mid-1
    return l+1
nums=[1,2,3,4,6]
if not nums:
    print(None)
else:
    print(missing_number(nums))