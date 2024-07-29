public class MissingElementInSortedArray{

    private static int findMissingElement(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid==0 || nums[mid] - nums[mid-1]>1) || nums[mid+1]-nums[mid]>1){
                return mid+1;
            }
            else if(nums[mid]==mid+1){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,4,5,6,7};
        int result = findMissingElement(nums);
        System.out.println("The Missing ELement is: " + result);
    }
}
