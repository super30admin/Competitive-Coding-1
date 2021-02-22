
class GFG {
	public static void main (String[] args) {
		System.out.println("GfG!");
		System.out.println(returnMissing(new int[]{1,2,3,4,5,6,7}));
	}
	public static int returnMissing(int[] intArray) {
	    int low = 0;
	    int high = intArray.length -1; //[1,2,3,5,6,7,8] //[6,7,8,10]
	    int mid = low +(high - low)/2; // mid = 3 , a[3] = 5
	    // Check if array is empty
	    // Best case scenario - Check if middle element is Missing 
	  // Best case scenario , where middle element has the missing integer
      if(intArray[high] == intArray.length){
	        return intArray[high]+1;
	    }
    // Scenario to handle if 1 is missing from the array
    if(intArray[0] != 1){
    return 1;
    }
	    while(high != low+1){ // O(log(n)) , space - O(1)
	        if(intArray[mid] > mid+1 ) {
	            high = mid; // high = 3
	            mid = low +(high - low)/2; // mid = 1;
	        } 
	        else{
	            low = mid;
	            mid = low +(high - low)/2;
	        }
	        
	    }
	    return intArray[low]+1;
	    
	}
}
