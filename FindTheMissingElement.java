import java.util.*;
public class FindTheMissingElement
{
    
    public static int FindTheMissingElement(int arr[] , int l, int h)
    {
        int low =l;
		int high=h;
		while(low<=high)
		{
		    int mid = low+(high-low)/2;
		    if(arr[mid]==mid+1)
		    {
		        low=mid+1;
		    }
		    else{
		    high=mid-1;
		    }
		 
		}
		return low;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
		    arr[i]=sc.nextInt();
		}
		System.out.println(FindTheMissingElement(arr,0,n-1)+1);
	
	}
	
}

//Time Complexity : O(logn)
//Space Complexity : O(1)

