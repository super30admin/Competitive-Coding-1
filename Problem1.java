/**
Problem :
Given a sorted array, from 1 to n, there's a missing number. Find the missing number if there exists one, else return -1

Solution(Approach) : Binary Search.
1. Start with left pointer starting at 0 and right pointer at n-1, where n is the length of the given array.
2. We can find if an element is missing, if the difference between the number in the array and its index is not 1.
3. To divide the search space into two, we try to find if the diff between mid element and its index is equal to 1
4. We also check if the first(left-most) and last(right-most) elements are in their correct positions based on the difference method stated above, and move accordingly.

Time Complexity : O(log n), where n is the number of elements.
Space Complexity : O(1)

Did it run on LeetCode : Yes
 */ 

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,4,5,6};
        System.out.println(missingNumber(nums)); //outputs 3
    }
    public static int missingNumber(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;

            // if it's the mid index that's missing, return it
            if(nums[mid] - mid != 1)
                return mid+1 ; 
            //left-side is proper, move right
            else if (nums[left] - left == 1 && nums[mid] - mid == 1) 
                left = mid + 1; 
            //right-side is proper, move left
            else if (nums[right] - right == 1 && nums[mid] - mid == 1)
                right = mid - 1;
            
        }
        return -1;
    }
}

