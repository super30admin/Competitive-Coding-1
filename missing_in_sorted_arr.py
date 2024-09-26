'''
Time Complexity: O(log n)
Space Complexity: O(1)
'''
def find_Missing(nums):
    start=0
    end=len(nums)-1
    if len(nums)<1:
        return 0
    while start<=end:
        mid=start+(end-start)//2
        if nums[mid]-mid==2:
            end=mid-1
        elif nums[mid]-mid==1:
            start=mid+1
    return start+1

nums=[1,3,4,5,6,7,8]

print(find_Missing(nums))