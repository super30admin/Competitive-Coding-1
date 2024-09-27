class FindMissingNumber{

    private static int search(int[] nums){

        if(nums == null || nums.length == 0){
            return -1;
        }

        int size = nums.length;
        //Base Cases
        if(nums[0] != 1)
        {
            return 1;
        }

        if(nums[size-1] != size+1)
        {
            return size+1;
        }

        int low = 0;
        int high = size-1;

        //Binary Search until last 2 elements with one missing number
        while(high - low >= 2)
        {
              int mid = low + (high - low)/2;
              
              //Decide which part is sorted and index:element mapping is correct
              //Left is sorted and correctly mapped? --> Seach right else search left part
              if(nums[mid] - mid == nums[low] - low)
              {
                  low = mid; // Go right  
              }
              else{
                    high = mid;  // Go left
              }
        }

        //Find missing number from the last array
        return (nums[low]+nums[high])/2;
    }

    public static void main(String args[]){
        //int[] nums = new int []{2,3,4,5,7,8};
        int[] nums = new int []{1,2};
        int output = search(nums);
        System.out.print("*** Missing Number="+output);
    }
}

//Time Complexity: O(log n)
//Space Complexity: O(1) 
