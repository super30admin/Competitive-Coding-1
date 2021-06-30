class Solution {
    public int search(int[] nums)
    {
    	
    	if(nums.length==0)
    		return -1;
    	int low=0;
    	int high=nums.length-1;
    	
    	while(low<=high)
    	{
    		int mid=low+(high-low)/2;
    		  
    		if(nums[mid]!=mid+1 && nums[mid - 1] == mid)
    			return mid+1;
    		if(nums[mid]==mid+1)
    			low=mid+1;
    		else
    			high=mid;
    			
    	}
    
        return -1;
    }
}
public class FindMissingNumber {
public static void main(String[] args) {
	Solution s=new Solution();
	int[] nums= {1,2,3,4,6,7,8};
	
	System.out.println(s.search(nums));
	
}
}
