import java.io.*;
import java.util.*;
Complexity Time: O(log n)
Space: O(1)
class GFG {
    private int findMissingElement(int [] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] != mid + 1) {
                if(mid == 0 || nums[mid - 1] == mid) {
                    return mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return - 1;
    }
	public static void main (String[] args) {
		GFG s = new GFG();
		int res= s.findMissingElement(new int[]{2});
		System.out.println(res);
	}
}
