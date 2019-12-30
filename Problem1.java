// Time Complexity :
//    main() - O(log(n))
//      
// Space Complexity :
//    main() - O(1)
//
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : Corner cases took some time to think

class Problem1 {
	public static void main(String[] args)
	{
		int[] A = new int[]{1,2,3,4,5,7,8,9,10};

		int l = 0, h = A.length-1, m = 0;

		while(l <= h)
		{
			m = l + (h - l) / 2;

			//Check if mid element is rightly placed
			//if rightly placed we search in right part
			if(A[m] == m + 1)
				l = m + 1;
			//if wrongly placed we search in left part
			else
				h = m - 1;
		}

		//post processing
		//check for extreme indexes
		if(l != 0 && l != A.length)
		{
			//if number at l is wrongly placed
			if(A[l] != l+1)
				//return the number to be placed correctly 
				System.out.println(l+1);
			else
				//else return the previous number
				System.out.println(l);
		}
		else
		{
			//if not for extreme indices
			System.out.println(l+1);
		}
		
	}
}
