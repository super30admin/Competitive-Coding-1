#Time Complexity: O(logn)
#Space Complexity: O(n)
#Did you face any problem while coding: No


class Solution:
    #This problem has binary search approach
    def findmissingelement(self, nums):
        l = 0
        h = len(nums) - 1
        while (l < h):
            m = l + (h - l) // 2
            #Checking if the missing element is adjacent to the mid element, This if condition checks if the missing element is left element of the mid.
            if (nums[m] - nums[m - 1] == 2 or m == 0):

                return nums[m] + 1
            #This if condition checks if the element is to right of the element
            elif (nums[m + 1] - nums[m] == 2 or m == h):

                return nums[m] + 1
            else:
                if (nums[m - 1] - (m - 1) != nums[0]):
                    h = m - 1
                else:
                    l = m + 1
        return -1


obj = Solution()
nums = [1, 3, 4, 5, 6, 7]
print(obj.findmissingelement(nums))
