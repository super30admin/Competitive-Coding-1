"""
Approach:
clarifying question - Is the range of input [1, n] - yes. 
if we mid is on the side where mid == nums[mid] - 1 i.e. left side has no missing element. therefor go right else go left 
and missing element could be current element too.

"""
def main():
    nums = [1,2,4,5]
    n = len(nums)
    l, r = 0, n
    while l < r:
        mid = l + (r - l)//2
        if nums[mid] != mid + 1:
            r = mid
        else:
            l = mid + 1
    return nums[r] - 1

if __name__ == "__main__":
    print(main())