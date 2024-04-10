public class MissingElem {
    public static int findMissingNumber(int[] arr, int n) {
        int low = 0;
        int high = n - 1;

        while (high - low >= 2) { //This condition is for an array size greater than equal to 2.
            int mid = low + (high - low) / 2; //Calc the middle element

            //Calculates the difference between the elem and the index
            int MidIndx = arr[mid] - mid; //Middle Index
            int LowIndx = arr[low] - low; //Low Index
            int HighIndx = arr[high] - high; //High Index
            if (MidIndx != LowIndx) {
                high = mid; //Move to the left to find the missing elem
            } else if (MidIndx != HighIndx) {
                low = mid; //Move to the right
            }
        }
        return (arr[low] + arr[high]) / 2; //When the array size is 2, the middle elem is calc to return the missing elem
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7, 8};
        int n = arr.length - 1;

        int missingNumber = findMissingNumber(arr, n);
        System.out.println("Missing number is: " + missingNumber);
    }
}
