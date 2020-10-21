// Time Complexity : O(log N) where N is the length of the array
// Space Complexity : O(N) where N is the length of the array

/*Approach
 * We will use the binary search to reduce our search space by half for each iteration and check position of mid with respect to its value
 * to find which side of mid of the array number is missing. */

public class MissingNumberInSortedArray {

    public static int getMissingElement(int []arr){
        if(arr==null || arr.length==0){
            return -1;
        }

        int low=0, high=arr.length-1;

        while(low<=high){
            int mid = low + (high - low)/2;

            if(arr[mid]==mid+1){//left side of the array is ok ie no missing element
                low = mid+1;
            }
            else {
                // missing element on the left side
                high = mid-1;
            }
        }
        return low+1;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,4,5,6,7,8};
        System.out.println( "Missing element : "+getMissingElement(arr));
    }
}