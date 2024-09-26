// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
public class Problem1 {

    //finding missing element in given array
    public static int searchMissingElement(int arr[]) {
        int low = 0; int high = arr.length-1;
        // check the index is one less than element in first and last index
        //if it is then no element is missing
        if(arr[0]-1 == low && arr[high]-1 == high) {
            System.out.println("All elements are there");
            return -1;
        }
        // reduce the search space by finding the difference between an index and element is greater than 2 
        while(low<=high) {
             int mid = low +(high-low)/2;
             if(arr[mid] == mid+1) {
                 low = mid+1;
             } else {
                 high = mid-1;
             }
        }
        return low+1;
    }

    public static void main(String[] args) {
	// write your code here
        int[] arr = new int[] {1,2,4,5};
        System.out.println("Missing element is " + searchMissingElement(arr));
    }
}

