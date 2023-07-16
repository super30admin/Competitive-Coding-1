public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber missingNumber =new MissingNumber();
            System.out.println(missingNumber.missingNumber(new int[]{1,2,3,4,5,6,8,9}));
    }

    private int missingNumber(int[] nums) {
        int size=nums.length;
        if (nums[0] != 1)
            return 1;
        if (nums[size - 1] != (size + 1))
            return size + 1;

        int low = 0, high = size - 1;
        int mid = 0;
        while ((high - low) > 1) {
            mid = (low + high) / 2;
            if ((nums[low] - low) != (nums[mid] - mid))
                high = mid;
            else if ((nums[high] - high) != (nums[mid] - mid))
                low = mid;
        }
        return (nums[low] + 1);
    }

}
