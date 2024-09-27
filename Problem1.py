class Solution:
    def find_missing(self, start, end, nums):
        begin = nums[0]
        while start+1 < end:
            mid = start + (end - start) // 2
            expected = mid + begin
            actual = nums[mid]
            if expected != actual:
                end = mid
            else:
                start = mid
        return ((nums[start]+nums[end])//2)
        

if __name__ == "__main__":
    s = Solution()
    nums = [3,5,6,7,8,9,10,11]
    x = s.find_missing(0, len(nums)-1, nums)
    print("Answer is ", x)