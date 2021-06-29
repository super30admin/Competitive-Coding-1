// Java program to find missing Number
//Time Complexity: O(logN)
//Space Complexity: O(1);
class GFG {

    public static int findMissingNumber(int[] nums){
        if(nums == null || nums.length == 0){
            return 1;
        }

        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = low + (high - low)/2;
            if((nums[mid]-mid)>1){
                //left subarry
                high = mid -1;
            } else if ((nums[mid]-mid) == 1){
                //right subarry
                low = mid +1;
            }
        }
        return low+1;
    }

    public static void main(String[] args)
    {
        int[] a = {1, 2, 4, 5, 6};
        System.out.println(findMissingNumber(a));
    }
}
