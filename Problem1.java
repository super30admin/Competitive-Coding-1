//Time complexity: O(logn)
//Space complexity: O(1)

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		//System.out.println("GfG!");
		Scanner scan=new Scanner(System.in);
		int n= scan.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    arr[i]=scan.nextInt();
		}
		int left= 0; int right= n-1;
		while(right-left>1)
		{
		    int mid=left+(right-left)/2;
		    if(arr[left]-left==arr[mid]-mid)
		    {
		        left=mid;
		    }
		    else if(arr[right]-right==arr[mid]-mid)
		    {
		        right=mid;
		    }
		}
		System.out.println(arr[left]+1);
	}
}
