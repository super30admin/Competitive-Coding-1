// time complexity : O(logn)
// space : O(1)
// ran successfully on leetocde : yes
// any problems: gave linear solution first and this optimal after that

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] nums = {1,2,4,5,6,7};

        System.out.println(findMissingElement(nums));
    }

    public static int findMissingElement(int[] nums){
        if(nums == null) return 1;

        int low = 0;
        int high = nums.length - 1;

        int mid = 0;

        while(low <= high){

            mid = low + (high - low) /2;

            if(nums[mid] > mid+1){
                high = mid - 1;
            }

            else{
                low = mid + 1;
            }

        }

        return low + 1;
    }
}
