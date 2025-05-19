
// Time Complexity O(logn)
// Space complexity O(1)

#include <vector>
#include <iostream>

int findMissing(std::vector<int>& nums) {
        int lo = 1;
        int hi = nums.size()+1;
        
        while (lo < hi) {
            
            int mid = lo + (hi-lo)/2;
            
            if (nums[mid-1] == mid) {
                lo = mid+1;    
            } else {
                hi = mid;
            }
        }

        return lo;
}

int main()
{
    std::vector<int> nums = {1};
    
    std::cout << findMissing(nums) << "\n";

    return 0;
}