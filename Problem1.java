// Time Complexity: O(log n), where n is the number of elements in the input array nums.
//                    Binary search is used, which halves the search space in each iteration.
// Space Complexity: O(1), constant space is used, no additional data structures are employed.
// Approach: Utilized binary search to find the missing element. 
//           Calculates the number of missing elements before the midpoint of the array.
//           Adjusts the search based on whether the missing elements are less or greater than k.
//           Returns the missing element once the search is narrowed down to a single element.
//leetcode link: https://leetcode.com/problems/missing-element-in-sorted-array/

class Solution
{
    public int missingElement(int[] nums, int k) 
    {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        int missingNum = 0;

        while(start <= end)
        {
            mid = start + (end - start)/2;
            missingNum = nums[mid] - nums[0] - mid;

            if(missingNum < k)
            {
                start  = mid + 1;
            }

            else
            {
                end = mid - 1;
            }
        }
        
        missingNum = nums[end] - nums[0] - end;
        return nums[end] + k - missingNum;       
    }
}
