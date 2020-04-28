"""
// Time Complexity :T=O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :NA
// Any problem you faced while coding this:BF solution did not work for
some edge case.
"""
def getMissing(nums,l,h):
    while(h-l>=2):
        mid=int(l+(h-l)/2)
        midIdxDiff = nums[mid]-mid
        lowIdxDiff = nums[l]-l
        highIdxDiff = nums[h]-h

        if midIdxDiff!=lowIdxDiff:
            h=mid
        elif midIdxDiff!=highIdxDiff:
            l=mid
    return int((nums[h]+nums[l])/2)

if __name__=="__main__":
  nums = [1,2,3,4,5,6,8,9]
  l = 0
  h = len(nums)-1
  print("Missing number:",getMissing(nums,0,h))

  """
  class solution:
    def missingNumber(self,nums):
      l=0
      h=len(nums)-1
      mid=int(l+h/2)

      while(l<h):
        print(l,h,mid)
        mid=int(l+h/2)
        if nums[mid]==mid:
          l=mid+1
        else:
           h=mid-1
        if nums[mid]!=mid:
          return mid

  if __name__=="__main__":
    s=solution()
    arr=[0,1,2,3,4,6]
    print("Missing number=",s.missingNumber(arr))
    """
