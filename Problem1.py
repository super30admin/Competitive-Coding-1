# given an array in sorted order;  print the missing element in an array
# Time Complexity : O(log n)
# Space Complexity : O(1)
a = [1,2,3,5,6,7]
low = 0
high = len(a)-1
while low<=high:
    mid = (low+high)// 2
    if mid + 1 == a[mid]:
        low =mid +1
    else:
        high = mid -1
print(low +1)
