"""
 FAANMG Problem #15 {Easy}


Q Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.


Time Complexity : O(log N)
 

Space Complexity : O(1)
Constant Space of alphabets map

Did this code successfully run on Leetcode : Yes


Binary Search is used to find the missing number

The loop is carried out untill l+1 < r  
if the value of arr[l]+1 is same as the last index, this means there is no missing element
else the missing element is the value arr[l]+1

If the loop we are checking if the arr[mid] value is same as the value of the middle index plus the first elemet value
So even if the array atsrts from any number still the difference will be same 

So if arr[mid] == mid + arr[0] is tru then this meand the left subpart does not contain and missing elemet
and the right subpart is selected and vise versa

  

    
@name: Rahul Govindkumar_RN27JUL2022
"""



def binarySearch(arr, size):
   

 
    l = 0
    r = size - 1
    mid = 0
    while l+1 < r:
        mid = (l + r) // 2
        
        if (arr[mid] == mid + arr[0]):
            l=mid
        else:
            r=mid
    return arr[l]+1
 
 
# Driver Code
arr = [1, 2, 3, 4, 5, 6, 7, 8]
n = len(arr)

missingNum = binarySearch(arr, n)
 

if(missingNum != arr[n-1]):
    print("Missing number:", missingNum)
else:
    print("No Missing Number")
 