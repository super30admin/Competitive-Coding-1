
public class missingElement {
    public static int find(int[] nums,int start,int end){
        if(nums.length == 0)
            return -1;
        int middle = 0;
        while(start<=end){
            middle = start+(end-start)/2;
            if(nums[middle]>middle+1){
                end = middle-1;
            }
            else{
                start = middle+1;
            }
        }
        if(middle == nums.length-1)
            return middle+1;
        else
            return start+1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,7,8,9,10};
        int x  = find(nums,0,nums.length-1);
        System.out.println(x);
    }
}
