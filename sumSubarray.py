# Find the range and calculate sum of all elements in that range. If sum is > current max, return newe max.
##Time Complexity: O(n^2)
#Space Complexity: O(n)
def findCount(arr,target):
    count = 0
    for i in range(len(arr)):
        for j in range(i+1, len(arr)+1):
            totSum = 0
            for k in range(i,j):
                totSum = totSum + arr[k]
            if (totSum == target):
                count = count + 1
    return count

nums = [1,1,1]
k = 2
cnt = findCount(nums,k)
print(cnt)

