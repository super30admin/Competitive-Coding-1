#Que:- Find missing element in a sorted array of consecutive numbers
#  "https://www.geeksforgeeks.org/find-missing-element-in-a-sorted-array-of-consecutive-numbers/"

# Time Complexity : O(log n)
# Space Complexity : O(1)

def missingEle(nums):
    low = 0
    high = len(nums) -1
    mid = 0
    while high - low >= 2:
        mid = low + (high - low) // 2
        midIdx = nums[mid] - mid
        lowIdx = nums[low] - low
        #highIdx = nums[high] - high

        if midIdx != lowIdx:
            high = mid
        else:
            low = mid
    return (nums[low] + nums[high]) // 2

nums = [1,2,3,4,5,6,7,8,9,11]
print(missingEle(nums))


        
