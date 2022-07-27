public class MissingElement {
    public static void main(String args[]){
        int[] arr = {1,2,4,5,6,7,8,9};
       System.out.println(findMissingElement(arr));
    }

    public static findMissingElement(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(end-start > 1){
            int mid =  start  + (end - start)/2;
            if(arr[start]-start  ==  arr[mid]-mid){
                //move right
                start = mid;
            }
            else{
                //move left
                end = mid;
            }
        }
        return  arr[start]+1;

    }
}

