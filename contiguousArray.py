#The brute force way to solve this problem is to count the number of zeros and ones in each combination and return maximum
#Time Complexity: O(n^2)
#Space Complexity: O(n)
def maxLen(arr):
    mlen = 0
    for i in range(len(arr)):
        z = 0
        o = 0
        for j in range(i,len(arr)):
            if arr[j] == 0:
                z = z + 1
            else:
                o = o + 1
            if (z == o):
                mlen = max(mlen,j-i+1)
    return mlen

arr = [0,1]
m = maxLen(arr)
print(m)