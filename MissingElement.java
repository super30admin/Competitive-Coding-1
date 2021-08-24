// Given a list of n-1 integers and these integers are in the range of 1 to n. 
// There are no duplicates in list.
// One of the integers is missing in the list. 
// Write an efficient code to find the missing integer. 

// Time Complexity : O(lg n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Couldnt find this prb on leetcode
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MissingElement{
	
	public MissingElement() {
		
	}
	
	public int getMissingElement(int[] arr) 
	{
		int low = 0;
		int high = arr.length-1;
		int mid = low + (high-low)/2;
		
		while(low <= high) 
		{
			mid = low + (high-low)/2;
			
			if (arr[low] != low+1) {
				System.out.println("Found the missing element");
				return arr[low]-1;
			}
			else if(arr[mid]- arr[mid-1] + 1 == 1) {
				System.out.println("Found the missing element");
				return arr[mid]-1;
			}
			else if (arr[mid+1]- arr[mid] -1 == 1) {
				System.out.println("Found the missing element");
				return arr[mid]+1;
			}
			
			if ((mid-low) == arr[mid] - arr[low]) {
				System.out.println("Changing low pointer");
				low = mid+1;
			}
			else if((high-mid) == arr[high] - arr[mid]) {
				System.out.println("Changing high pointer");
				high=mid-1;
			}
			
			
		}
		return -1;
		
	}
    public static void main(String [] args) 
    {
    	MissingElement obj = new MissingElement();
    	int [] sendArray = new int[]{2,3,4,5,6,7,8};
    	
    	System.out.println(obj.getMissingElement(sendArray));

    }
}
