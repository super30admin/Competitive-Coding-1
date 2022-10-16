public class Main {
    public static void main(String[] args) {
       System.out.print(MyClass(new int[] {1,2,3,4,5,7,8}));
    }
    public static int MyClass(int[] arr) {
        int s = 0;
        int e = arr.length-1;
        while (s<=e){
            int m = s+(e-s)/2;
            if(arr[s]-s!=1){
            return arr[s]+1;
        }
        if(arr[s]==arr[m]){
            return arr[s]+1;
        }
            if(arr[m]-m != 1){
                e = m;
            }else if (arr[e]-e != 1){
                s = m;
            }
        }
return -1;}
}
//tc=O(logn)
//sc=O(1)
