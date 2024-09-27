// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Problem1{
    public static void main(String[] args) {
        int arr1[] = new int[]{1, 2, 3, 5, 6, 7, 8};
        int arr2[] = new int[]{1, 2, 4, 5, 6, 7, 8, 9};

        System.out.println("Input Value 1: [1, 2, 3, 5, 6, 7, 8]");
        int x1 = search(arr1);
        System.out.println("Missing Value 1:"+x1);
        System.out.println("Input Value 2: [1, 2, 4, 5, 6, 7, 8, 9]");
        int x2 = search(arr2);
        System.out.println("Missing Value 1:"+x2);
    }

    public static int search(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]-mid==1){//the difference between the arr[mid] value and index is supposed to be one
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start+1;//when not thats where the missing value is the next value
    }
}
