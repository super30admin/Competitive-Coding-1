# Question 1
# find missing number when array is sorted   
#TC O(log n) and SC O(1)
nums = [1,2,3,4,6,7,8]
low = 0
high = len(nums) - 1

if nums == None or len(nums) == 0:
    print(1)

while low <= high:
    mid = low + (high - low) // 2 
    if nums[mid] == mid + 1:
        low = mid + 1
    else:
        high = mid - 1

print(low+1)



#Question 2
# find missing number when array is not sorted   
#TC O(n) and SC O(1)

nums = [2,8,5,1,3,6,7,10,9]

n=len(nums)+1
sum_total = (n * (n+1)) //2
sum_arr = 0

for i in range(len(nums)):
    sum_arr += nums[i]

#print(sum_arr)
print(sum_total - sum_arr)

