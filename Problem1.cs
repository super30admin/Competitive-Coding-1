// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I perform binary search on the sorted array to find the missing element. Each element from the missing element to the last element
would differ from it's index by 2. If I find a middle element which satisfies the condition, I store the index and search on the left half
as there might exist more elements that differ from the index by 2. 
*/


class Solution
{
    public int missingNumber(int[] arr)
    {
        // code here
        int low = 0, high = arr.Length - 1;
        int result = arr.Length;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (arr[mid] - mid > 1)
            {
                result = mid;
                high = mid - 1;
            }

            else
            {
                low = mid + 1;
            }
        }


        return result + 1;
    }
}
