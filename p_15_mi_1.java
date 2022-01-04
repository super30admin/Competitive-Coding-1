// Time Complexity :o(logn)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class p_15_mi_1{
    public static int search (int arr[] , int size){
        int low = 0;
        int high = size -1;
        int mid = 0;
        while(high - low >=2)
        {
            mid = low + (high - low)/2;
            int  midIndexOfDiff = arr[mid] - mid;
            int lowIndexDiff = arr[low] - low;
            if(midIndexOfDiff != lowIndexDiff)
            {
                high = mid;
            }else{
                low = mid;
            }
        }
        return (arr[low] + arr[high])/2;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,8};
        int size = arr.length;
        System.out.println("Missing number" + search(arr,size));    
    }
}
