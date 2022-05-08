class missingNumberInSortedArray{
    public int missingNumber(int[] nums, int size){
        if(nums == null || nums.length == 0) return 0;

        int a = 0;
        int b = size-1;
        int mid = 0;
        while((b-a) > 1){
            mid = (a+b)/2;
            if((nums[a] - a) != (nums[mid] - mid)){
                b = mid;
            }
            else if((nums[b] - b) != (nums[mid] - mid)){
                a = mid;
            }
        }
        return (nums[a]+1);
    }

    public static void main(String[] args) {
        missingNumberInSortedArray ma = new missingNumberInSortedArray();
        int[] nums = {0,1,2,3,5,6};
        int size = nums.length;
        System.err.println(ma.missingNumber(nums, size));
    }
}


//this problem has O(logn) time complexity and O(1) space complexity