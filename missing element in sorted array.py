
nums = [1,2,3,4,5,7,8]

def find_missing_element(nums):
    l,r = 0, len(nums)-1
    while r-l > 1:
        m = l + (r-l)//2
        if nums[l] - l != nums[m] - m:
            r = m
        elif nums[m] - m != nums[r] - r:
            l = m
    return nums[l] + 1

print(find_missing_element(nums))

