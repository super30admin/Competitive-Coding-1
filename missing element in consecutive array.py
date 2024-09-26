#Time complexity: O(logn)
#Space complexity: O(1)
nums=[1,2,3,5,6,7,8,9]
        low,high=0,len(nums)-1
        
        temp=len(nums)
        while low<=high:
            mid=(low+high)//2
            if nums[mid]!=mid+1:
                temp=mid
                high=mid-1
            else:
                low=mid+1  
        print(temp+1) 
