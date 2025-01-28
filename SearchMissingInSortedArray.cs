// Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
// Examples:
// Input : arr[] = [1, 2, 3, 5, 6, 7, 8]

// Output : 4

// Input : arr[] = [1, 2, 4, 5, 6,7 , 8, 9]

// Output : 3

// time complexity - O(logn) where n is number of elements in array
// space complexity - O(1)
// approach - do a binary search. When the middle element value is equal to middle index+1 that means missing element is present in second half. so discard left half.

class Solution {   
    public static int SearchElement(int[] nums)
    {
        int low = 0;
        int high = nums.Length;
              
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if((mid == 0 && nums[mid]!=1) || (mid !=0 && nums[mid] != nums[mid-1]+1))
            {
                return nums[mid]-1;
            }
            else if(nums[mid] == mid+1)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }
    static void Main() {
        System.Console.WriteLine("Hello World!");
        int[] nums = {1,3};
        int element = SearchElement(nums);
        System.Console.WriteLine(element);
    }
}