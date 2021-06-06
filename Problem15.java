// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Any problem you faced while coding this : solved it in the interview on Sunday with working code

class solution{
	static int binarySearch(int array[],int size){
    	int low = 0; 
	int high = size - 1;
    	while(low <=high){
        	int mid = low + (high-low)/2;
        	if((array[low] - low) != (array[mid] - mid)){
            		high = mid - 1;
        	}else if((array[high] - high) != (array[mid] - mid))
            		low = mid + 1;
    }
    return (array[low] + 1);
}
 
public static void main (String[] args){
    int array[] = { 1, 2, 3, 4, 5, 6, 8 };
    int size = array.length;
    System.out.println("Missing number: " + binarySearch(array, size));
}
}
