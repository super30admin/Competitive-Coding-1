//Time Complexity = O(logn)
//Space Complexity = O(1)
public class MissingElement{
    static int BS(int nums[], int size){
        if(nums == null || nums.length == 0) return -1;
        int start = 0; int end = nums.length - 1;
        while(end - start >= 2){
            int mid = start + (end - start)/2;
            int midIdxDiff = nums[mid] - mid;
            int startIdxDiff = nums[start] - start;
            if(midIdxDiff != startIdxDiff){
                end = mid;
            }else{
                start = mid;
            }            
        }return (nums[start] + nums[end])/2;
    }
    public static void main(String[] args) {
       int num[] = {1,2,3,4,5,6,8,9};
        int size = num.length;
        System.out.println(BS(num,size));
    }
}
