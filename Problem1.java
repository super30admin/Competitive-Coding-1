/* Time Complexity: O(log(N))
 * Space Complexity:o(1)
 * Any problem you faced while coding this : No
 */

class MissingElement {
    static int search(int nums[], int n)
    {
    	int low =0;
    	int high = n - 1;
    	
    	while(high - low >= 2) {
    		int mid  = low + (high - low)/2;
    		if((arr[low] - low) != (arr[mid] - mid)) {
    			high = mid;
    		} else {
    			low = mid;
    		}
    	}
    	
    	return (arr[low] + 1);
    }

    public static void main(String[] args)
    {
        int nums[] = { 1, 2, 3, 4, 6 };
        int n = nums.length;
        System.out.println(search(nums, n));
    }
}
