// Time Complexity : All comparison operations are in the order of O(1). every time a comparison takes place search space gets reduced by half; which is in order of O(logn). So Aysmtotically, Time Complexity is in the order of O(logn)
// Space Complexity : O(n) - size of the input array. If input array is to be not considered for space complexity calculations, then the space complexity is in the order of O(1) 
// Is this the most optimized approach  - Yes
// Other approaches - Brute force. Set a counter variable equal to first element of the array
                    //Run a for loop on the size of the array to check if nums[i] == counter, If yes, increment counter and continue for loop
                    // If not, terminate for loop and return value in counter as the answer
                    // This is a naive approach as Time Complexity is in order of - O(n)
// Any Problems while coding: None

// Your code here along with comments explaining your approach

class Problem1 { 
 
    public int search(int[] nums) { //function searching missing number
        //base
        if(nums == null || nums.length <= 1) return -1; //if array is empty, null or of length 1
                                                        //since we can't say what is missing in length 1 array
        //logic case
        int low = 0;   //setting low initially
        int high = nums.length - 1;  //setting high initially
        while(low <= high)
        {   //until low and high converge
            int mid = low + (high - low)  / 2;    //Calculating mid to avoid integer overflow error
            //success case
            if((mid !=0) && (nums[mid] != nums[mid - 1] + 1))
            {   //check if left of mid is just one greater than mid. if not, then left of mid has one missing
                return nums[mid] -  1;   //return missing element
            }
            else if((mid != high) && (nums[mid] != nums[mid + 1] -1))
            { //check if right of mid is just one less than mid. if not, then right of mid has one missing
                return nums[mid] + 1;  //return missing element
            }
            else{   //if above conditions do not satisfy, reduce search space and recompute
                 int left_diff = nums[mid] - nums[low];   
                 int left_index_diff = mid - low;
                 //int right_diff = nums[high] - nums[mid];
                 //int right_index_diff = high - mid;
                 if(left_diff == left_index_diff)
                 { //difference between left index and right index and difference between left and right elements should be equal
                    low = mid + 1; 
                 }
                 else{  // same as above condition except we check for difference between mid and high index and elements
                    high = mid - 1; 
                 }
            }
        }
    return -1;  //if missing number does not exist in array. This is not required in the interview problem but still doing. Bonus ;p
    }
}

// Class with main function
class Main
{
    public static void main(String[] args)
    {
    Problem1 obj = new Problem1();
    int[] input_array = {2,4,5,6,7,8,9,10,11};  //Sample input array sorted
    
    int result = obj.search(input_array);
    System.out.println("Missing element is - " + result);  //should return 7
   
    }
}
