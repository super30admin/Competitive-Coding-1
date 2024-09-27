/*array of n-1 integers and 1 value is missing return which one.
 example [1,2,4,5,6,7]
 output-3
 
 */
// Time Complexity : O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

#include <iostream>
#include<vector>

using namespace std;

int search(vector<int>& nums){
    if(nums.empty() || nums.size() == 0){
        return -1;
    }
    int low = 0;
    int high = nums.size() - 1;
    while(low<=high){
       int mid = low +(high - low) / 2;
       if(nums[mid-1] != (nums[mid] - 1)){
            return (nums[mid] - 1);
       }
       else if(nums[mid+1] != nums[mid]+1){
           return nums[mid]+1;
       }
       else if(nums[mid] > mid+1){
           high = mid-1;
       }
       else{
           low = mid+1;
       }
    }
    return -1;
    
}

int main()
{
    vector<int> val = {1,2,3,4,5,7};
    int x = search(val);
    std::cout << x << std::endl;
    return 0;
}
