package com.algorithms.week1;

//Find missing element
public class Problem1 {

    int searchMissingElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 ){
            if(nums[0] == 1){
                return -1;
            }
            return 1;
        }

        int low =0, high =nums.length -1;

        while(high>=low){
            int mid = low + (high - low)/2;
            if((mid==0 || nums[mid] == nums[mid-1] + 2) && (mid==nums.length-1 || nums[mid] == nums[mid+1]-1)){
                return nums[mid]-1;
            }

            if(nums[mid]==mid+1){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        FindMissingElement m = new FindMissingElement();
        System.out.println(m.searchMissingElement(new int[]{1,2,3,4}));
    }
}

