#Approach
# Assuptiom all the array start with 1 to n
# check the middle element if it is equal to index +1 or not if it is not and mid-1 = mid then mid is the value
# else if mi ==mid+1 then go right else go left

#Complexities
# Time Complexity: O(log n)
# Space Complexity: O(1)

def Find_Missing_Number(nums):
    low =0
    high =len(nums)-1

    while low<high:

        mid = int((low+high)/2)

        if nums[mid-1]== mid and nums[mid]!=mid+1:
            return nums[mid]-1
        elif nums[mid] > mid+1:
            high = mid-1
        else:
            low = mid+1
    if low==high:
        if low ==0:
            return 0
        elif low ==len(nums)-1:
            return low+1
    return nums[low]-1

print(Find_Missing_Number([1,3,4,5,6,7,8]))
print(Find_Missing_Number([1,2,3,5]))
print(Find_Missing_Number([1,2,4,5,6,7,8]))
