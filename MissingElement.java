// Time Complexity : O(log(n)) --> where n in size of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MissingElement {

    public int findMissingELe(int nums[]) {

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (high - low >= 2) {
            mid = low + (high - low) / 2;

            if ((nums[low] - low) != (nums[mid] - mid)) high = mid;
            else low = mid;
        }
        return (nums[low] + nums[high]) / 2;
    }

    public static void main(String[] args) {
        MissingElement el = new MissingElement();
        int arr[] = new int[] {3, 4, 5, 6, 8, 9};
        int missingEle = el.findMissingELe(arr);
        System.out.println(missingEle);

    }
}

