# Timecomplexity:O(logn)
# SpaceComplexity:O(1)
# Appraoch:This can be done by normal sum that takes O(n) but instead we are doing modified bianry serach 

def missingNumber( arr):
        # code here
        #using binary serach idx should be arr[i]-1
        l,h=0,len(arr)-1
        while(l<h):
            m=(l+h)//2
            if m+1!=arr[m]:return m+1
            if m+1==arr[m]:
                l=m+1
            else:
                h=m
        return l+1
print(missingNumber([1,2,3,5]))
