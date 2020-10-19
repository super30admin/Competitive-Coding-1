
# Time Complexity: O(n)
# Space Complexity: O(1) - in-place

# Approcah: 
# Diveid the array into two zones:
#     - Left zone - no missing numbers (1+mid = ar[mid])
#     - Right zone - 1 missing number
#     - Binary search for the boundary between the tow zones

def search(ar, size):
    if not ar:
        return -1
    start = 0
    end = len(ar) - 1
    while start <= end:
        mid = (start+end)//2
        expected_mid = 1 + mid
        if expected_mid == ar[mid]: # Left Zone
            start = mid + 1
        else: # Right Zone
            end = mid - 1
    return ar[start] + 1

a = [2, 3, 4, 5, 6, 7, 8] 
n = len(a)
print(search(a,n))
