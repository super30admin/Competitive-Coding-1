class Solution:
    def findMissingNumber(arr):
        n=len(arr)+1
        expected_sum=n*(n+1)//2
        actual_sum=sum(arr)
        return expected_sum-actual_sum


print(Solution.findMissingNumber([1, 2, 3, 5, 6, 7, 8]))
print(Solution.findMissingNumber([1, 2, 4, 5, 6, 7, 8, 9]))