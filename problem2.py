# Find the Missing Number in a sorted array
def missingNumber(nums):
    l = 0
    h = len(nums) - 1
    # [1, 2, 3, 4, 6, 7, 8]
    # [0, 1, 2, 3, 4, 5, 6]
    # [1, 2, 4, 5, 6, 7, 8]
    # [0, 1, 2, 3, 4, 5, 6]
    while l <= h:
        m = l + (h - l)//2
        print(l, h,m)
        if nums[m] == m + 1:
            l = m + 1
        elif nums[m]==m+2:
            if nums[m-1]==m:
                # print(nums[m-1], m)
                return m+1
            h = m - 1
nums = [1, 2, 4, 5, 6, 7, 8]

# print("s")
print(missingNumber(nums))
