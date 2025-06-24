class Main {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4,5,6};
        //As the array is sorted and it has range 1-n, the element should always be index+1
        int min = findMin(num);
        System.out.println(min);
    }
    
    public static int findMin(int num[]){
        //Using binary search
        int low = 0;
        int high = num.length -1;
        while(low<= high){
            int mid = low+ (high - low)/2;  //avoid integer overflow
            if(num[mid] != mid+1 && num[mid-1] == mid){
                //if mid element is not mid+1, checking if before element is index+1 or not, if yes, mid+1 number is missing
                return mid+1;
            }
            else if(num[mid] != mid+1 && num[mid-1] != mid){
                //if before element also not index+1, element before mid is missing, so moving left
                high = mid-1;
            }else{
                //not both cases, moving right
                low = mid+1;
            }
        }
        return num.length+1;
    }
}
