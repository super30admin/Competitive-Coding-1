'''
Approach:

1. Created a recursive binarySearch function
2. Find the mid. Check if diff. with mid-1 and mid+1 == 1
3. If yes, recursively call on the lhs of the list, if we get a mising value, return arr[mid]-1
4. If no, we will return lhs as -1 i.e. no missing value. Now recursively call on rhs of the list and return mid+1 if we get a value
5. Time Complexity in avg cases will be 0(logn)
6. Since we are using recursion, we will end up using recursion stack.
   Our space complexity will be 0(n) where (n) will be number of recursive calls
'''

class Solution:
    
    def binarySearch(self,arr,low,high):
        if low > high:
            return -1
        
        # Get mid
        mid = (high-low)//2 + low
        
        # Perform Check
        if ((mid-1>=low) and (arr[mid-1] == arr[mid]-1)) and ((mid+1<=high) and (arr[mid+1] == arr[mid]+1)):
            
            # Check on lhs
            lhs = self.binarySearch(arr,low,mid-1)
            
            if lhs == -1:
                # Check on rhs
                rhs = self.binarySearch(arr,mid+1,high)
                return rhs
            else:
                return lhs
            
        
        elif ((mid-1>=low) and (arr[mid-1] != arr[mid]-1)):
            return arr[mid]-1
        
        elif ((mid+1<=high) and (arr[mid+1] != arr[mid]+1)):
            return arr[mid]+1
        
        # Border-case mid==0
        # Our number should start from 1
        elif (mid == 0) and (arr[mid] != 1):
            return 1 
        
        else:
            return -1
        
    def chkSolution(self,arr):
        return self.binarySearch(arr,0,len(arr)-1)

sol = Solution()
print(sol.chkSolution([2,3,4,5,6,7,8]))