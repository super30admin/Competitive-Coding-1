// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,4,5,6,8,9,10,11,12}; //2
        
        int l=0;
        int h=arr.length-1;
        System.out.println(bs(arr,l,h)==7?true:false);
        
        arr=new int[]{1,2,3,4,5,6}; //7
         h=arr.length-1;
        System.out.println(bs(arr,l,h)==7?true:false);
        arr=new int[]{1,2,3,4,6}; //5
         h=arr.length-1;
        System.out.println(bs(arr,l,h)==5?true:false);
        arr=new int[]{2,3,4,5,6}; //1
        System.out.println(bs(arr,l,h)==1?true:false);
        
        arr=new int[]{2}; //1
        h=arr.length-1;
        System.out.println(bs(arr,l,h)==1?true:false);
        
        arr=new int[]{1}; //2
        System.out.println(bs(arr,l,h)==2?true:false);
        
        arr=new int[]{2,3}; //1
        h=arr.length-1;
        System.out.println(bs(arr,l,h)==1?true:false);
        
        arr=new int[]{1,2}; //3
        System.out.println(bs(arr,l,h)==3?true:false);
    }
    
    private static int bs(int[] arr,int l,int h)
    {

        while(l<=h)
        {
            int m=l+(h-l)/2;

            if(arr[m]-m!=1 &&( m==0||arr[m]-arr[m-1]!=1))
                return arr[m]-1;
            else if(arr[m]-m==1)
                l=m+1;
            else 
                h=m-1;
            
        }
        
        return arr[l-1]+1;
    }
}