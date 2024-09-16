//time complexity - O(log n)
//space complexity - O(1)
/*Approach
*dividing on the base of difference between index and the number itself,it will vary as soon as one number is
skipped
* returning if consecutive positions have difference more than 1
 */
public class  Problem1{
public static int search(int[] ar, int size){
    int left = 0;
    int right = size - 1;
    int mid = -1;
    while(left <= right){
        mid = left + (right - left)/2;
        if(ar[mid]+2 == ar[mid+1]){
            return (ar[mid]+ar[mid+1])/2;
        }
        if(ar[left]-left != ar[mid]-mid){
            right = mid;
        }
        if(ar[right]-right != ar[mid]-mid){
            left = mid + 1;
        }
    }
    return -1;
}
public static void main (String[] args)  
{ 
int ar[] = { 1,3,4,5,6}; 
int size = ar.length; 
System.out.println("Missing number: " + 
search(ar, size)); 
}
}
