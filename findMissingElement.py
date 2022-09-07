
def findMissingElement(a):
        l=0
        h=len(a)-1
        while l<=h:
            mid=l+(h-l)//2
            if a[mid]==mid+1:
                if a[mid-1]==mid and a[mid+1]==mid+2:
                    l=mid+1
                else:
                    return a[mid]+1
            else:
                h=mid-1
        
a=[1,2,3,6,5,7,8]
print(findMissingElement(a))