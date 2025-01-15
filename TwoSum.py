#Approach 1: =
#Brute Force
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i+1,len(nums)):
                if nums[i]+nums[j]==target:
                    return [i,j]
#Using Dictionary
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        indexmap={}
        for index in range(len(nums)):
            cur_num=nums[index]
            complement=target-cur_num
            if complement in indexmap:
                return(indexmap[complement],index)
            indexmap[cur_num]=index
        return[]   

