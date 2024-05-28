# Time Complexity : O(log n)
# Space Complexity : O(1)


def missingNumber(arr):

    if not arr:
        return "Empty Array"

    lenArr = len(arr)

    l = 0
    h = lenArr-1

    while (l <= h):

        mid = (l+h)//2

        if mid != 0:
            if arr[mid]-mid != arr[mid-1] - (mid-1):
                return (arr[mid]+arr[mid-1])//2

        if arr[mid]-mid != arr[mid+1] - (mid+1):
            return (arr[mid]+arr[mid+1])//2

        if arr[mid] - mid == arr[l] - l == arr[h] - h:
            return "No missing element"

        if arr[mid] - mid == arr[l] - l:
            l = mid+1
        else:
            h = mid-1


arr = [1, 2, 3, 4, 6, 7, 8]
print(missingNumber(arr))
