# Time Complexity: O(logN)
# Space Complexity: O(1)

# Find Missing Number in Array
# Here the logic we use is that if there is a missing number in the continuos array
# then it would be the average (a+b/2) of the 2 elements in between which the number is missing
# and here we are also solving it for the cases where the array doesn't start from 1
# so we use index_difference:
# suppose the a = [3,4,5,6,8] so here the array starts from 3 at index 0, index diff = 3-0 = 2
# so if the mid has the same index_difference i.e. here 5 at index 2 diff = 5-2 = 3
# then there is no missing element in the first part of the array
# in the end we reach a point [low=6,high=8] then we return the average of the 2
class Solution:
    def MissingNumber(self,array):
        # code here
        low = 0
        high = len(array) - 1
        idx_diff = array[0]

        while(high-low >= 2):
            mid = low + ((high-low)//2)
            mid_diff = array[mid] - mid
            if(mid_diff != idx_diff):
                high = mid
            else:
                low = mid
        return ((array[low] + array[high])//2)