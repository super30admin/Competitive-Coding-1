// Time Complexity: O(log(n))
// Space Complexity: O(1)


public class FindMissingNumber{
    public static int missingNumber(int arr[]){
        int low = 0;
        int high = arr.length-1;
        while(low+1<high){
            int mid = low + (high-low)/2;
            if(arr[mid] == mid+1){
                low = mid;
            }else{
                high = mid;
            }
        }
        return arr[low]+1;

    }
    public static void main(String args[]){
        int[] arr = {1,2,3,5,6,7};
        int missing = missingNumber(arr);
        System.out.print("Missing Number = " + missing);
    }
}