//Time Complexity - O(logn)
//Space Complexity - O(1)


public class Main {
    public static void main(String[] args) {
        Main mm = new Main();
        int[] intArray = new int[]{ 1,2,3,4,5,6,8,9};
        System.out.println(mm.missingNumber(intArray));
    }
    public static int missingNumber(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high ) {
            int middleElement = low + (high - low) / 2;
            if (arr[middleElement] - middleElement > 1) {
                high = middleElement;
            } else {
                low = middleElement;
            }
            if (high - low == 1) {
                return (arr[high] + arr[low]) / 2;
            }
        }
        return -1;
    }
}
