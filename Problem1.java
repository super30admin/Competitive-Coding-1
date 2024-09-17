//Problem : missing-number
//https://leetcode.com/problems/missing-number
//Was able to solve in interview in most optimal way

class Solution {
    
    //Time Complexity: O(n)
    //Space COmplexity: O(1)
    //calculate sum of nums array and also use n(n+1)/2 to get expected sum missing no wull be difference in sums
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        int asum = 0;
        for(int t: nums) {
            asum += t;
            
        }
        
        return sum-asum;
    }
    
    //Time Complexity: O(n)
    //Space COmplexity: O(1)
    //xor of number with itself is 0. use this to xor numbers and indexes
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i=0;i<n;i++) {
            xor = xor ^ nums[i] ^ (i+1);
            
        }
        
        return xor;
    }
    
    //Time Complexity: O(nlogn)
    //Space COmplexity: O(1)
    // Sort the array and perform binary search
    public int missingNumber3(int[] nums) {
		
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length-1;

        while(low<high) {

          int mid = low + (high-low)/2;

          if(nums[mid] != mid) {
            high = mid;
          } else {
            low = mid+1;
          }
        }
        return low;
	  }
}
