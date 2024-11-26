//Find missing number in sorted array
//Time complexity: O(log n)
//Space complexity: O(1)
class Solution {

    private static int missingNumber(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        while(right - left >= 2) {
            int mid = left + (right - left)/2;
            //if the difference of element at  left and index left is
            //not equal to element at mid and index mid, then missing element
            //is on the left side of mid.
            if(arr[left] - left != arr[mid] - mid) {
                right = mid;
            }
            //if the difference of element at  right and index right is
            //not equal to element at mid and index mid, then missing element
            //is on the right side of mid.
            else if(arr[right] - right != arr[mid] - mid) {
                left = mid;
            }
        }
        //the missing element between two numbers can be found as: x+y/2;
        return (arr[left] + arr[right])/2;
    }

    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5,6,7,9};
        System.out.println("Missing number: " + missingNumber(arr));
    }
}
