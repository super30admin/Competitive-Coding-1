/*package whatever //do not write package name here */
// Finding missing element in a sorted array
//Time Complexity: O(lon n)
//Space Complexity : O(1)


import java.io.*;

class GFG {
	public static void main (String[] args) {
	    //no missing element
	    int[] arr = {1,2};
		int result = binary_search (arr);
		print_result(result);
		
		//7 is missing
		int[] arr1 = {1,2,3,4,5,6,8,9,10};
		result = binary_search (arr1);
		print_result(result);
		
		//1 is missing
		int[] arr2 = {2,3,4,5,6,7,8,9,10};
		result = binary_search (arr2);
		print_result(result);
		
		//empty array - no missing element
		int[] arr3 = {};
	    result = binary_search (arr3);
	    print_result(result);
	
	}
	
	public static void print_result(int result)
	{
	    if(result==-1)
		{
		System.out.println("No Missing Element");
		}
		else
		{
		 	System.out.println("Missing Element is: " + result);   
		}
	}
	
	public static int binary_search(int[] arr){
	    
	    //if array is empty or null
	    if(arr == null || arr.length == 0) return -1;
	    
	    int low = 0;
	    int high = arr.length - 1;
	    
	    //if array is sorted 
	    if(arr[low] == (low + 1) && arr[high] == high + 1) return -1;
	    
	    //first element is missing 
	    if(arr[low]!=1)
	    {
	        return 1;
	    }
	    
	    while((high-low)>1)
	    {
	        int mid = low + (high-low)/2;
	        
	        if(low+1!=arr[low])
	        {
	            high = mid - 1;
	        }
	        else if(high+1 != arr[high])
	        {
	            low = mid + 1;
	        }
	        
	        if((mid+1)!=arr[mid]){
	           if(arr[mid+1]!=arr[mid]+1)
	            {
	                return arr[mid]+1;
	            }
	            else 
	            if (arr[mid-1]!=arr[mid]-1){
	               return arr[mid]-1;
	           }
	        }
	        
	    }
	      return arr[low]-1;
	    
	}
}
