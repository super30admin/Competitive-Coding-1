public class MissingNumberSortedArray
    {
       // Time Complexity : O(log n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Not available
        // Any problem you faced while coding this : Yes it was difficult to come up with the base case logic arr[low] + arr[high]) / 2 to return missing number. It was clear after watching the solution video

        public int MissingNumber(int[] arr)
        {
            if (arr == null || arr.Length == 0) return 0;

            int low = 0;
            int high = arr.Length - 1;
            if (arr[low] != 1)
                return 1;
            if (arr[high] != arr.Length - 1)
                return arr.Length + 1;
            
            while(high - low >= 2)
            {
                int mid = low + (high - low) / 2;
                if(arr[low] - low != 1 && arr[mid] - mid != 1)
                {
                    high = mid;
                }
                else
                {
                    low = mid;
                }
            }
            return (arr[low] + arr[high]) / 2;
        }
}
