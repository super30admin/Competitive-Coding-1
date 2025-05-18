// Missing in a Sorted Array of Natural Numbers
// Last Updated : 27 Mar, 2025
// Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n. There are no duplicates in the array. One of the integers is missing in the array. Write an efficient code to find the missing integer. 
// Examples: 

// Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
// Output : 5
// Explanation: The missing integer in the above array is 5 

// Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
// Output : 7
// Explanation: The missing integer in the above array is 7 


function binarySearch(nums){
    // set pointers
    let left = 0
    let right = nums.length-1
    let mid = 0
    while(left<=right){
        // run a while loop with those pointers
          //cal the mid
        mid = Math.floor((left+right)/2)
        // [1,2,3,4,6,7,8] // input array
        // [0,1,2,3,4,5,6] // wrt index
    //     left = 4
    //     right = 3 
    //     mid = 4
    // //validate the mid with our condi
        if(nums[mid] == mid+1){ //
                //take desci
            left = mid+1
        }
        else{
            right = mid-1
        }
    }
    // while block ends
    //! I was trying to add complexity to my code by doing this instead should just retuned left+1
    if(right>left) return nums[mid] -1
    if(left>right) return nums[mid] +1
    }
let Testnums =  [1,2,3,4,6,7,8]
console.log(binarySearch(Testnums))


//Below is the correct code !
function binarySearch(nums) {
    let left = 0;
    let right = nums.length - 1;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);

        // If the number at index mid is equal to mid + 1, the missing number is in the right half
        if (nums[mid] === mid + 1) {
            left = mid + 1;
        } else {
            // Otherwise, the missing number is in the left half
            right = mid - 1;
        }
    }

    // At the end of the loop, left will be pointing to the index where the mismatch occurred.
    // So, the missing number is left + 1
    return left + 1;
}

// Test cases
console.log(binarySearch([1, 2, 3, 4, 6, 7, 8])); 
console.log(binarySearch([1, 2, 3, 4, 5, 6, 8, 9])); 