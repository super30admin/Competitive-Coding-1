// Problem: Find missing element in sorted array
class Problem2{
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,8};
        int missingElement = findMissingElement(arr);
        System.out.println("Missing element is: " + missingElement);
    }
    public static int findMissingElement(int arr[]){
        int low = 0, high = arr.length-1;
        while(high-low>=2){
            int mid = low +(high-low)/2;
            System.out.println(low+" "+mid+" "+high);
            
            if(arr[low]-low==arr[mid]-mid){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        System.out.println(low+" "+arr[low]+" "+(arr[low-1]));
        return (arr[low]+arr[high])/2;
    }
}
