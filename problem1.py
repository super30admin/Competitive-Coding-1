"""
Time Complexity: log(n) where n is the total number of elements in the input array
Space Complexity: O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach
1. Brute-force: Perfrom linear search and found the missing element.
        Time Complexity: O(n) where n is the number of elements in the array
        Space Complexity: O(1)

2. Perform Binary Search as it is a sorted array
Idea here is to find the two numbers in which the missing element is present, so that we can find the missing number by       num1_num2 // 2.
For example : nums = [1,2,3,4,5,6,8], 7 is missing
Find 6 and 8 (7 is missing in between 6 and 8) and then return (6+8) // 2

To find two numbers in missing element:
- As the array is sorted , differenece between index number and the actual value of any element in the array should be constant.
- If the difference is not same then missing element must be between those two numbers.
- Continue this approach till we find only two such numbers.

Time Complexity: log(n) where n is the total number of elements in the input array
Space Complexity: O(1)

"""
def findMissingNumber(nums):
    low = 0
    high = len(nums) - 1

    while(high - low >= 2):
        mid = (low + high) // 2
        
        midIdxDiff = nums[mid] - mid
        lowIdxDiff = nums[low] - low
        highIdxDiff = nums[high] - high

        if midIdxDiff != lowIdxDiff:
            high = mid
        else:
            low = mid
    
    return (nums[high] + nums[low]) // 2

if __name__ == "__main__":
    print(f"Missing Number: {findMissingNumber([3,5,6,7,8])}")