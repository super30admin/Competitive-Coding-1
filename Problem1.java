//Time Complexity- O(log n)
//Space Complexity - O(1)
//Leetcode - Yes 
//Analysis-
/*
 * If the number - middle is not equal to the first element in the array, discard the right side and search for the element which is missing in the left side. 
 * Else search the right side for the missing element. 
 * The 0th element + the position where the low has stayed will give you the missing element. 
 */
public class Problem1{
    public static int search(int nums[],int size){
        int l = 0; 
        int h = size-1;
        while(l<h){
            int mid= l+(h-l)/2;
            if(nums[mid]-mid != nums[0])
                h = mid-1;
                else 
                l = mid+1;
            }
        return nums[0]+l;
        }
 public static void main(String[] args)
 {
     int ar[] = { 1, 2, 4};
     int size = ar.length;
     System.out.println("Missing number: "
                        + search(ar, size));
 }
}