#test cases
t1=[2,3,4,5,6,7,8]
t2=[1,3,4,5,6,7,8]
t3=[1,2,3,4,6,7,8]
t4=[1,2,3,4,5,6,8]

#Time Complexity: O(log n)
#Space Complexity: O(1)
#Method: Binary search the element, ideally arr[i] should be equal to i+1
#calculate mid, check condition, if yes look on right half else look on left half
def find_missing_element(arr):
    l = 0
    r = len(arr)-1
    
    while(l<r):
        mid = l+(r-l)//2
        if(arr[mid]==mid+1):
            l = mid+1
        else:
            r = mid    
    return arr[l]-1

print(t1,find_missing_element(t1))
print(t2,find_missing_element(t2))
print(t3,find_missing_element(t3))
print(t4,find_missing_element(t4))