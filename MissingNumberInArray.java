// Given a list of n-1 integers and these integers are in the range of 1 to n. 
// There are no duplicates in list. One of the integers is missing in the list. 
// Write an efficient code to find the missing integer. 
// Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
// Output : 5


// Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
// Output : 7

// Time Complexity : o(logn)
// Space Complexity : o(1)
// Approach : In the Array If any number is missing then difference between the number and the index will be greater than 1. Since it is a sorted Array,
// Using Binary Search we can eliminate the portion of the array where the difference is not equal between mid - low and mid - high.
// finally if the array containing 2 elements then missing  number = avg of two numbers

public int Search(int nums[] , int size){
    // [1, 2, 3, 4, 6, 7, 8]
    // [0, 1, 2, 3, 4, 5, 6]
    //size = 7
    int low = 0; // 0
    int high = size-1; // 7-1 =6
    while(high-low>=2){ // loop executes if you have atleast three elements
        int mid = low + (high-low)/2; //3 //1
        // step 1 -  [1,2,3,4,6,7,8] nums
        // step 2 - [4,6,7,8] -> [3,4,5,6] indexes
        // step 3 - [4,6] -> [3,4] indexes
        if(nums[mid]-mid != nums[low]-low){
            // missing element in the left array 
            high=mid;
        } else if (nums[mid]-mid != nums[high]-high){
            // missing element in the right array
            low=mid;
        }
    }
    return nums[low]+num[high] /2 ;
}
// Approach 2: Binary Search
public int Search(int nums[] , int size){
    // [1, 2, 3, 4, 6, 7, 8]
    // [0, 1, 2, 3, 4, 5, 6]
    //size = 7
    int low = 0; // 0
    int high = size-1; // 7-1 =6
    while((high-low)>1){ // loop executes if you have atleast three elements
        int mid = low + (high-low)/2; //3 //1
        // step 1 -  [1,2,3,4,6,7,8] nums
        // step 2 - [4,6,7,8] -> [3,4,5,6] indexes
        // step 3 - [4,6] -> [3,4] indexes
        if(nums[mid]-mid != nums[low]-low){
            // missing element in the left
            high=mid;
        } else if (nums[mid]-mid != nums[high]-high){
            // missing element in the right array
            low=mid;
        }
    }
    return nums[low]+1 ;
}

