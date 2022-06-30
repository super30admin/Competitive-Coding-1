#Time Complexity: O(log n)

def MissingNumber(A):
    if len(A)<2: return None          
    mid      = len(A)//2              
    expected = A[0]+mid              
    actual   = A[mid]                 
    if expected == actual:            
        return MissingNumber(A[mid:])   
    if mid > 1:                       
        return MissingNumber(A[:mid+1])  
    return A[0]+1                     

A = [1, 2, 3, 5, 6, 7, 8]  
print(MissingNumber(A))