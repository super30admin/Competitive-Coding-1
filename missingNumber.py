class Solution:
    def missing(self, arr):

        length=len(arr)-1

        start=0
        end=length

        while(start<=end):

            mid= start+ (end-start)//2

            if mid>0 and (arr[mid]-arr[mid-1])==2:
                return(arr[mid]-1)
            if mid<length and (arr[mid+1]-arr[mid])==2:
                return(arr[mid]+1)

            if((arr[mid]-mid)==1):
                start=mid+1
            else:
                end=mid-1
        return("its sorted")


arr=[1,2,3,4,6,7,8]
obj= Solution()
print(obj.missing(arr))