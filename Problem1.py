# Time Complexity : O( log n)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach: Use binary search method and check the index and value at index for mid, low and high
def search(a): 
    l=0
    h=len(a)-1
    mid=0
    while h-l>1: 
        mid=(l+h)//2
        print(mid)
        if(a[l]-l) != (a[mid]-mid): 
            h = mid 
        elif(a[h]-h) != (a[mid]-mid): 
            l = mid 
    return a[mid] + 1
a = [1, 2, 3, 5, 6, 7] 
print(search(a)) 