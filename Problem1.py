
# Time Complexity: O(log n)
# Space Complexity: O(1)

def search(nums):

    s, e = 0, len(nums)-1

    # if no missing element
    if e-s == nums[e]-nums[s]:
        return -1

    # if difference of last and first index is greater than or equal to 2
    while e-s >= 2:
        m = (s+e) // 2

        # missing element is on the right of mid
        if nums[m]-nums[s] != m-s:
            e = m
        else:
            s = m + 1

    return e+nums[0] if s == nums[s]-nums[0] else s+nums[0]


 
# Driver Code
a = [1, 2, 3, 4, 5, 6, 8]
print("Missing number:", search(a))