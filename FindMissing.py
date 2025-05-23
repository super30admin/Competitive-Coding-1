
def search_missing(arr:[int])->int:
    l,r=0,len(arr)-1
    
    while l<=r:
        m = l + (r-l)//2
        if m!=0 and arr[m-1]!=arr[m]-1:
            return arr[m]-1
        if m!=len(arr)-1 and arr[m+1]!=arr[m]+1:
            return arr[m]+1
        if m-l!=arr[m]-arr[l]:
            r = m
        else:
            l = m
            
    return

print(search_missing([1, 2, 3, 4, 5, 6, 8, 9]))
            
        