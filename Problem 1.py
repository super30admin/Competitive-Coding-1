class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums.sort()
        length_of_array=len(nums)-1
        lp=0
        hp=length_of_array
        while(lp<=hp):
            mid= lp+(hp-lp)//2


            if((mid == 0  or nums[mid]-1 != nums[mid-1]) and nums[0]!= 0):
                return nums[mid]-1

            if(mid == length_of_array or nums[mid]+1 != nums[mid+1]):
                return nums[mid]+1


            if(nums[mid]==mid):
                lp=mid+1
            else:
                hp=mid-1

        return length_of_array+1