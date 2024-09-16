/*
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list,
One of the integers is missing in the list. Write a code to find the missing integer.
Examples:
Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4
Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3

Time Complexity: O(log(n))
Space Complexity: O(1)
Code run on Leetcode: N/A
Any difficulties: Was able to do it from brute force, was not able to implement this using binary search in the mock
interview
Approach: referred video of S30 founder's solution
 */

public class FindMissingElement {
    public static int findMissingElement(int[] nums){
        int left = 0;
        int right = nums.length-1;

        while((right-left)>=2){
            int mid = left+(right-left)/2;

            int valueAtMidIndex = nums[mid];
            int valueAtExtremeLeftIndex = nums[left];
            /*
             [1,2,3,5,6,7] -> corresponding indexes [0,1,2,3,4,5]
             the difference between the indices and the value at the index for this contiguous number array is 1
             till we encounter an missing element index, in that case we will move respective side of the array to find
             out the missing element
             */

            if((valueAtMidIndex-mid)!=(valueAtExtremeLeftIndex-left)){
                right = mid;
            }else{
                left = mid;
            }
        }
        return (nums[left]+nums[right])/2;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,5,6,7};
        System.out.println("Missing element: "+findMissingElement(arr));
    }
}
