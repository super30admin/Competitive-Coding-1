// Time Complexity: O(log(n))
// Space Complexity: O(1)
// Find Missing Number in a sorted array

class FindTheNumber {
    public static int search(int []arr){
        int left = 0;
        int right = arr.length - 1;
        if(arr[right]==right+1){
            return -1;
        }
        while(left<right){
            int mid = left + (right-left)/2;
            if(arr[mid]==mid+1){
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        if(arr[left]==left+1){
            return arr[left]+1;
        }else{
            return arr[left]-1;
        }
    }
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println(search(arr));
    }
}
