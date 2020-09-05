// "static void main" must be defined in a public class.
/*
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
Examples:
Time Complexity: O(log n)
Space Complexity: O(n)
*/
public class Main {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 6, 7,8};
        System.out.println(findMissingNo(arr));
    }
    private static int findMissingNo(int arr[]){
        int left = 0, right = arr.length - 1, mid = 0;
        while(left < right){
            mid = left + (right - left)/2;
            if(arr[mid]-1 == mid )  left = mid+1;
            else right = mid;
        }
        return left+1;
    }
}
