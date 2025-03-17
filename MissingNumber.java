// Time Complexity : Log(n)
// Space Complexity : O(1)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

/*

Since numbers are sorted and 1 to n..we can easily say that even index will have odd number and
odd index will have even number.
If mid element fails the above condition, that means we have to go and search in left half or else go in right half

*/

public class MissingNumber {
    public static void main(String[] args)
    {
        searchNumber(new int[]{1, 2, 3, 5, 6, 7, 8});
        searchNumber(new int[]{2, 3, 4,5,6,7});
        searchNumber(new int[]{1, 2, 4, 5, 6, 7, 8, 9});
        searchNumber(new int[]{1,2,3,4,5,6,7,8,9,10,12});



    }

    private static void searchNumber(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if((mid % 2==0 && arr[mid] % 2==0) || (mid%2!=0 && arr[mid]%2!=0))
            {
                right = mid -1;
            }
            else
            {
                left = mid +1;
            }


        }
        System.out.println(left + 1);
    }


}

