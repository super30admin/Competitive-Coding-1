// A binary search based program to find the only missing number in a sorted array of distinct elements within limited range. 
//TC: O(logn)
//SC: O(1)
import java.io.*; 

class Solution 
{ 
public static int findMissing(int arr[]){
      int low=0;
      int high=arr.length-1;
	  while(low<=high){
           int mid=low+(high-low)/2;
          if(arr[mid]==mid+1){
              low=mid+1;
          }
          else{
              high=mid-1;
              if(mid==low || arr[mid-1]==mid ){
                    return mid+1;
                }
		  }	  
          }
		return -1;
    }

// Driver Code 
public static void main (String[] args) 
{ 
	int arr[] = { 1, 3, 4, 5, 6,7, 8 }; 
	int size = arr.length; 
	System.out.println("Missing number: " + findMissing(arr)); 
} 
} 