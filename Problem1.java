//MissingIntegerInSortedList
//Time complexity O(Log n)
//Leetcode tested

public class SearchMissingElement {
    public static void main(String[] args) {
        System.out.println(searchMissingElement(new int[]{1,3,4,5,6,7}));
    }
    private static int searchMissingElement(int arr[]){
        int lastIndex = arr.length-1;
        int left=0;
        int right=lastIndex;
        int mid=0;
        int side=0;
        while (right-left!=1){
            mid = left+(right-left)/2;
            int indexDifference = mid-left;
            int valueDifference = arr[mid]-arr[left];
            //System.out.println(left+" "+right+" "+mid+" before");
            if(indexDifference != valueDifference){
                right = mid;
            }else{
                left = mid;
            }
            //System.out.println(left+" "+right+" "+mid);
        }
            return arr[left]+1;
    }
}


