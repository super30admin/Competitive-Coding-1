class Problem1{
    public static void main(String[] args){
        Problem1 problem1 = new Problem1();
        int[] arr = {1,2,3,4,6,7,8};
        System.out.println("Missing element is: " + problem1.findMissingElement(arr));
    }
    private int findMissingElement(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        /*Logic: Perform binary search and match the current value with index.
        * If index and value don't match search left else search right. */
        int low = 0; int mid; int high = nums.length - 1;

    //        Edge cases resolution
        if(nums[low] != 1) return 1;
        else if (nums.length > 1 && nums[high] != high + 1 && nums[high - 1] == high){
            return nums.length; // Could also return high + 1
        }
//        Begin binary search
        while(low <= high) {
            mid = low + (high - low) / 2;
//            Missing element found
            if(nums[mid] > (mid + 1) && nums[mid - 1] == mid){
                return mid + 1;
            }
            else if(nums[mid] == mid + 1){
//                Consistent till now so search right
                low = mid + 1;
            }
//            Search left
            else high = mid - 1;
        }
//        If there is no missing element
        return -1;
    }
}
