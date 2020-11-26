/*package whatever //do not write package name here */

import java.io.*; 
  
class GFG  
{ 
static int search(int a[],  
                  int size) 
{ 
    int low = 0;
    int high = size-1;
    while(low<=high){
        int mid = low+(high-low)/2;
        if(a[mid] == mid+2){
            if(mid==low || a[mid]-a[mid-1] == 2){
                return mid+1;
            }
            high = mid-1;
        }else{
            low = mid+1;
        }
    }
    return -1;
} 
  
// Driver Code 
public static void main (String[] args)  
{ 
    int ar[] = {1,2,3,5}; 
    int size = ar.length; 
    System.out.println("Missing number: " + 
                        search(ar, size)); 
} 
} 
