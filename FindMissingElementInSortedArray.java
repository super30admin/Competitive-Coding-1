public class FindMissingElementInSortedArray {
    public int findMissingElement(int[] nums){
        int start=0, end = nums.length-1, mid=0;
        while(start<=end){
            mid = start + (end-start)/2;
            if(nums[mid] != mid+1  && nums[mid-1] == mid) return nums[mid]-1;
            else if(nums[mid] - mid == 1){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        FindMissingElementInSortedArray obj = new FindMissingElementInSortedArray();
        int[] nums = new int[]{1,3,4,5,6,7,8,9};
        int res = obj.findMissingElement(nums);
        System.out.println("res = " + res);
    }
}
