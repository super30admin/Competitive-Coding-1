
// "static void main" must be defined in a public class.
// Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
// 1:44
// Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
// Output : 4
// Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
// Output : 3


public class Main {
    public static void main(String[] args) {
        int arr[] = { 1, 2,3,4, 5, 7,8};
        int missingNumber = findMissing(arr);
        System.out.println("Missing Number is " +missingNumber);
    }

    public static int findMissing(int nums[]){
        //edge case
        if(nums[0] != 1)
            return 1;

        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == mid+1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            //breaking condition
            if(low == high) {
                return nums[low] + 1;
            }
        }
        return -1;
    }
}