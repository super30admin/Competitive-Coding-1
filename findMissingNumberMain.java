// The approach sorts the array first, then uses binary search to find the index where the value does not match the expected sequential number, indicating the missing number. The final missing number is determined by the position where the discrepancy is found during the binary search.
// Time complexity:O(log n), space:O(1)
public class findMissingNumberMain {
public static int findMissingNumber(int[] arr, int n) {

    int left = 0;
    int right = arr.length-1;
    while(left<right){
        int mid = left+(right-left)/2;
        if(mid+1!=arr[mid]){
                right = mid;
            }else{
                left=mid+1;
            }
    }
    return left+1;
}

public static void main(String[] args) {
    int[] arr = {1, 2, 4, 6, 3, 7, 8};
    int n = arr.length;

    int missingNumber = findMissingNumber(arr, n);
    System.out.println("Missing number is: " + missingNumber);
}
}
