
// Time Complexity : O(logN) because we are using binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
// Any problem you faced while coding this : No

public class MyClass {
    public static void main(String args[]) {
    int[] arr = {2,3,4};
    int low = 0;
    int high = arr.length-1;
    while(low<=high){
        int mid = low+(high-low)/2;
        if(arr[mid]!=mid+1){
            high = mid-1;
        }else{
            low = mid+1;
        }
    }
      System.out.print(low+1);
    }
}
