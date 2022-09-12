# Time Complexity : O(log(n))
# Space Complexity: O(1)

def find_element(nums):
    l = 0
    r = len(nums) - 1

    while(l <= r):
        mid = l + (r-l)//2
        if nums[mid] == (mid + 1):
             l = mid + 1
        else:
            r = mid - 1
    return l + 1


# nums = [1, 2, 3, 4, 6]
# nums = [1, 3, 4, 5, 6]
nums = [1, 2, 4, 5, 6]


print(find_element(nums))


