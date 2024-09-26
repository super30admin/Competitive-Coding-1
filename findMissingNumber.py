# approach 1
# class Solution:
#     def findMissingNumber(self, nums: List[int]) -> int:
#         low, high = 0, len(nums) - 1
#         while low <= high:
#             mid = low + (high - low)//2
#             if not mid+1 == nums[mid]:
#                 #eliminate right
#                 high = mid-1
#             else:
#                 #if mid element and immediate right element
#                 if nums[mid]+1 == nums[mid+1]:
#                     low = mid+1
#                 else:
#                     return nums[mid]+1
#         return -1
# sol = Solution()
# print(sol.findMissingNumber([1,2,3,5,6,7]))

# approach 2
# class Solution:
#     def findMissingNumber(self, nums: List[int]) -> int:
#         low, high = 0, len(nums) - 1
        
#         while(low<=high):
#             mid = low +(high-low)//2
            
#             #check left element
#             if mid>0 and nums[mid-1]+1 != nums[mid]:
#                 return nums[mid-1]+1
#             #check right element
#             elif mid<len(nums)-1 and nums[mid+1]-1 != nums[mid]:
#                 return nums[mid]+1
#             #check index
#             else:
#                 if nums[mid]==mid+1:
#                     low = mid+1
#                 else:
#                     high = mid-1
#         return -1
        
# sol = Solution()
# print(sol.findMissingNumber([1,2,3,5,6,7]))

# approach 3
def search(ar, size):
   # Extreme cases
    if(ar[0] != 1):
        return 1
    if(ar[size-1] != (size+1)):
        return size+1

    low = 0
    high = size - 1
    mid = 0
    while high-low > 1:
        mid = (low+high) // 2
        if (ar[low] - low) != (ar[mid] - mid):
            high = mid
        elif (ar[high] - high) != (ar[mid] - mid):
            low = mid
    return ar[low] + 1


# Driver Code
a = [1, 2, 3, 4, 5, 6, 8]
n = len(a)

print("Missing number:", search(a, n))