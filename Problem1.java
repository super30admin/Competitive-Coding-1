// "static void main" must be defined in a public class.
//Time complexity : O(logn) - Binery search on input array
//Space Complecity: O(1) - no new datastructure created
public class Problem1 {
    //{1,3,4,5,6,7,8,9}
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        // missingNum(nums);
        // public void missingNum(int[] nums){
            int low = 0;
            int high = nums.length-1;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(nums[mid]!=mid+1){  
                    // if(mid==0 && nums[mid]!=1) System.out.println(1);
                    // if(mid!=0 && nums[mid-1] == mid)   System.out.println(mid+1);
                    high = mid-1;
                } else{
                    low=mid+1;
                }
            }
             System.out.println(low+1);
    }
}