#time complexity: O(log(n))
#space complexity: O(1)
#Check if the left side or right side has a missing element and adjust low or high accordingly.
#the loop goes on till low and high are near each other ie high-low>1
#after the loop return the avearge of numbers pointed by low and high

nums=[1,2,3,4,6,7]
low=0
high=len(nums)-1
while(high-low>1):
    mid=(low+high)//2
    #chcek if left side has any missing number
    if(nums[low]-low!=nums[mid]-mid):
        high=mid
    else:
        low=mid
print((nums[high]+nums[low])/2)