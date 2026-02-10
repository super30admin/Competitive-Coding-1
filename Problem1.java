
public class Problem1 {
    int missingNumber(int[] arr) {
        int low = 0, high = arr.length - 1, mid;

        while(low <= high) {
            mid = low + (high - low) / 2;

            if(arr[mid] - 2 == mid) high = mid - 1;
            else low = mid + 1;
        }

        return low + 1;
    }
}