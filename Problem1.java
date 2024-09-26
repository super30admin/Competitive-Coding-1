public Problem1{
public static int serachNumber(int arr[]){
        int l=0,h=arr.length-1;

        while(h-l>=2){
            int m=l+(h-l)/2;
            if(arr[m]-m!=arr[l]-l){
                h=m;
            }else if(arr[m]-m!=arr[h]-h){
                l=m;
            }
        }
        return (arr[l]+arr[h])/2;
    }

public static void main(String[] args){

        int arr []={1,2,3,4,5,6,8};

        System.out.println(serachNumber(arr));
    }
}
