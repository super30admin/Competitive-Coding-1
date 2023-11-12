//Space Complexity=O(1)
//Time Complexity =O(logn)

public class Solution {
    public static void main(String args[]) {
      
      int nums[]={1,2,3,4,5,7};
      int res= missingNumber(nums);
      
      System.out.println(res);

      
    }
    
     public static int missingNumber(int[] nums) {
        int l=0,h=nums.length-1;
        

        while(l<=h)
        {
            int mid= l+(h-l)/2;

            if(nums[mid]-mid==1)
            l=mid+1;

            else
            h=mid-1;
        }
        return l+1;
    }
}
