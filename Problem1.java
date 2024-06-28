
public class Main
{
    static public int binarySearch(int[] nums){
        int left =0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[left]==left+1 && nums[mid] == mid+1){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left] - 1;
    }
    public static void main(String[] args) {
        int [] nums = new int[]{3};
        int res = binarySearch(nums);
        System.out.println(res);
    }
}