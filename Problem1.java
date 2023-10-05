// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

/**
 * Given 1 # is missing => so the size of nums will be n-1
 * expected size = n
 * 
 * Brute:
 * a. run a loop from 1 to n
 * b. check if the num exists at the num-1 index
 * c. if no => missing # found
 * TC: O(n)
 * SC: O(1)
 * 
 * Optimization:
 * from O(n) -> O(log n) -> we're searching in a sorted space and we need to
 * reduce the TC to O(log n) => Apply Binary Search
 * 
 * a. sorted search space == [1, n]
 * b. if(nums[mid - 1] != mid) => missing # found
 * c. reduce the search space:
 * 1. left reject: if left size == expected left size => nums[mid-1] -
 * nums[lo-1] == mid - lo => update lo = mid+1
 * 2. right reject: if right size == expected right size => nums[hi-1] -
 * nums[mid+1] == hi - mid => update hi = mid-1
 */
public class MissingElement {

    /**
     * TC: O(log n) <br>
     * SC: O(1)
     */
    public int findMissing(int[] nums, int n) {
        // Binary Search
        int lo = 1;
        int hi = n;
        int mid;

        int answer = -1;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            // base case
            if (nums[mid - 1] != mid) {
                // missing found
                // answer = mid;
                // break;
                return mid;
            }
            if (nums[mid - 1] - nums[lo - 1] != mid - lo) {
                // move to left
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 8 };
        int n = 8;

        MissingElement obj = new MissingElement();
        int missingElement = obj.findMissing(nums, n);

        System.out.println(missingElement);
    }

}
