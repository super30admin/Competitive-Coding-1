Provide an array of n-1integers in the range of 1to n with no duplicates in list,
        One of the integers is missing in the list.Write a code to find the missing integer.
//Time Complexity O(logn)
//Space Complexity O(1)

public class Problem1 {
    public class BinarySearch {
        public static int solution(int[] arr) {
            if (arr == null || arr.length == 0) return -1;
            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if ((mid != arr.length - 1 && arr[mid] != arr[mid + 1] - 1)) {
                    return arr[mid] + 1;
                } else if (arr[low] - low == arr[mid] - mid) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            int[] arr1 = {1, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] arr = {1, 2, 3, 4, 5, 7};
            int[] arr2 = {5, 7, 8, 9, 10, 11};
            int output = BinarySearch.solution(arr2);
            System.out.println("Final out put " + output);
        }
    }
}

