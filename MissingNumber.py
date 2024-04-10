# TC: O(log n)
# SC: O(1)

class Solution:
    def missingNumber(self, nums):
        nums= sorted(nums)
        """
        :type nums: List[int]
        :rtype: int
        """
        l=0
        h=len(nums)-1

        while l<=h:
            mid = l+ (h-l)//2

            first_element = nums[l]
            mid_element = nums[mid]
            last_element = nums[h]

            if nums[mid-1]!=nums[mid]-1:
                return nums[mid]-1 
            elif nums[mid+1] != nums[mid]+1:
                return nums[mid]+1
            elif mid_element > nums[l]+mid: #missing element in left. Hence, search left
                h=mid-1
            else: #mid_element < nums[l]+mid:
                l=mid+1
            # if l==mid:
            #     return nums[mid]-1
            
data = [9,6,4,2,3,5,7,0,1]
obj = Solution()
missing = obj.missingNumber(data)
print("Missing: ", missing)

#         l=0
#         h=len(nums)-1

#         while l<=h:
#             mid = l+ (h-l)//2

#             first_element = nums[l]
#             mid_element = nums[mid]
#             last_element = nums[h]

#             if nums[mid-1]!=nums[mid]-1:
#                 return nums[mid]-1 
#             elif nums[mid+1] != nums[mid]+1:
#                 return nums[mid]+1
#             elif mid_element > nums[l]+mid:
#                 h=mid-1
#             elif mid_element < nums[l]+mid:
#                 l=mid+1
#             elif l==mid:
#                 return nums[mid]-1