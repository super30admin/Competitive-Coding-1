
public class Problem1MissingElement {
    private int missingElement(int nums[]) {
        int low =0; int high=nums.length-1;
        while(high-low>=2) {
            int mid = (low+high)/2;
            int diff1 = nums[low]-low;
            int diff2 = nums[mid] - mid;
            if(diff2 != diff1){
                high = mid;
            } else {
                low = mid;
            }
        }
        return nums[high]-1;
    }
}