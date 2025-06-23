# Problem Name: Interview Problem: Find Missing Number in a sorted array
# Time Complexity:O(logn)
# Space complexity: O(1)



def missingNumber(nums):
    l,h=0,len(nums)-1
    while l<=h:
      mid=(h+l)//2
      if nums[mid]-mid==1:
        l=mid+1
      else:
        h=mid-1
    return l+1

if __name__ == "__main__":
  arr = [1, 2, 3, 4,5]
  print(missingNumber(arr))