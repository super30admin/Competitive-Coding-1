# '''Given a list of n-1 integers and these integers are in the range of 1 to n. 
# There are no duplicates in list. One of the integers is missing in the list. 
# Write an efficient code to find the missing integer. 
# Examples: 

# Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
              #             l  M      R
# Output : 5

# Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
# Output : 7'''

# O(LogN)
# SPACE COMPLEXITY = O(1)
class Solution:
    def BinSearch_MissingNumber(ar:list)->int:
    # Extreme cases
        size = len(ar) -1
        if(ar[0] != 1):
            return 1
        if(ar[size-1] != (size+1)):
            return size+1

        a = 0
        b = size - 1
        mid = 0
        while b > a + 1:
            mid = (a + b) // 2
            if (ar[a] - a) != (ar[mid] - mid):
                b = mid
            elif (ar[b] - b) != (ar[mid] - mid):
                a = mid
        return ar[a] + 1
        
print(Solution.BinSearch_MissingNumber([1, 2, 4, 5, 6, 7, 8, 9]))
