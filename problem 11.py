class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.nums=nums
        self.n=max(self.nums)
        #print(self.n,len(nums))
        sum_n=(self.n*((self.n)+1))/2
        sum_arr = sum(self.nums)
        #print(sum_n,sum_arr)