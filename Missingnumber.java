/*this implementation uses binary search algorithm to
* find the missing number in a sorted list of numbers
* the time complexity of this implementation is O(log n)*/
public class Missingnumber {

    public static int findMissingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] != mid + 1 && nums[mid - 1] == mid) {
                return mid + 1;
            } else if (nums[mid] != mid + 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6};
        int missingNumber = findMissingNumber(nums);
        System.out.println(missingNumber);
    }

}
