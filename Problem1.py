#time Comp. O(logn)
#space: O(1)
class Solution:
    def findMissingNumber(self,nums):
        s=0
        e=len(nums)-1

        while(s<=e):
            mid=(s+e)//2
#check if mid has the same value as index, if yes that means it is at correct place
            if nums[mid]==mid+1:
                s=mid+1
            else:
                e=mid-1
        return s+1

a=Solution()
arr=[1,2,3,5,6]
print(a.findMissingNumber(arr))
      
        

        
             