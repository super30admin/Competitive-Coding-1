nums = [1,1,1]
k=2


i=0
j=0
sum=0
while (j<=len(nums)-1):
    if sum<k:
        j+=1
        sum+=nums[j]
        print(sum)
    elif sum>k:
        sum-=nums[i]
        i=i+1
    elif sum==k:
        print(nums[i:j])
        j+=1