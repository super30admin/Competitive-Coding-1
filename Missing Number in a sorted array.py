def findMissingElement(nums):

    low = 0
    high = len(nums) - 1 # 6
    #Binary Search

    while((high - low) >= 2):
        mid = low + ((high - low)//2)

        midIndexDiff = nums[mid] - mid
        lowIndexDiff = nums[low] - low

        if (midIndexDiff != lowIndexDiff):
            high = mid
        else:
            low = mid
    return ((nums[low] + nums[high])//2)

nums = [1,2,3,4,6]
print("Missing number:", findMissingElement(nums))
