/*
You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in the list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
Example: 

Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
Output: 5
Explanation: The missing number from 1 to 8 is 5

Input: arr[] = {1, 2, 3, 5}
Output: 4
Explanation: The missing number from 1 to 5 is 4

Comnplexity: Time:  O(logN)
Space: O(1)

*/

class FindMissingNumber
{
    int searchMissingNumber(int nums[])
    {
        int low = 0;
        int high = nums.length -1;
        
        while( high -low > 1)
        {
            
            int mid = low + (high - low)/2;
            
            int indicesDifference = mid - low;
            int numberDifference = nums[mid] - nums[low];
            
            if( indicesDifference != numberDifference)
                high = mid;
            else
                low = mid;
        }
        
        
        return (nums[low] + nums[high])/2;
    }
}
