//Time Comp: O(log(N)) Binary Search
//Space: O(1) no extra space used

//Problems faced: I couldn't figure out to manipulate low and high in the binary search algo during my interview.

class Solution {
    public int findMin(int[] nums) {
       if(nums == null || nums.length == 0)
           return -1;
        
        int low = 0; 
        int high = nums.length -1;
        
        int beforeMin = findBeforeMin(nums, low, high);
        
        return beforeMin+1;
        
    }
    
    private int findBeforeMin(int[] nums, int low, int high){
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if(mid-1 >= 0 && nums[mid] - nums[mid-1] == 2) return nums[mid-1];
            
            if(mid+1 <= nums.length-1 && nums[mid+1] - nums[mid] == 2) return nums[mid];
            
            if(nums[low] - low != nums[mid] - mid){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            
        }
        return -1;
    }
    }
