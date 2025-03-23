
// Time Complexity : O(log n) n is array size
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Check if mid element and its previous element has difference 2. 
// 2. if fisrt element is not 0 return its missing.

class Solution {
public:
    int bin(vector<int>& nums,int f,int l){
        int mid = f + (l-f)/2;
        if(f>l){
            return l+1;
        }
        if ( (mid > 0) && (nums[mid] - nums[mid-1] == 2) ) {
            return nums[mid]-1;
        }
        else if( nums[mid]==mid){
            return bin(nums,mid+1,l);
        }else{
            return bin(nums,f,mid-1);
        }
        return l+1;
    }
    int missingNumber(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int f=0,l=nums.size()-1;
        return bin(nums,f,l);
    }
};