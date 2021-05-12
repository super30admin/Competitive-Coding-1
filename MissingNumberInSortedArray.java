
/*

Thought Process: Use XOR to find the missing number
Eg: 2^2 = 0

If we have [1,2,4] => (nums.length + 1) ^ (1 ^ 1) ^ (2 ^ 2) ^ (4 ^ 3)
                   => 4 ^ (0) ^ (0) ^ (4 ^ 3)
                   => (0) ^ (0) ^ 3 ^ (4 ^ 4)
                   => 0 ^ 0 ^ 3 ^ 0
                   => 3
So we find the missing number 3

T.C => O(N)
S.C => O(1)

*/

public class MissingNumberInSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,9};
        int[] nums2 = {1,3,4};
        int[] nums3 = {1,2,3,4,6};
        System.out.println("Test1 : Expected - 8 :: Actual - " + missingNumber(nums1));
        System.out.println("Test2 : Expected - 2 :: Actual - " + missingNumber(nums2));
        System.out.println("Test3 : Expected - 5 :: Actual - " + missingNumber(nums3));
    }
    
    public static int missingNumber(int[] nums) {
        if(nums.length == 0 || nums == null) return -1;
        
        int missingNumber = nums.length+1;
        for(int i=0; i< nums.length; i++){
            missingNumber ^= nums[i] ^ (i+1);
        }
        return missingNumber;
    }

}