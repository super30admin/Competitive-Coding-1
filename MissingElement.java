public class MissingElement {

    public int findMissingElement(int[] arr){
        int low = 0;
        int high = arr.length - 1;

        int mid = 0;
        System.out.println("low" +low);
        System.out.println("high" +high);
        System.out.println("mid "+mid);


        //
        while((high - low) > 1) {
            mid = (low + high) / 2;
            //if(!(arr[mid]-arr[low] == mid-low)) {
            if((arr[low]-low) != (arr[mid]-mid)) {
                high = mid;
            }
            //else if(arr[high] - arr[mid] != high - mid) {
            else if((arr[high] - high) != (arr[mid] - mid)) {
                low = mid;
            }

        }
        return arr[low]+1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,6,7,8,9};

        MissingElement me = new MissingElement();

        System.out.println("Result "+me.findMissingElement(nums));
    }


}