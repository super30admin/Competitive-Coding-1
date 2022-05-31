// Time Complexity : O(logn)
// Space Complexity : O(1)

public class Problem1 {

    public static int findMissingNumber(int[] arr){

        int low = 0, high = arr.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            //check if LHS is unbalanced
            if(arr[mid]- arr[low] != mid-low){
                high = mid;
            }else{
                low = mid;
            }
            if(high - low == 1)
                break;
        }
        return arr[low] + 1;
    }

    public static void main(String[] args){
//        System.out.println(findMissingNumber(new int[]{1,2,3,4,5,7,8}));
//        System.out.println(findMissingNumber(new int[]{1,2,4,5,6,7,8,9}));
        System.out.println(findMissingNumber(new int[]{1,2,3,5,6,7,8}));
    }

}