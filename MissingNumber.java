// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MissingElement{

    public static int missing_element(int[] arr){
        if(arr.length == 0) return 1;
        int left = 0, right = arr.length - 1, mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            //if(mid - 1 >= 0 && arr[mid - 1] != arr[mid] - 1)    return arr[mid] - 1;

            if(mid + 2 == arr[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return left + 1;
    }


    public static void main(String[] args) {
        System.out.println(missing_element(new int[]{1, 2, 3, 4, 5, 6, 8})); // 7
        System.out.println(missing_element(new int[]{1, 2, 3, 4, 5, 7})); // 6

    }
}