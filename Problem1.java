public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        int [] arr = {5,6,7,9};
        int ans = Main.sort(arr);
        System.out.println(ans);
    }
    public static int sort(int [] nums){
        int diff = nums[0];
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(mid!=(nums[mid]-diff) && nums[mid]-nums[mid-1]>1){
                return nums[mid]-1;
            }
            else if(mid!=(nums[mid]-diff) && nums[mid]-nums[mid-1]==1){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }
}
