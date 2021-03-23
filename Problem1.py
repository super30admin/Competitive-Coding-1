# Find Missing number in a sorted array
# Test case [1,2,3,5,6,7,8]
# ans - 4
# Time Complexity - O(logn)
# Space complexity - O(1)


class test1():
    nums = [3, 5, 6, 7, 8]
    if not nums:
        print("-1")
    low = 0
    high = len(nums)
    while(low <= high):
        mid = low + (high-low)//2
        if(len(nums[low:high]) == 2):
            print("Final array ", nums[low:high])
            print("Number missing : ", nums[low] + 1)
            break
        if ((mid - low) == (nums[mid] - nums[low])):
            low = mid
        else:
            # Giving high mid+1 because nums[low:high] is exclusive and hence will not include the element nums[high] within the array.
            high = mid+1
