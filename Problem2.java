/*

RunTime complexity - O(logn) as we are doing binary search to look for the missing element
Space complexity - O(1) as we dont have any additional storage

The idea is not take the mid element and compare it with value mid, if they are not equal it means there is a value missing on the left. Otherwise the missing element is towards the right.
*/

public class missingElement {
    public int missingelements(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 1;
        if (n == 1)
            return nums[0]==1?2:1;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == (mid + 1))
                left = mid+1;
            else
                right = mid - 1;
        }
        return left + 1;
    }

    public static void main(String[] args)
    {
        missingElement m=new missingElement();
        int[] arr={1,2,3,4,5,6,7,8,10};
        int n=m.missingelements(arr);
        System.out.println("Missing element : "+n);
    }
}
