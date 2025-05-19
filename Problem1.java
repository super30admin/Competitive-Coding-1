//finding minimum element in a sorted array
//TC : O(logn)
//SC : O(1)


class Main {
    public static void main(String[] args) {
       int nums[] = new int[]{1,2,3,4,6,7,8};
       //considered start as first index of array and end as last index of the array
       int start = 0;   
       int end = nums.length - 1; 
       while((end - start) > 1){
           int mid = start + (end - start) / 2;
           if(nums[start] - start != nums[mid] - mid){  //comparing the difference between start index and its element with difference between mid index and its element
                end = mid;  //if difference here is not equal , missing element is found in left side , so limit search to left
            }
             else{
                   start = mid;  // else limiting search to right side
            }
       }
       if (nums[start] + 1 != nums[end]) {  //checking if there is gap between two elements . ex: if start element = 4 , end elemernt = 6 we found gap so return 5 as missing element nums(start + 1)
          System.out.println((nums[start] + 1));
        } 
        else {
         System.out.println((nums[end] + 1));
        }
    }
}