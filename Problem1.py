#Approach : Binary Search and check if the previous element value is matched correctly if not retrun prev value-1
#Edge cases : length of the size is 2 and missing first element
#Time Complexity : O(n)
#Space Complexity : O(1)
def search(ar, size):
    low = 0
    high = size -1
    if(size<=1):
        return -1
    elif(ar[0]!=1):
        return 1
    
    while(low<=high):
        mid = high+low//2
        if(ar[mid]==mid+1):
            low = mid+1
        else:
            if(ar[mid-1]==mid):
                return ar[mid]-1
            high = mid-1
    return -1
        

# Driver Code
a = [1,3,4,5]
n = len(a)
print("Missing number:", search(a, n))
