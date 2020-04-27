//Time Complexity : O(logn)
//Space Complexity : O(1) No auxilary space used
// Not sure if its on leetcode
// Problems :  Understanding the error in index and which element to return after loop ends.


/*
There will be an error with the index if an element is missing.
Using binary search we'll halt when left pointer and right pointer cross eachother
Our element will be between those two pointers
 */

public class Competitive_Coding_1_Problem_1 {
    public static int FindMissing(int[] nums)
    {
        if(nums == null || nums.length==0) return -1;
        else if(nums[nums.length-1]==nums.length)return -1;
        int left = 0;
        int right = nums.length -1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] == mid + 1)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return (nums[left]+nums[right])/2;
    }

    public static void main(String[] args) {
        int ar[] = { 1,2,3,5,6,7};
        System.out.println(FindMissing(ar));
    }
}
