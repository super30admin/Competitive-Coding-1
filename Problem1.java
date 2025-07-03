class Problem1{
    public int findMiss(int[] nums){
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]-mid!=nums[0]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low + nums[0];

    }

    public static void main(String[]args){
        Problem1 ob = new Problem1();
        int[] nums = new int[]{1, 2, 3, 4, 6, 7, 8};
        System.out.println("Missing element is: "+ob.findMiss(nums));

    }
}