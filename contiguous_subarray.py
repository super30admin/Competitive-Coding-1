class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        :time complexity: O(n)
        :space complexity : O(1)
        """
        count=0
        max_length=0
        # Initialize dictionary with key and value as zero
        d = {0:0}
        # since we start dict with 0,0, the first element nums[0] have to start from 1 index
        for index, num in enumerate(nums,1):
            if num==0:
                count=count-1
                
            else:
                count=count+1
                
            if count in d:
                max_length=max(max_length, index-d[count])
            else:
                d[count]=index

        return max_length
            
            
            
    
        
        