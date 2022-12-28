// find missing number in a sorted array
public class Problem1{

    public static void main(String[] args){
        int[] num = {1,3,4,5,6,7,8,9};
        int missingNum = findMissingNum(num);
        System.out.println(missingNum);

    }

    static int findMissingNum(int[] num){
        int left = 0;
        int right = num.length-1;
        int mid = 0;
        while (left < right){
            mid = left + (right-left)/2;
            if (num[mid-1]> mid){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
