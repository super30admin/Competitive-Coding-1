'''Find the missing number in the sequence 1...n . 1. unique elements ->sorted array 2. elements start from 1'''
#TC - O(logN) SC- O(1)
#nums= [1,2,3,5]
def miss_num(nums):
    if nums is []:
        return -1
    low = 0
    high = len(nums)-1

    while (low<=high):
        mid = (low+high)//2

        if nums[mid]-mid-1<1: 
            #no missing numbers
            low = mid+1
        else:
            high = mid-1
    return low+1 

nums = [1,2,3,4,5,7,8] 
print(miss_num(nums))  

