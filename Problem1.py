#TC - O(logn)
#SC - O(1)

class Solution:
    def findMissing(self,arr):
        left = 0
        right = len(arr)-1

        while(left+1<right): #loop until only two ele are left to compare
            mid = left+(right-left)//2

            if arr[right]-arr[mid]!=right-mid:
                left = mid
            else:
                right = mid


        req = (arr[left]+arr[right])//2

        return req
        
#arr = [1,2,3,5,6] #returns 4
#arr = [1,2,3,4,5,7,8] #returns 6
obj = Solution()
arr = [3,4,5,7,8] 
print(obj.findMissing(arr))