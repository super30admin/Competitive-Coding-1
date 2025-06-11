def findMissingNumbers(nums):
    missing = []
    for i in range(1, len(nums)):
        prev = nums[i - 1]
        curr = nums[i]
        # Check for any missing numbers between prev and curr
        if curr - prev > 1:
            missing.extend(range(prev + 1, curr))
    return missing
