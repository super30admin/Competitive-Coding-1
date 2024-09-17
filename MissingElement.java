/* Problem: Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
Time Complexity: O(log N)
Space Complexity: O(1)

Explanation: We use binary search to eliminate half of the array each time. 
The elements appearing before the missing elemenet will have ar[i]-i=1 and 
those appearing after missing elelment will have ar[i]-i=2
*/

public class MissingElement {
    static int search(int nums[], int size){
        int low = 0, high = size-1, mid=0;
        while(high - low >= 2){
            mid = low + (high-low)/2;
            int midIdxDiff = nums[mid]-mid;
            int lowIdxDiff = nums[low]-low;
            if(midIdxDiff != lowIdxDiff){
                high = mid;
            } else {
                low = mid;
            }
        }
        return (nums[low]+nums[high])/2;
    }
}
