// Time Complexity : O(logn)
// Space Complexity : O(1)
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach.
/* 
 * 1. If there is no missing element, then the difference between the number and the index is 1.
 * 2. To calculate the mid, we leverage the above functionality.
 * 3. If the difference at middle element is 1, then missing element is on the right side of the array.
 * 4. If not, the missing element is on the left side of the array.
 * 5. We end up with low & high pointers pointing to the neighbors of the missing element.
 * 6. Once we have the neighbor pointers, we can just return the average of the elements at low & high indexes.
*/ 

class FindMissingNumber{

    public static int search(int[] nums){
        
        if(nums == null || nums.length == 0) return -1;

        int low = 0, high = nums.length-1;

        while(high-low > 1){
            int mid = low + (high-low)/2;

            if(nums[mid] - mid > 1){
                high = mid;
            }else{
                low = mid;
            }
        }

        return (nums[low]+nums[high])/2;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 6, 7, 8}));
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 8, 9}));
    }
}