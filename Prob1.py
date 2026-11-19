#Method 1 - Linear search with index - O(n)
#Method 2 - Same idea but with Binary Search - O(logn)
#Idea is that if the difference between an element and its index same as mid element and its index the missing number is in this half if not the other

class Solution:
    def missingNum(self, arr: list[int]) -> int:
        low=0
        high=len(arr)-1

        while high-low>=2: #go down till we find exact 2 ele btwn which the missing ele should exist
            mid=low+(high-low)//2
            middiff=arr[mid]-mid
            lowdiff=arr[low]-low
            highdiff=arr[high]-high

            if middiff!=lowdiff: #if difference of mid ele and its index and low ele and its index is not the same -> move leftwards
                high=mid #not mid-1 IMPORTANT
            elif middiff!=highdiff: #else if  difference of mid ele and its index and high ele and its index is not the same -> move rightwards
                low=mid #not mid+1 IMPORTANT
        return (arr[low]+arr[high])//2 #now we have 2 ele btwn which the missing ele should exsit so midpoint it
