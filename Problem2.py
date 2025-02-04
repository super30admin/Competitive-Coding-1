#find missing element from a sorted array of N size
#Time Complexity : O(logn)
#Space Complexity : O(1)
def find_missing_num(arr, N):
    l = 0
    h = N-1
    if arr[N-1] != N:
        return N

    while l<=h:
        mid = (h+l)//2
        
        if mid == 0 and arr[mid] != 1:
            return 1
        if mid > 0 and mid+1 != arr[mid] and arr[mid-1] == mid:
            return mid+1
        elif mid+1 != arr[mid]:
            h = mid-1
        else:
            l = mid+1
    return -1