// Time Complexity :O(log(n)) since we are dividing the search space in halves.
// Space Complexity :O(1) since no extra space is required.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

import java.util.HashMap;
import java.util.List;

public class FindMissing {

    public int missingNumber(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] > m + 1)
                r = m;
            else
                l = m + 1;
        }
        return r + 1;
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 2, 3, 4, 5, 6, 7 };

        FindMissing test = new FindMissing();

        System.out.println(test.missingNumber(arr));

    }

}