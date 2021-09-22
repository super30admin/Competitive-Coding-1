# Time Complexity: O(log(n)), Where n is the length of the array a
# Space Complexity: O(1), we don't use extra auxiliary space
def missingNum(a):
    if not a or a == []:
        return -1
    l = 0
    h = len(a) - 1
    while l <= h:
        m = l + (h - l) // 2
        if m != 0 and a[m]-a[m-1] > 1:
            return a[m] - 1
        if a[m]-m == a[l] - l:
            l = m+1
        elif a[m]-m == a[h] - h:
            h = m-1
    return -1

print(missingNum([1,2,3,5]))