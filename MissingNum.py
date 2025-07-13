# Question: geeksforgeeks.org/dsa/find-the-missing-number-in-a-sorted-array/
# Time Complexity : O(log(n))
# Space Complexity : O(1)

class Solution():
    def FindMissing(self, arr):
        if arr[0] != 1:
            return 1
        low = 0
        high = len(arr) -1
        while low <= high:
            mid = (low + high) //2
            if (mid != 0 and arr[mid-1] != arr[mid] - 1):
                return arr[mid]-1            
            elif (mid != len(arr)-1 and arr[mid+1] != arr[mid] + 1):
                return arr[mid]+1
            else:
                if(arr[mid] == mid + 1):
                    low = mid + 1
                else:
                    high = mid -1
        return len(arr) + 1
    
obj = Solution()
sol1 = obj.FindMissing([1, 2, 3, 4, 6, 7, 8])
print("Missing Number: ", sol1)
sol2 = obj.FindMissing([1, 2, 3, 5, 6])
print("Missing Number: ", sol2)
sol3 = obj.FindMissing([2, 3, 4, 5])
print("Missing Number: ", sol3)
sol4 = obj.FindMissing([1, 2, 3, 4])
print("Missing Number: ", sol4)