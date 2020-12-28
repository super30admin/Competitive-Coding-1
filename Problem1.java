import java.io.*; 

class Solution
{ 
static int search(int ar[], 
				int size) 
{ 
	int low = 0, high = size - 1; 
	if(ar[0]!=1)
	    return 1;
	if(ar[high] == size)
	    return size+1;
	int mid = 0; 
	while ((high - low) > 1) 
	{ 
		mid = (high-low) / 2 + low; 
		if(ar[mid]-mid == 1) 
			low = mid;
		else
		    high = mid;
	} 
	return (ar[mid] + 1); 
} 

// Driver Code 
public static void main (String[] args) 
{ 
	int ar[] = { 2, 3, 4, 5, 6, 7}; 
	int size = ar.length; 
	System.out.println("Missing number: " + 
						search(ar, size)); 
} 
} 

//Time complexity : O(logN) where N is the size of array
//Space complexity : O(1) since no extra space is used
