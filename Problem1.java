//Find Missing number
//Time Complexity : O(logN)
//Space Complexity : O(1)
public class Problem1 {
    public static int findMissingNumber(int[] ar, int size) {
        //null check
        if(ar == null || size == 0) return -1;
        //if first element is missing
        if(ar[0] != 1) return 1;
        // if last element is missing
        if(ar[size-1] != size+1) return size+1;
        //if the other elements apart from first and last are missing. Here we are going for BS
        int low = 0;
        int high = size-1;
        while(high-low > 1) {
            int mid = low + (high-low)/2;
            int lowerIndexDiff = ar[low] - low;
            int midIndexDiff = ar[mid] - mid;
            if(lowerIndexDiff != midIndexDiff) {
                // higher side is sorted
                high = mid;
            } else {
                //lower side is sorted
                low = mid;
            }
        }
        return ar[low] +1;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        int[] ar = {1,2,3,5,6,7};
        int size = ar.length;
        System.out.println("Missing Number: "+ findMissingNumber(ar, size));
    }
}
