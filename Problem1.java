public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        int[] nums = {1,2,4,5,6};
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid]-mid == 1){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(start+1);
     }
}
