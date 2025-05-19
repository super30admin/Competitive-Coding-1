// Time Complexity : findMissingElement() has time complexity O(log n)
// Space Complexity : O(1)
public class Problem1 {
    public static void main(String[] args) {
        int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(findMissingElement(input));
    }

    static int findMissingElement(int[] input) {
        int n = input.length;
        int l = 0;
        int h = n - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (m == input[m] - 1) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l + 1;
    }
}
