
//Missing element in  from Sorted array
// Time Complexity : O(Log N base 2)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : NA

// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class Problem1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,8,9};
        
        int l = 0, h = arr.length - 1;
        
        while(l <= h){
            int mid = l + (h-l)/2;
            
            //If we find that difference between element and its index is not equal for element at mid and low index
            //We will chnage to value of mid according to that
            if(arr[mid] - mid != (arr[l] - l)){
                h = mid;
            }
            if(arr[h] - h != (arr[mid] - mid)){
                l = mid;
            }
            
            if(h-l == 1){ // Only 2 elements, find middle and it will be the missing elemeNT
                break;
            }
        }
        System.out.println("Missing element is : " + ( arr[l] + arr[h] ) / 2);
    }
}