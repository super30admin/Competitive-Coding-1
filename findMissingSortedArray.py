"""
// Time Complexity : o(logn), where n is the number of key-value pairs
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : not on leetcode
// Any problem you faced while coding this : no
"""

def search(ar, size): 
    l=0
    h=size-1
    
    while(l<h):
        mid = l+(h-l)//2
        
        if ar[mid] == mid+1: #checking if index to value mapping is correct, if its correct that means there's no missing value till now
            l=mid+1 #move to right half of the array
        else:
            h=mid # else there's a missing vlue in left half
    return a[mid]+1

# Driver Code 
a = [1, 2, 3, 5] 
n = len(a) 

print("Missing number:", search(a, n)) 
