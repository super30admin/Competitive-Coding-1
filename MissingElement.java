// Time Complexity: O(log n)
// Space Complexity: O(1)
//approach:// Given a sorted array of consecutive integers starting from 1 with one missing number.
// Using binary search, we find the first index where the value doesn't match the expected (i + 1).
// This mismatch indicates that all numbers before are correctly placed, and the missing number is here.
// We return low + 1 because the missing value should have been at that index in a perfect sequence.

class Missing{
    public static  int missingElement ( int [] nums){
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==mid+1){
                low=mid+1;
            } else{
                high=mid-1;
            }
        }
        return low+1;

    }
    
}

class Main{
 public static void main(String[] args){
    int nums []={1,2,3,4,6,7,8};

    System.out.println( Missing.missingElement(nums));

 }
}