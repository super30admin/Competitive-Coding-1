// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//Approach: Since the array is sorted we can find the difference of the value and its index.
//if the diff is greater than 1 and the difference between that element and its previous element is also >1.
//then that is the place where the element is missing so we return the index. If the diff between the elements and its previous is equal to 1 
//and not > 1 then it we keep going left since the answer lies on the left. In any other case we go right.
public class Problem1{
    
    public int search(int nums[]){
        int low =0;
        int high = nums.length-1;
        int midvalue = low + (high-low)/2;
        if(midvalue==0)return midvalue+1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if((nums[mid] - mid) >1 && nums[mid] - nums[mid-1] >1){
                return mid +1;
            }else if(nums[mid] - mid >1  && nums[mid] - nums[mid-1] == 1){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return (midvalue +1);
    }
    public class Main {
        public static void main(String[] args) {
            int [] nums = new int [] {1,2,4,5,6,7,8,9};
            Problem1 s = new Problem1();
            int element = s.search(nums);
            System.out.println(element);
        }
    }
}
