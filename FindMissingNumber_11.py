def missingNumber(nums):
    n = len(nums)  # getting the length of array
    total_sum = int(n * (n + 1) / 2)  # calculating sum of total numbers
    sum_nums = sum(nums)  # calculating sum of given array
    # return total-sum of array, we will get the missing number
    return total_sum - sum_nums

s = missingNumber([0,1,2,4,5,6,7])
print(s)