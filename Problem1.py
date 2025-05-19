class Solution:
    def findMissingElement(self, arr: List[int] ) -> int:
        n=len(arr)
        if n==0 or arr[0]!=1:
            return 1
        l=0
        h=n-1

        while l<=h:
            mid=l+(h-l)//2
            exp=mid+1

            if mid!=0 and arr[mid-1]!=arr[mid]-1:
                return arr[mid]-1
            else:
                if arr[mid]>exp:
                    h=mid-1
                else:
                    l=mid+1
        
        return -1

""" if mid!=0 and arr[mid-1]!=arr[mid]-1:
                return arr[mid]-1
            elif mid!=n-1 and arr[mid+1]!=arr[mid]+1:
                return arr[mid]+1
            else:
                if arr[mid] > mid+1:
                    h=mid-1
                else:
                    l=mid+1
        
        return -1 """           