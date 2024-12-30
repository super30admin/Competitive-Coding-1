/**
 * Given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list.
 * One of the integers is missing in the list. Write an efficient code to find the missing integer.
 *
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 * Ran on Leetcode? Yes
 * Problems faced: None
 */
public class FindMissingElementInSortedArray {
    public int findFirstMissingElement(int[] nums) {
        int low = 0;
        int offset = nums[low]; // offset is to determine what number the element begins from

        // Since the problem requires first number to be 1, if 1 is not present, then the first missing is 1
        if (offset > 1)
            return 1;

        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int value = nums[mid];
            int expected = mid + offset;

            // since we are looking at a sorted array,
            // it is not possible that the value at index is less than index + offset
            // therefor if value is correctly placed i.e. if value == expected,
            // check on the right side of mid else if it is greater check on the left side of mid
            if (value == expected) {
                low = mid + 1;
            } else if (value > expected) {
                high = mid - 1;
            }
        }
        // low will keep track of the index that has element missing,
        // adding offset to low will provide the missing element
        return low + offset;
    }


    public static void main(String[] args) {
        FindMissingElementInSortedArray obj = new FindMissingElementInSortedArray();
        int[] arr = {3, 4, 7, 9, 10};
        int result = obj.findFirstMissingElement(arr);
        System.out.println("result: " + result);
        assert (result == 1);

        arr = new int[]{1, 2, 3, 4, 7, 9, 10};
        result = obj.findFirstMissingElement(arr);
        System.out.println("result: " + result);
        assert (result == 5);
    }
}
