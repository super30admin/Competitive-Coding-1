package s30Coding;
import java.util.*;

//Time Complexity :- O(n)
//Space Complexity :- O(n)

//LeetCode :- Yes

public class FindMissingNumber {
	public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
}
