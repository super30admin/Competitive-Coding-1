'''
FIND THE MISSING NUMBER IN A SORTED ARRAY
TIME COMPLEXITY: O(logN)
SPACE COMPLEXITY: O(1)
LEETCODE: question doesn't exist
ANY PROBLEMS FACED: nope nothing major
'''

def find_missing_number(nums):
    l = 0
    r = len(nums)-1

    while l<=r:
        m = (l+r)//2
        if nums[m]-m < nums[r]-r:
            l = m+1
        else:
            r = m-1
    return nums[l]-1


test_cases = [
    [3,4,5,6,7,9],
    [1],
    [3,5],
    [3,5,6,7,8,9],
    [1,2,3]
]

for case in test_cases:
    print(find_missing_number(case))