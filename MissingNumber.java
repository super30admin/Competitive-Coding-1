// Time Complexity O(N)
public class MissingNumber {
    public static int missingNumber(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low<= high){
            int mid = low + (high-low)/2;

            if(arr[mid+1] != arr[mid] +1 ){
                return arr[mid] +1;
            }else if(arr[mid -1] != arr[mid] -1){
                return arr[mid] -1;
            }
            if(arr[mid] - arr[low] != mid - low){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 8};
        System.out.println(missingNumber(arr));
    }
}

