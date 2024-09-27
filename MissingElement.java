// A binary search based program to find the only missing number in a sorted array 
//of distinct elements within limited range. 

// the concept behind this solution is that the elements 
// appearing before the missing element will have ar[i] – i = 1 
//and those appearing after the missing element will have ar[i] – i = 2.

//This solution has a time complexity of O(log n)
import java.io.*;
public class MissingElement
{
	
	static int search(int ar[], int size) 
		{
			int  low=0;
			int  high =	size-1;
			int mid =0;
			while((high -low)>1)
			{
				mid = low+(high-low)/2;
				if(ar[low]-low !=ar[mid]-mid) // The missing element is on the left half
					high = mid;
					else if (ar[mid]-mid != ar[high]-high)
						low = mid;
			}
			return ar[mid]+1;
		}
	public static void main(String args[])
	{
	int ar[] = { 1, 2, 3, 4, 5, 6, 8 }; 
    int size = ar.length; 
    System.out.println("Missing number: " + 
                        search(ar, size));	
	}
}