public class Main {
    public int missingNumber(int[] nums)
    {
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            3
            if(nums[mid]-1 == mid)
            {
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low+1;
    }
    public static void main(String[] args) {
        Main a  = new Main();
        int[] ex = new int[]{1,2,3,4,5,6};
        int result = a.missingNumber(ex);
        System.out.println(result);
    }
}
//runtime: Since we are using binary search it is O(logn) and O(1) for the rest of the lines and fuctions
//space complexity: since we are not using any additional space it is O(1).
