
def findMissingElement(nums):

    left = 0
    right = len(nums) - 1


    while left<right:

        mid = left + (right - left)//2

        if (nums[mid] == mid+1):
            # first half doesn't have missing value
            left = mid + 1
        elif (nums[mid] > mid + 1):
            # first half has missing value
            right = mid 

    return left + 1   


nums = [2,3,4,5,6]
print(findMissingElement(nums))
# 0, 1, 2,3, 4, 5, 6
# 1, 2, 3,5, 6, 7, 8

# left = 0, right = 6

# mid = 3
# nums[mid] = 5
# first half has missing value
# right = 3

# left = 0, right =3
# mid = 1
# nums[mid] = 2
# left = 2

# left = 2, right = 3
# mid = 2
# nums[mid] = 3
# left = 3

# left = 3, right = 3
