
package com.dsa;

public class FindMissingNumber {

    public int findMissingNumber(int[] arr, int length) {
        int low=0;
        int high= length;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(arr[mid]-mid == 1)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low == length+1 ? arr[low-1]+1 : arr[low]-1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8};

        FindMissingNumber obj = new FindMissingNumber();
        int result = obj.findMissingNumber(arr, arr.length -1);
        System.out.println(result);
    }
}