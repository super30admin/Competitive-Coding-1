// Problem - Find missing number in sorted array of natural numbers
//  Time Complexity : O(logn)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We use binary search to reduce our complexity from O(n) to O(logn)
// 2. We use mid+1 index to check whether we are on the correct index
// 3. If we are that means left half can totally be eliminated, and move towards
// right half

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int missingNumber(vector<int> &arr) {
    int n = (int)arr.size();
    int l = 0;
    int h = n - 1;

    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (arr[mid] == mid + 1) {
        // eliminate the left half
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return l + 1;
  }
};
