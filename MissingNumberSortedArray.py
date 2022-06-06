# T(n)=O(log n)
# S(n) = O(1)

def search(arr):
    low=0
    high=len(arr)-1
   
    while(low<=high):
        mid=low+(high-low)//2
        if arr[mid]==mid+1:
            low=mid+1
            mid=mid+1
        else:
            high=mid-1
    print(mid+1)
search([1, 2, 3, 4, 5, 6, 8, 9])