class Problem1 {

    // Function to find the missing number using binary search
    public static int findMissing(int[] arr, int n) {
        int left = 0;
        int right = n - 2;  
        // because array size is n-1, last index = n-2

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // If value matches index+1, missing number is on the right
            if (arr[mid] == mid + 1) {
                left = mid + 1;
            } 
            // Otherwise missing number is on the left
            else {
                right = mid - 1;
            }
        }

        // When loop ends, left = index of missing number
        return left + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 6, 7, 8};
        int n1 = 8;  // since numbers are from 1 to n
        System.out.println(findMissing(arr1, n1));  // Output: 5

        int[] arr2 = {1, 2, 3, 4, 5, 6, 8, 9};
        int n2 = 9;
        System.out.println(findMissing(arr2, n2));  // Output: 7
    }
}

