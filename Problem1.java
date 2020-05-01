class Problem1{

    public static int missingNumber(int[] nums){ 
        int left = 0;
        int right= nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(nums[mid-1] == mid && nums[mid]!=mid+1)
            return mid;
            else if(nums[mid] == mid+1)
            left = mid+1;
            else right = mid-1;

        }
            return -1;
         
    }
    public static void main(String args[]){
        int nums[] = new int[]{1,2,3,4,6,7,8};
        System.out.println(missingNumber(nums));
    }
}
