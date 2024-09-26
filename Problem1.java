
package leetCode;

public class MissingElement {
	int  arr [];

	
	//Time Compexity: log(n)
	private static int findElement(int[] inp) {
		
		int len = inp.length;
		int low = 0;
		int high = len-1;
		int start = inp[0];
		
		while(high-low>1) {
			//Binary search
			int mid = low + (high-low)/2;
			if(start+mid != inp[mid])	{
				//left side
				high = mid;
			}
			else {
				//right side
				low = mid;
			}
		}
		if(high-low == 1)	{
			//only two elements left
			if(inp[high]-inp[low]==2)	{//6-->8 7--10
				return inp[high]-1;
			}
		}
		
		return 0;
		
	}
	

	public static void main(String[] args) {
		//Driver Function
		//int arr [];
		int inp[] = {1,3};
		
		int missVal = findElement(inp);
		
		System.out.println(missVal);
		
	}

}
