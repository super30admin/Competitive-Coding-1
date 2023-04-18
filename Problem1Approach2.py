"""
Find missing number in array
Approach-1 : TC = O(logN), SC= O(1)
arr = I/p array
desisredElems = range(arr[0], arr[-1])
compare corressponding elems of arr and desisredElems
1. compare the desiredMidElem and the value in the arr at the mid index, this will tell which side is the missing element
2. If missing element is LHS,  then arr[mid] - desiredMidElem > 0
3. else missing element is RHS
"""

def missingNum2(arr):
    low = 0
    high = len(arr)-1
    while low <= high:
        desiredLowElem = arr[low]
        desiredHighElem = arr[high]
        mid = low + (high-low)//2
        desiredMidElem = (arr[high]-arr[low])//2
        # print(desiredMidElem, mid)
        if mid < len(arr)-1 and arr[mid]+1 < arr[mid+1]:
            return arr[mid]+1
        elif mid > 0 and arr[mid]-1 > arr[mid-1]:
            return arr[mid]-1
        if arr[mid] - desiredMidElem > 0:
            #missing element in LHS
            high = mid - 1
        else:
            #missing element in RHS
            low = mid + 1
    return -1

arr = [3,4,5,7,8]
print(missingNum2(arr))

arr = [1,2,4,5,6,7,8]
print(missingNum2(arr))

