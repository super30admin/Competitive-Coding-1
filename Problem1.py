#Time Complexity : O(logN), N being the number of values in array.
#Space Complexity : O(logN), because is recursion.
#Did this code successfully run on Leetcode : Did not find link to leetcode.
#Any problem you faced while coding this : I had a little trouble where I didn't 
# understand the problem. I had thought the missing value was going to be in the 
# middle all the time.  

#Your code here along with comments explaining your approach in three sentences only
''' Used binary search to see if the diff bet. index and value is different at the 
edges. If the different, then the missing value is in the range. 
'''
def missing_value(array, low, high):
    mid = int((low+high)/2)
    # differences bet. value and indices. 
    low_diff=array[low]-low
    mid_diff=array[mid]-mid
    high_diff=array[high]-high
    if high-low<=1:
        if array[low]+1!=array[low+1]:
            return array[low]
        if array[high]+1!=array[high+1]:
            return array[high]
    else:
        if low==0 and low_diff!=1:
            return 1
        # recurse if not found
        elif mid_diff!=low_diff:
            high = mid
            return missing_value(array, low, high)
        elif mid_diff!=high_diff:
            low = mid
            return missing_value(array, low, high)
        else:
            return array[high]+1

array = [1,2,3,4,5,6,7,8]
value = missing_value(array, 0, len(array)-1)
print(value)