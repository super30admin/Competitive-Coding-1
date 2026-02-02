class Solution:
    def missingNumber(self, arr):
        # code here
        
        l=0
        h=len(arr)-1
        if arr[0]!=1:
            return 1
        if arr[-1]!=n:
            return n
        
        while l<h:
            m=(l+h)//2
            
            if arr[m]-m==1:
                l=m+1
            else:
                h=m
        return l+1
            