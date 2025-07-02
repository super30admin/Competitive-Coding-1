

class Main {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4,5,6};
        int min = findMin(num);
        System.out.println(min);
    }

    public static int findMin(int num[]){
        int low = 0;
        int high = num.length -1;
        while(low<= high){
            int mid = low+ (high - low)/2;  //avoid integer overflow
            if(num[mid] != mid+1 && num[mid-1] == mid){
                return mid+1;
            }
            else if(num[mid] != mid+1 && num[mid-1] != mid){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return num.length+1;
    }
}
