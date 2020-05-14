//Time Complexity : O(log(n)) ,  n is the number of elements in nums 
//Space Complexity: O(1)

import java.io.*;

class MissingNo {
    // Function to ind missing number 
    static int getMissingNo(int nums[], int n) 
    { 
        int i=0;
        int h=nums.length-1;
        if(nums[0]!=1){
            return 1;
        }
        if(nums[n-1]<=n){
            return nums[n-1]+1;
        }
        int mid=0;
        while(i<=h){
            mid= i+(h-i)/2;
            if(mid==i){
                return nums[mid]+1;
            }
            
            if(nums[mid]-nums[h]!=mid-h){
                i=mid;
            }
            else{
                h=mid;
            }
        }
        return -1;
    } 
  
    /* program to test above function */
    public static void main(String args[]) 
    { 
        int a[] = {1,2,3, 4,6}; 
        int miss = getMissingNo(a, 5); 
        System.out.println(miss); 
    } 
} 