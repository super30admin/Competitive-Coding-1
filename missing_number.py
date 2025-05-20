# binary search to find missing element in a sorted array
# lg(n) is time complexity

def find_missing(nums, l, r) -> int:
    first = nums[0]
    while (l <= r):
        mid = int(l + (r - l)/2)
        expected = first + mid
        if nums[mid] == expected:
            l = mid + 1
        else:
            r = mid - 1
    return first + l
        

if __name__ == "__main__":
    nums = [1,2,3,4,6,7,8]
    print(find_missing(nums, 0, len(nums)-1))