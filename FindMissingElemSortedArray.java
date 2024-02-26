
class FindMissingElemSortedArray {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low < high) {

            int mid = low + (high - low + 1)/2;
            int count = nums[mid] - nums[0] - mid;

            if(count < k) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return nums[0] + k + low;
    }
}