public class FindMissingNumber {
    static int searchNum(int[] nums) { //{1,2,3,5,6,7,8}
        int n = nums.length; // 7
        int low = 0; // 0
        int high = n-1; // 7
        int index = -1; // -1

        while(low <= high) { // true
            int mid = (high - low) / 2 + low; // mid =  2
            if(nums[mid] - mid != 1) { // 3 - 2  = 1 false
                high = mid - 1; // high = 2
                index = mid; // index = 3
            } else {
                low = mid + 1; // 3
            }
        }

        return index; // 3
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4, 5,6,8};
        int ans = searchNum(arr) + 1;
        System.out.println("Missing Number :" + ans);

    }
}
