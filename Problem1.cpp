//TIME COMPLEXITY = O(logN)
//SPACE = O(1)

 int missingNumber(vector<int>& nums) {
        int low = 0;
        int high = nums.size()-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[mid]-mid == 2){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return nums[low]-1;
    }
