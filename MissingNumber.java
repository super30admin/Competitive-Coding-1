//Time Complexity: O(logn)
//Space Complexity: O(1)
//Program ran successfully
/*
    Algorithm: 1. Do a binary search on the input Array
               2. If the middle element meets this condition a[mid] == mid+2, record the index and go left(right = mid - 1)
               3. Keep Repeating until we find the leftmost element with a[mid] == mid+2
               4. Once we have the leftmost element with the condtion: find the missing element by a[mid] + a[mid -1]/2
               5. Special cases would be when the last element is missing: In this case your initial value of index remains unchanged, return arr.length + 1
               6. When the first element is missing: index will be equal to 0 and this a[mid] + a[mid -1]/2 would give an Exception, return 1.
*/

public class MissingNumber {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,7};
        int n = binarySearch(0, a.length-1, a);
        System.out.println("missing number is "+n);
    }
    static int binarySearch(int left, int right, int[] a) {
        int index = -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(a[mid] == mid+2){
                index = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(index == 0) return 1;
        if(index == -1) return a.length + 1;
        return (a[index] + a[index-1])/2;
        
    }
}
