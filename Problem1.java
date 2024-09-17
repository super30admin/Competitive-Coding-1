//TC=O(log n)
//SC= O(1)
public class Problem1 {
    public static int findNum(int[] array) {
        int low = 0;
        int high = array.length - 1;
        int a = array[low];
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(array[mid] == a + mid) {
                low = mid + 1;
            }
            else {
                return a+mid;
            }
        }

        return -1;
    }
    public static void main(String args[]) {
        //int[] array = {5, 7, 8, 9};
        int[] array = {5,6,7,9,10};
        System.out.println(findNum(array));
    }
}

