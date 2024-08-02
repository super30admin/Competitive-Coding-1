//TC: O(log N)
//SC: O(1)
//Approach: Each index value should be index +1. The missing element lies in the unbalanced side of the array. move the subarray to the part where sum of mid and extreme pointers are not sum of their index +2.

/**
 * Missing element in a sorted array
 */
public class Problem1 {
    public static int missingElement(int[] nums){
        int n= nums.length;

        if (n == 0) return -1;
        if(nums[0] != 1) return 1;
    
        int l = 0; int r = n-1;
        while (l<=r) {
            int mid = l + (r-l)/2;
            if(nums[mid] != mid+1) return mid+1;
            else if( nums[l] + nums[mid] == l + mid + 2) l = mid +1;
            else r = mid -1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5};
        System.out.println(missingElement(nums));
    }
}
