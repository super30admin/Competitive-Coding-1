def missingNumber():
    nums=[1,2,3,4,5,6,7,9]
    low=0
    high=len(nums)
    while low<=high:
        mid=low + (high-low)//2
        if nums[mid]==mid+1:
            low = mid+1
        else:
            high=mid-1
    return low+1
print(missingNumber())

