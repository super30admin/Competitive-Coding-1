#time complexity: O(log n)
# space complexity: O(1)
# approach: check if we have crossed the missing element or not and update low and high accordingly

arr = [1, 2, 3, 5, 6, 7, 8]
n = len(arr)
if arr[0]!= 1:
    print(1)
elif arr[n-1] != n+1:
    print(n+1)
else:
    low = 0
    high = len(arr)
    while(low+1 != high):
        mid = low + (high - low)//2
        if arr[low]-low != arr[mid]-mid:
            high = mid
        elif arr[high]-high != arr[mid]-mid:
            low = mid
    print(arr[low]+1)
        

        

