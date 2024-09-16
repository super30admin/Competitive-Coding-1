// TC: O(log(n))
// SC: O(1)


public class Main {
   public static void main (String[] args)  {
    int ar[] = { 1,2,3,4,6,7,8,9 };
    int size = ar.length;
    System.out.println("Missing number: " +
    search(ar, size));
    }
    public static int search(int[] arr, int size) {
        int low = 0;
        int high = size - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(arr[mid] - mid > 1) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return arr[high]-1;
    }
}
