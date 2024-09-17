//Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, 
//One of the integers is missing in the list. Write a code to find the missing integer.
// 1 2 3 4 5 7 8 -> 6
//Time Complexity: O(log(n))
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes (local compiler)
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class Main
{
    public static void main(String[] args) {
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        int []arr = {1,2,3,5,6,7,8};
        if(arr==null || arr.length==0) System.out.print(-1);
        int low = 0;
        int high = arr.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2 ;
            if(arr[mid]-arr[mid-1]>1) {System.out.print(arr[mid]-1); break;}
            if(arr[mid+1]-arr[mid]>1) {System.out.print(arr[mid]+1); break;}
            else if((mid-low)==(arr[mid]-arr[low])){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.print("");
    }
}
