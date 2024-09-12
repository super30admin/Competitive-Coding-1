// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
// Time taken : 10

public class FindMissingElement {
    public static int findLostElement(int[] arr){

        if(arr == null || arr.length == 0)
            return -1;
        if (arr[0] != 1)
            return 1;
        if(arr[arr.length-1] == arr.length)
            return -1;

        int l = 0, r = arr.length-1;
        while(l<=r){
            int mid = l + (r-l) / 2;
            if(arr[mid] == mid+1){
                //move right
                l = mid+1;
            }
            else {
                //move left
                r = mid-1;
            }
            if(l==r){
                return arr[l] -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

//            int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Array is complete: " + findLostElement(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println("First Element is missing: " + findLostElement(new int[]{2, 3, 4, 5, 6, 7}));
        System.out.println("Regular test case: " + findLostElement(new int[]{1, 2, 3, 4, 5, 7}));
    }
}