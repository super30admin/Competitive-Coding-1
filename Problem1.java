class Problem1 {

    // Time Complexity : O(logn)
    // Space Complexity : O(1)

    public static int missingElement(int[] arr) {
        int l = 0, h = arr.length - 1;
        while ((h-l) > 1) {
            int mid = l + (h-l)/2;
            if ((arr[l] - l) != (arr[mid] - mid))
                h = mid;
            else
                l = mid;
        }
        return arr[l] + 1;
    }

    public static void main(String[] args) {
        int array[] = new int[]{1,2,3,4,5,6,7,8};
        int missingElement = missingElement(array);
        System.out.println("Missing Element : " + missingElement);
    }
}
