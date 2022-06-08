// Time Complexity : O(log N)
// Space Complexity : O(1)

public class Solution {

    public static int missingNumber(int[] num){

        int low = 0;
        int high = num.length - 1;

        while(low + 1< high){

            int mid = low + (high - low)/2;

            if((num[mid] - mid) != (num[low] - low)){
                high = mid;
            }else {
                low = mid;
            }
        }
        return num[low]+1;

    }

    public static void main(String args[]){

        int[] num = {50,51,52,54};

        System.out.println(missingNumber(num));

    }
}

