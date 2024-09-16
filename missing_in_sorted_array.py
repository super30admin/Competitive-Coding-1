def solution(arr):

    low = 0
    high = len(arr)-1

    while (low <= high):
        mid = low + (high-low)//2
        print("mid", mid)

        if low == mid:
            if arr[low] != low+1:
                return arr[low]-1
            else:return arr[low]+1

        if mid == arr[mid] -1:
            low = mid
        else:
            high = mid


print(solution([1,2,3,4,6,7,8]))

