class Problem1{
    public int missingElement(int[] arr, int size){
        int low=0;
        int high=size-1;
        while(low+1 !=high){
           int mid= low+(high-low)/2;
           if(arr[low]-low!=arr[mid]-mid){
               high =mid;
           }
           else if(arr[low]-low!=arr[mid]-mid){
               low=mid;
           }
           }
           return arr[high]-arr[low];
    }
}

class Main{
    public static void main (String args[])
{
    int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
    int size = ar.length;
    Problem1 p1 = new Problem1();
    System.out.println("Missing number: " +
    p1.missingElement(ar, size));
}
}
