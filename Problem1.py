# Provide an array of n-1 integers in the range of 1 to n with no duplicates in list,
# One of the integers is missing in the list. Write a code to find the missing integer.


# # Time Complexity :  O(log n) where n is the size of the array

# Space Complexity : O(1)

# Approach: Split the search space into two and check if the difference between mid and previous element
# is equal 2 . If yes return nums[mid]-1. Else check if the difference between mid and next element
# is equal 2 . If yes return nums[mid]+1. Else search in the range where the difference betwwen indecies of the
# boundary elements is not matching the difference between the boundary elements.

def search(nums):
    low = 0
    high = len(nums)-1

    while low <= high:
        mid = low + ((high - low)//2)

        if nums[mid] - nums[mid-1] == 2:
            return nums[mid]-1

        if nums[mid+1] - nums[mid] == 2:
            return nums[mid]+1

        if nums[mid] - nums[low] != mid - low:
            high = mid - 1
        else:
            low = mid + 1

    return -1


nums = [1, 2, 3, 4, 5, 7, 8]


print(search(nums))
