// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
  
using namespace std;
//use binary search and index to locate the missing element
class Solution {
public:
    int findsMissing(vector<int> arr) {
        int l = 0;
        int h = arr.size() - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr.empty())
                return -1;
            else if (arr[h] == h + 2)
                return h + 1;
            else if (arr[m] == m + 2)
                return m + 1;
            else if (arr[l] - l == arr[m] - m)
                l = m + 1;
            else
                h = m - 1;
        }
        return -1;
    }
};
int main() {
    Solution solution;
    vector<int> arr = {1, 2, 3, 4, 5, 6, 7, 9};
    int missing = solution.findsMissing(arr);
    cout << "Missing number: " << missing << endl;
    return 0;
}