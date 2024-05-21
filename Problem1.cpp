// Find Missing Number in a sorted array
#include <iostream>
#include <vector>

class Solution {
public:
    int findMissing(const std::vector<int>& nums) {
        if (nums.empty()) {
            return -1;
        }
        int low = 0, high = nums.size() - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (mid + 1 == nums[mid]) {
                // Middle element is in the correct position. Search right excluding middle element for missing element
                low = mid + 1;
            }
            else {
                // Search left including middle element
                high = mid;
            }
        }
        if (low + 1 == nums[nums.size() - 1]) { // If the low index points to the actual last element
            // No missing elements
            return -1;
        }
        return low + 1; // This will be the missing value
    }
};

// Example usage
int main() {
    Solution solution;

    std::vector<int> A = { 1, 2, 3, 4, 5, 7, 8, 9, 10 };
    std::cout << "Missing element: " << solution.findMissing(A) << std::endl; // Should print 6

    std::vector<int> B = { 1, 3, 4, 5, 6, 7, 8, 9, 10 };
    std::cout << "Missing element: " << solution.findMissing(B) << std::endl; // Should print 2

    std::vector<int> C = { 1, 2, 3, 4, 5 };
    std::cout << "Missing element: " << solution.findMissing(C) << std::endl; // Should print -1

    std::vector<int> D = { 1, 2, 3, 4, 6 };
    std::cout << "Missing element: " << solution.findMissing(D) << std::endl; // Should print 5

    std::vector<int> E = { 1, 3 };
    std::cout << "Missing element: " << solution.findMissing(E) << std::endl; // Should print 2

    return 0;
}

