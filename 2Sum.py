class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        hashmap[nums[0]]=0
        for i,no in enumerate(nums):
            if target - no in hashmap and hashmap[target-no]!=i:
                return [i,hashmap[target-no]]
            hashmap[no]=i
        
        