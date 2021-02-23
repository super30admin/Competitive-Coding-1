// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Utilising a binary search here with some improvisations to the code. As we know that the elements are sorted in the array except
//the missing element , the first and the last element of the array will never be the one that are missing. So we will take the difference
//between the element at index 0 and the element itself. The difference between any other element of the array and the index at which they are,
//is going to be always the same. We are going to take a low , a high and a mid.We then check the difference between the mid element and the index
//at which it is , if that difference is greater than 1 , then the missing element is not at the right side and keep searching the left side of mid.

import java.io.*; 
  
class GFG  
{ 
static int search(int ar[],int size) 
{ 
    int l = 0;
    int r = ar.length-1;
    int x = ar[0]-0;
    while(l<=r)
    {
        int mid = l + (r-l)/2; 
        
        if(l==mid)
        {
            return ar[mid]+1;
        }
        if(ar[mid]>mid+x)
        {
            r = mid;
        }
        else
        {
            l = mid; 
        }
    }
    return -1;
} 
  
// Driver Code 
public static void main (String[] args)  
{ 
    int ar[] = { 3, 4, 5, 6, 8 };
    int size = ar.length; 
    System.out.println("Missing number: " + 
                        search(ar, size)); 
} 
} 
  
