// Overall Time Complexity : O log(n) . The n is number of elements in the search space.
// Overall Space Complexity : O(1) . The space complexity of storing the values in variables like low, high uses constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The solution to the problems involves identifying whether the missing element is on the right side or left of the sorted array.
// This is achieved by checking if  nums[mid] matches mid + 1, then the missing number is on the right else its left.

class MissingNumber {
    private static int missing_number(int nums[]){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
         if (nums[0] != 1) // Case to handle if the first element is missing
            return 1;

        if (nums[n - 1] != (n + 1)) // Case to handle if the last element is missing
            return n + 1;
            
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(nums[mid]!=mid+1){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
            
        }
        return low+1;
        
        
    }
    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,8};
        int res = missing_number(nums);
        System.out.println("The missing number is "+res);
    }
}
