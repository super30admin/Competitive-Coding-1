# NOTE: Binary Search Solution at bottom.

# Assuming that the integer elements are sorted and only one element is missing.
# Also that the length of array is > 1.

# Brute Force way is Linear Search taking O(n) time and O(1) space.

arr = [-4,-3,-1]

# First and last elements can always be taken as reference as they cannot be the missing elements.

# Taking first element as reference.
# Method 1
diff = arr[0] - 0
for i in range(1, len(arr)):
    if (diff - (arr[i] - i)) % 2 != 0:
        print((arr[i]+arr[i-1])//2)
        break

# Taking last element as reference.
# Method 2
diff = arr[-1] - (len(arr)-1)
for i in range(len(arr)-1, -1, -1):
    if (diff - (arr[i] - i)) % 2 != 0:
        print((arr[i]+arr[i+1])//2)
        break

# Optimal way is using Binary Search taking O(log(n)) time and O(1) space.
# Method-3 Best:
lo = 0
hi = len(arr)-1
diff = arr[hi] - hi # can take arr[lo] - lo as well.

if len(arr) <= 1:
    print(None)
    exit()

while(lo <= hi):
    mid = lo + (hi-lo)//2    # to prevent integer overflow
    if ((diff - (arr[mid] - mid)) % 2 == 0):
        if (lo == mid and mid == hi):
            print((arr[mid]+arr[mid-1])//2)
            break
        hi = mid - 1
    else:
        if (lo == mid and mid == hi):
            print((arr[mid]+arr[mid+1])//2)
            break
        lo = mid + 1