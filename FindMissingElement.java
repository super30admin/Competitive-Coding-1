/** Time : O(log n) where n is length of array
 *  Space O(1) */
public class FindMissingElement {	
	public int findMissing(int[] arr) {
		if(arr==null)  return -1;
					
		int low=0;
		int high= arr.length-1;
		
		//Initialize count to low
		int count= arr[low];
		
		//Binary search
		while(low <= high) {
			int mid= low +(high-low)/2;
			int ele= count+mid;
			
			//if missing element found
			if(arr[mid]!= ele) {
				return ele;
			}
			
			//Left side has all elements, search in right 
			if(arr[mid] == ele) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		
		return -1;
	}
	
	//Main Method
	public static void main(String[] args) {
		FindMissingElement obj= new FindMissingElement();
		int[] arr= new int[] {1,2,3,4,5,7,8};
		System.out.println("Missing element is :"+ obj.findMissing(arr));
	}
}