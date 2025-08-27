def BinarySearch(nums):
    low=0
    high=len(nums)-1
    
    while(low<=high):
        mid=low+(high-low)//2
        if nums[mid] == mid+1:
            low=mid+1
        else:
            high=mid-1
            
    return low+1

nums=[1,2,3,4,6,7,8]
print(BinarySearch(nums))

# l=0
# h=6
# m=3 -->4==4
# l=3
# h=6 
# m=4 -->7==6
# l=3
# h=3 l=h return 5
# Time Compexity: O(logn)
czzzzzzzzzzzzzzz



