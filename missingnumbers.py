# // Time Complexity :O(logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :no,gfg problem
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




arr=[1,2,3,4,5,6,8]
low=0
high=len(arr)-1
while((high-low)>=2):
    mid=(high+low)//2
    mid_index_diff=arr[mid]-mid
    low_index_diff=arr[low]-low
    high_index_diff=arr[high]-high
    if(mid_index_diff!=low_index_diff):
        high=mid
    else:
        low=mid
print((arr[low]+arr[high])//2)
