// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Could find this Problem in leetcode
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution():

    def findMissing(self,arr):

        low =0
        high = len(arr)-1
        while(low<=high):
           mid = low + (high - low) // 2
             // BASE CASE: if the difference between the mid and mid-1 elemement is greater than 1 then return the value of 1 less than mid element
           if(arr[mid]-arr[mid-1] !=1 and mid != 0 ):
               return arr[mid]-1

           // checking the difference between the value the value of the element and the index to find which side is having the missing element.
           // Based on this shift the boundaries towards the side where the element is missing.      
           LindValue = mid - low
           Lvalue = arr[mid]-arr[low]
           if(LindValue != Lvalue):
               high = mid
           else:
               low = mid

        return -1



obj  = Solution()
print(obj.findMissing([2,4,5,6 ,8, 9]))
