# Competitive-Coding-1

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance 

# Problem 
Find the missing number
nums = [1,2,3,5,6,7,8]
output = 4

# Python Code
def binarySearch(low,high,nums):

    while low <= high:

        mid = low + (high - low)//2

        if(nums[mid] == mid + 1):  //Check the left side to see if a number is missing by verifying if nums[mid] equals mid + 1, which indicates that no numbers are missing.
            low = mid + 1
        else:
            high = mid - 1
    return low +1

ans = binarySearch(0,len(nums)-1,nums)
print(ans)

# Time Complexity is O(log n )