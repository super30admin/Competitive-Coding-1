//time: O(log N)
//space: O(1)
public class Problem1 {

    static int search(int nums[])
    {
        // Extreme cases
        if (nums[0] != 1)
            return 1;
        if (nums[nums.length - 1] != (nums.length + 1))
            return nums.length + 1;

        int l = 0, h = nums.length - 1;
        int mid = 0;
        while ((h - l) > 1) {
            mid = (l + h) / 2;
            if ((nums[l] - l) != (nums[mid] - mid))
                h = mid;
            else if ((nums[h] - h) != (nums[mid] - mid))
                l = mid;
        }
        return (nums[l] + 1);
    }

    public static void main(String[] args){
        System.out.println("missing number "+search(new int[]{1, 2, 3, 4, 6, 7, 8}));
    }
}