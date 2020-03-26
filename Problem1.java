// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

import java.util.HashSet;
import java.util.Set;

public class Problem1 {

    public static void main(String args[]){
        int[] nums = new int[]{2,3,5,1};
        System.out.println(findMissingInteger(nums));
        System.out.println(findInNonSortedArrayUsingXor(nums));
    }

    // If array is sorted, we can use binary search and do it in O(log(n)) time and O(1) space
    private static int findMissingInteger(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){

            int mid = low + (high - low)/2;
            if(nums[mid] == (mid+1)){
                low = mid + 1;
            } else{
                high =  mid -1;
            }
        }

        return low+1;
    }

    // If array is not sorted, we can use simple set method and do it in o(n) time and O(n) space
    private static int findInNonSortedArray(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        for(int i=1; i<= nums.length+1; i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }

    // If array is not sorted, we can use xor method and do it in o(n) time and O(1) space

    private static int findInNonSortedArrayUsingXor(int[] nums){
        int xor1 = nums[0];
        int xor2 = 0;

        for(int i=1; i< nums.length; i++){
            xor1 = xor1 ^ nums[i];
        }

        for(int i=1; i<= nums.length +1 ; i++){
            xor2 = xor2 ^ i;
        }

        return xor1^xor2;
    }
}