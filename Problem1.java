//  Find Missing Number in a sorted array which has natural numbers as elements

// Time Complexity : O(logn) - binary search
// Space Complexity : O(1) - constant

/*
 * Here, the method is used is binary search. Here as per my understanding we have 2 sequences one is elements and the second is the indices.
 * Using both, I tried to find if the elements adjacent to mid are in their right places or not. If those conditions fail, I tried to find
 * in which part of array there is a missing i.e., on left side of array of mid or right side of array of mid.
 */


//  class Solution{
//     public int missingNumber(int nums[]){
//         int low = 0;
//         int high = nums.length - 1;
//         while(low<=high){
//             int mid = low + (high - low)/2;
//             if(nums[mid-1]!=nums[mid]-1){
//                 return nums[mid]-1;
//             }
//             else if(nums[mid+1] != nums[mid]+1){
//                 return nums[mid]+1;
//             }
//             else if(nums[mid] == mid + 1){
//                 low = mid + 1;
//             }
//             else{
//                 high = mid - 1;
//             }
//         }
//         return -1; 
//     }
// }

