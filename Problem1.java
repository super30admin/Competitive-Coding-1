// Time Complexity: O(logn)
// Space complexity: O(1)

public class Main {
    private static int findMissingNum(int[] arr){
        int low=0;
        int high= arr.length-1;
        while(high-low>=2){
            int mid = low + (high-low)/2;
            if(arr[high]-high==arr[mid]-mid)
                high = mid;
            else
                low = mid;
        }
        return (arr[low]+arr[high])/2;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,5,6,7,8};
        System.out.println("Missing num is: "+findMissingNum(arr));
    }
}
