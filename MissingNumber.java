import java.util.Arrays;

/**
 * Time Complexity is O(logn);
 * Space Complexity is O(1);
 * Ran Binary search on two directions to see left-most and right-most
 *
 */
public class MissingNumber {

  public static int search(int[] arr) {
    int leftPtr = 0, rightPtr = arr.length - 1, midPtr;
    while (leftPtr <= rightPtr) {
      midPtr = leftPtr + (rightPtr - leftPtr) / 2;
      if (arr[midPtr] == midPtr + 1) {
        leftPtr = midPtr + 1;

      } else {
        rightPtr = midPtr - 1;
      }
    }
    if (leftPtr == arr.length) {
      return -1;
    } else
      return leftPtr + 1;
  }

  public static void main(String[] args) {
    System.out.println(MissingNumber.search(new int[] { 1, 2, 3, 4, 5, 6, 8 }));
    System.out.println(MissingNumber.search(new int[] { 1, 3, 4, 5, 6, 7, 8 }));
    System.out.println(MissingNumber.search(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10 }));
    System.out.println(MissingNumber.search(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
  }
}