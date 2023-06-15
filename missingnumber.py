# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to compare every element with its index if it doesnt matches then move low or high pointer to mid position.

a=[1,2,4,5,6,8,9]
n=len(a)
# Extreme cases
if(a[0] != 1):
    print(1)
if(a[n-1] != (n+1)):
    print(n+1)

l = 0
h = n - 1
m = 0
while h > l + 1:
    m = (l + h) // 2
    if (a[l] - l) != (a[m] - m):
        h = m
    elif (a[h] - h) != (a[m] - m):
        l = m
print(a[l] + 1)