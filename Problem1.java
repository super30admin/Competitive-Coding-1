

// Time Complexity : O(N) for Sum Formula XOR,,O(Log N) for Binary Search
// Space Complexity : O(1) for all operations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
We apply the sum formula ,xor anf binary search 
Sum Formula 
Sum of Array Numbers - Sum of Total Numbers in Array

XOR
XOR of Array Numbers ^ XOR of Array Indices

Binary Search

Difference Between Number and Its Index is 1.For Number after Missing Number 
this difference is greater than 1 .Keep checking for above
condition until 2 elements are left.Finally Avg of 2 Numbers is missing number
*/ 

    public class Problem1{

        public static int findMissingNumber(int nums[]){
            int low = 0,high = nums.length - 1;
            while(high - low >=2){
                int mid = low + (high - low) / 2;
                if((nums[mid] - mid) != (nums[low] - low)){
                    high = mid;
                }
                else if((nums[mid] - mid) != (nums[high] - high)) {
                    low = mid;
                }
            }
            return (nums[low] + nums[high] )/ 2;
        }
        public static void main(String args[]){
            int arr[] = {1, 2, 3, 5, 6, 7, 8};

            int xor1 = 0,xor2 = 0;
            int size = arr.length ;
            for(int i = 0; i < size; i++){
                xor1 ^= arr[i];
            }
            for(int i = 0; i <= size + 1; i++){
                xor2 ^= i;
            }
            int missing = xor1 ^ xor2;
            System.out.println("Missing Number is " + missing);
            System.out.println("Mising Number from Binary Search" + findMissingNumber(arr));

        }
    }