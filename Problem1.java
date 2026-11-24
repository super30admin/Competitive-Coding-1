// Time Complexity : O(log n), (n is the numbers in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : couldnt find it in leetcode
// Any problem you faced while coding this : nothing


public class Main {
    public static int findMissingNumber(int[] arr){
        int lo = 0 ;
        int hi = arr.length-1;

        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]==mid+1){
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return lo+1;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] arr1 ={1,2,3,5,6,7};
        int missingNum = findMissingNumber(arr);
        System.out.print("missing number in arr1 - "+ missingNum);
        int[] arr2 ={1,2};
        int missingNum = findMissingNumber(arr);
        System.out.print("missing number in arr2 - "+ missingNum);
    }
}