# Array: [1,2,3,4,6,7,8] —>eg [4,5,6,8,9]
# # Idx:[0,1,2,3,4,5,6]
# Binary search -> Time complexity= O(logn)

arr = [6,8,9,10,11,12,13]

l = 0
h = len(arr)-1

while h -l>=2:
    mid = l + (h-l)//2
    lIdxDiff = arr[l]-l
    mIdxDiff = arr[mid]-mid
    if mIdxDiff != lIdxDiff:
        h = mid
    else:
        l = mid
    
print("missing number=",(arr[l]+arr[h])//2)

 