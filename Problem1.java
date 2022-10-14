

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Any problem you faced while coding this : no

public class Problem1 {

    static int missing(int [] nums){

        int start = 0;
        int end = nums.length - 1;

        while (start <= end){

            int mid = (end + start) / 2;

            if (nums[mid] - mid != 1 ){
                return  nums[mid] - 1;
            }
            if (nums[mid] - mid == 1 && nums[start] - start == 1){
                start = mid + 1;
            }
            else{
                end = mid -1;
            }
        }
        return -1;

    }



    public static void main(String[] args){
        int arr[] = {5,7,7,8,8,10};
        System.out.println(Problem1.missing(arr));;

    }
}
