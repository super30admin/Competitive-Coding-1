/**
 * arr[] = [1, 2, 3, 4, 6, 7, 8]
 */
 /**
  *             if(a[mid-1] != mid) {
                return mid;
            }
            if(a[mid+1] != mid + 2) {
                return mid + 2;
            }
  */
  public class Problem1 {
    public static int findMissingNumber(int[] a) {
        int size = a.length;
        int n = size + 1;
        if(a[0] != 1) {
            return 1;
        }
        if(a[size-1] != n) {
            return n;
        }
        int left = 1;
        int right = size-2;
        while(left < right) {
           int mid = left + (right - left)/2;
           if(a[mid] == mid + 1) {
               left = mid + 1;
           }
           else {
               // at this point a[mid] = mid+2;
               if(a[mid-1] == mid) {
                   return mid+1;
               }
               right = mid -1;
           }
        }
        return -1;
    }
    public static void main(String[] args) {
       int[] arr = {1, 2, 3, 5, 6, 7, 8};
       int result = findMissingNumber(arr);
       System.out.println(result);
    }
   }
