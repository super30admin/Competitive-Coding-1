// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Return mid-1 if the diff between the mid and index of the mid element is 2 and the diff between mid and mid-1 element to be 2
// If not, find in the left half if diff between mid and index of mid element is 2 ,
// else find in the right half if the diff between mid and index of the mid element is 1


public class FindMissingNumber {
    public int findMissingNum(int[] a){
        int low = 0;
        int high = a.length-1;
        int diff = a[low];
        while(low<=high){
            int mid = low +(high-low)/2;
            if(a[mid] - mid == diff){
                low = mid+1;
            }else if(a[mid] - mid == diff+1){
                if(a[mid] - a[mid-1] ==2 ){
                    return a[mid]-1;
                }
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a = {3,4,5,6,7,8};
        FindMissingNumber fmn = new FindMissingNumber();
        System.out.println("Missing num "+fmn.findMissingNum(a));
    }
}

