// Time Complexity : O(logn)
// Space Complexity :O(1) 
class Solution{
    public int missingsearch(int nums[]){
        //edge case if its first element
        if(nums[0]!=1){ return 1;}
        //edge case 2 if the last element is missing
        if(nums[nums.length-1]!=nums.length) return nums.length+1;
        int l=0, h=nums.length-1;
        while(h-l>1){
            int mid=l+(h-1)/2;
            //if diff btwn mid and index of mid is not equal to  
            //diff btwn low and index of low means the element is in left half 
            if(nums[mid]-mid != nums[l]-l){
                l=mid;
            }
            //else the element is in right half
            else if(nums[mid]-mid!=nums[h]-h){
                h=mid;
            }
        }

        return nums[l]+1;
    }
}