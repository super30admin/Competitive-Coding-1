namespace Algorithms
{
    // Did this code successfully run on Leetcode : Could not find the specific problem on leetcode, but ran this on my system to verify
    // Any problem you faced while coding this : It took a while to come up with binary search solution. I started with wrong condition
    // for checking the mid and ran into issues. 
    public class MissingElement
    {
        //Brute Force Approach
        //Time Complexity - O(n) - As we are iterating throught the whole array once atleast
        //Space Complexity - O(1) - Since we are not using any extra space
        public int FindMissingElement(int[] nums)
        {
            for (int i = 0; i < nums.Length; i++)
            {
                if (!(nums[i] == nums[i + 1] - 1))
                {
                    return nums[i + 1] - 1;
                }
            }
            return -1;
        }

        //Using extra array
        //Time Complexity - 2O(n) which eventually goes down to O(n) - Once for iterating through new array and old array
        //Space Complexity - O(n) - Since we have taken additional array for comparision
        public int FindMissingElementExtraArray(int[] nums)
        {
            var lastElem = nums[nums.Length - 1];

            var tempArr = new int[lastElem];

            //Initialize the temp array
            for (int i = 0; i < nums.Length; i++)
            {
                tempArr[i] = i + 1;
            }

            //Compare the temp array and return the first mismatched element
            for(int i = 0; i < nums.Length; i++)
            {
                if (nums[i] != tempArr[i]) return tempArr[i];
            }
            return -1;
        }

        //Using Binary Search
        //Time Complexity - O(logn) - Since we are reducing the search space by half
        //Space Complexity - O(1) - Since we are not using any extra space
        public int FindMissingElementBinarySearch(int[] nums) //[1, 2, 3, 5, 6, 7]
        {
            var left = 0;
            var right = nums.Length - 1;
            while(left <= right)
            {
                var mid = left + (right - left) / 2;
                // If mid is not equal the element in mid, then that means the missing element lies on the left part of the array
                if (nums[mid] != mid)
                {                    
                    if(nums[mid-1] + 1 != mid)
                    {
                        return mid;
                    }
                    //Since we are searching on the left part of the array
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
