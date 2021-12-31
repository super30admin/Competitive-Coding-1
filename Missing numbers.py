arr = [1,2,3,4,5,7,8]

# Time Complexity: O(logn)
# Space Complexity: O(1)

class solution:

    def missing_number(arr):
        l = 0
        h = len(arr)-1
        while h-l>1:
            mid = l + (h-l)//2
            if arr[mid] - arr[l] != mid - l:
                h = mid
            elif arr[h] - arr[mid] != h - mid:
                l = mid
        return (arr[l]+arr[h])//2