'''
Time complexity :O(logN)
Space complexity : O(1)
'''
class Solution:
    def missingNumber(self,array):
        if len(array) == 0:
            return -1

        low = 0
        high = len(array) - 1

        while low +1 < high:
            mid = low +(high - low) //2
            if array[low]-low != array[mid] - mid:
                high = mid
            elif array[high] - high != array[mid] - mid:
                low = mid

        return array[mid] + 1


s = Solution()
array = [1,2,3,4,5,6,8]
print(s.missingNumber(array))