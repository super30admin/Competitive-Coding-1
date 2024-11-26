#Time Complexity: O(log n)
#Space Complexity: O(1)
class MissingElement():
     def missingElementSearch(self,nums):
          l=0
          h=len(nums)-1
          if nums[0]!=1:
            print(1)
          else:
            while(l<=h):
              mid=(l+h)//2
              if nums[mid]==mid+1:
                l=mid
              elif nums[mid]!=mid+1:
                h=mid
              if l==h-1:
                print(h+1)
                break
          
a=MissingElement()
nums=[1,3,4,5,6]
a.missingElementSearch(nums)