class Solution:
    def missing_number(self, arr:int) -> int:

        low =0
        high= len(arr) -1

        while high > low + 1:
            mid = low +((high - low)//2)

            if (arr[low] - low != arr[mid] - mid):
                high =  mid
            elif (arr[high] -high != arr[mid] - mid):
                low = mid
        return arr[low] +1

obj = Solution()
arr = [1,2,3,4,5,6,8]

print(obj.missing_number(arr))


#This problem involves finding out the missing number in a sorted array.
#Using binary search algorithm and finding out the middle index to divide the problem and finding out if the value at an index minus the index will have difference as 1 at all times
#Time complexity -O(logn)
#Space complexity O(1)
