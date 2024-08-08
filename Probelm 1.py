nums=[1,3,4,5,6,7,9]
low=0
high=len(nums)-1


while(low<=high):
    mid=low+(high-low)//2
    if nums[mid]==mid+nums[0]:
        low=mid+1
    else:
        high=mid-1
print(low+nums[0])