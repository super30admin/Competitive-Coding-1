# Complexity: O(logn)
def search(a,n):
    beg = 0
    end = n-1

    while(beg<=end):
        mid = (beg +  end)//2
        if(a[mid]==mid+1):
            # left is sorted
            beg = mid + 1
        elif(mid==0 or a[mid-1]==mid) and (a[mid]!=mid+1):
            return mid+1
        else:
            end = mid - 1
    






# Driver Code 
a = [2, 3, 4, 5, 6, 7, 8] 
n = len(a) 
  
print("Missing number:", search(a, n)) 