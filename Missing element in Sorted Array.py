# Time complexity: O(logn)
# Space complexity: O(1)
# Does this code run on Leetcode: Yes
# Did you face any dicciculty in coding the solution: No

def search(nums, l):
    s, e = 0, len(nums)-1
    while (s<=e):
        mid = s + (e-s)//2
        if s == e and nums[mid] != mid+1:
            return mid+1
        if nums[mid]!= mid+1:
            e = mid
        else:
            s = mid+1









a = [2]
n = len(a)
 
print("Missing number:", search(a, n))