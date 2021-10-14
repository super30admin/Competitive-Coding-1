// Time complexity is O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode: NA
// Any problem you faced while coding this:
using System;

namespace competitive_coding
{
    //Find the Missing Number in a sorted array
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[]{2, 3, 4, 5, 6, 7, 8};

            int left = 0;
            int right = arr.Length - 1;
            while(left <= right) {
                int mid = left + (right - left )/2;
                if( (arr[mid] - mid) > 1 ){
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            }
            System.Console.WriteLine(arr[left] - 1);
        }
    }
}
