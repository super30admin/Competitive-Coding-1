// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//leetcode 702
class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=low+1;
        while(reader.get(high)<=target){
            if(reader.get(high)==target){
                return high;
            }
            else if(reader.get(high)<target){
                low=high;
                high=high*2;
            }
        }
        int index= binarySearch(reader,low,high,target);
        return index;
    }
    int binarySearch(ArrayReader reader, int low, int high,int target){
        while(low<=high){
        int mid=low + (high-low)/2;
            int midValue=reader.get(mid);
        if(midValue==target){
            return mid;
        }
        else if(midValue<target){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
        }
        return -1;
    }
}