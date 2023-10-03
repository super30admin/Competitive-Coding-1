//find Missing element from sorted array [0,..,n]
// Time Complexity :O(log n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : nope

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    int[] nums1 = {1,3,4,5,6,7,8,9};  
        System.out.println(findMissing(nums1) == 2 ? "Test Case 1 Passed" : "Test Case 1 Failed");  
        
        int[] nums2 = {1,2,3,4};  
        System.out.println(findMissing(nums2) == 5 ? "Test Case 2 Passed" : "Test Case 2 Failed");  
  
        int[] nums3 = {1};  
        System.out.println(findMissing(nums3) == 2 ? "Test Case 3 Passed" : "Test Case 3 Failed");  

        int[] nums4 = {1,2,3,4,5,6,7,9};  
        System.out.println(findMissing(nums4) == 8 ? "Test Case 4 Passed" : "Test Case 4 Failed");  


    }
    
    public static int findMissing(int[] nums){
        int l = 0;
        int n = nums.length -1;
        int r= n;
        if(nums.length ==1)return 2;
        if(nums[n] == n+1) return n+2;
        while(l<=r){
            int mid = l + (r-l)/2;
           if ( mid ==n || nums[mid] == mid+2 && 
                (mid ==0 || nums[mid-1] == mid )){     
               return mid+1 ;
            }
            else if(nums[mid] == mid+1) 
                l = mid+1;
            else r= mid-1;
        }
        
        return -1;
    }
    
    
    
    
}
