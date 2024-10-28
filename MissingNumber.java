// array is sorted and we have to find out the missing number
//Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
//Output : 5
//
//
//Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
//Output : 7

// we can imply that if it is a continous array then nums[i] = i + 1. Where ever this condition is not true we will get the misiinig element

public class MissingNumber {
    public int findMissingNumber(int [] nums){
        int low =0, high = nums.length; // since 1 element is missing

        while(low <= high){ // search if the missing value is on the left half
            int mid = low +(high - low)/2;
            if(nums[mid] == mid + 1){// then move to right
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return low +1 ;
    }
    public static void main (String [] args){
        MissingNumber finder = new MissingNumber();

        int[] nums1 = {1, 2, 3, 4, 6, 7, 8};
        System.out.println("Missing number: " + finder.findMissingNumber(nums1)); // Output: 5

        int[] nums2 = {1, 2, 3, 4, 5, 6, 8, 9};
        System.out.println("Missing number: " + finder.findMissingNumber(nums2)); // Output: 7
    }
}
// time complexity O(log n)
// space complexity - O(n)