class MissingElement:
    #TC: O(logn), SC: O(1)
    def missingElement(self,nums):
        low = 0
        high = len(nums) - 1
        
        if (not nums): return -1
        
        while(low<=high):
            if(high-low == 1):
                return nums[low]+1
            mid = low + (high-low)//2
            if(nums[mid]-nums[low] == mid-low):
                low = mid 
            else:
                high = mid
        return -1
        
s = MissingElement()
missingElem = s.missingElement([4,5,6,7,9])
missingElem1 = s.missingElement([1,3])
print(missingElem)
print(missingElem1)