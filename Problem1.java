// A binary search based program 
// to find the only missing number 
// in a sorted array of distinct 
// elements within limited range. 
import java.io.*; 

class GFG 
{ 
static int search(int arr[], 
				int size) 
{ 
  int low = 0;
  int high = size -1 ;
  
  while(high-low >= 2){
    int mid = low + (high-low)/2;
    if(arr[low]-low != arr[mid]-mid){
    high = mid;
    }else{
    low = mid;
    }
    
  }
  
  return (arr[low]+arr[high])/2;
} 

// Driver Code 
public static void main (String[] args) 
{ 
	int arr[] = {  3, 4, 5, 7, 8 }; 
	int size = arr.length; 
	System.out.println("Missing number: " + 
						search(arr, size)); 
} 
} 
