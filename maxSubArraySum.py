"""
Problem: Maximum Subarray and Subsequence Sum

We define:
- A **subsequence** as any subset of an array.
- A **subarray** as a contiguous subsequence within an array.

Task:
Given an integer array, find the maximum possible sum among:
1. All non-empty subarrays.
2. All non-empty subsequences.

Print the two values as space-separated integers on one line.

Note:
Empty subarrays or subsequences should NOT be considered.

---

Function Description:
---------------------
def maxSubarray(arr: List[int]) -> List[int]:

Parameters:
- arr (List[int]): an array of integers.

Returns:
- List[int]: a list of two integers representing:
  [maximum subarray sum, maximum subsequence sum]

---

Input Format:
-------------
- The first line contains an integer T, the number of test cases.
- For each test case:
  - The first line contains an integer n (size of the array).
  - The second line contains n space-separated integers (the elements of the array).

---

Constraints:
------------
- 1 ≤ T ≤ 10
- 1 ≤ n ≤ 10^5
- -10^4 ≤ arr[i] ≤ 10^4
- Each subarray/subsequence considered must have at least one element.

---

Sample Input:
--------------
2
4
1 2 3 4
6
2 -1 2 3 4 -5

Sample Output:
---------------
10 10
10 11

Explanation:
------------
Case 1:
All numbers are positive, so both sums are simply the total sum of the array → 10.

Case 2:
- Maximum subarray: [2, -1, 2, 3, 4] → 10
- Maximum subsequence: [2, 2, 3, 4] → 11

Case 3 (All negatives example):
Input:
1
5
-2 -3 -1 -4 -6

Output:
-1 -1
Explanation:
The maximum sum for both is the single largest element (-1).
"""

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'maxSubarray' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def maxSubarray(arr):
    if len(arr) < 1:
        return [arr[0], arr[0]]
    maxSubArraySum = arr[0]
    maxRunningSum = arr[0]
    for i, num in enumerate(arr[1:]):
        # If the num is greater than the current maxRunningSum, we start fresh
        maxRunningSum = max(num, maxRunningSum+num)
        # Here there will be cases where we start with max, then we might find something that breaks the max, then we have to only keep max subArraySum
        maxSubArraySum = max(maxSubArraySum, maxRunningSum)
    maxSubsequenceSum = 0
    for num in arr:
        if num > 0:
            maxSubsequenceSum += num

    if maxSubsequenceSum == 0:
        # This means we did not add anything to maxSubsequenceSum because we only add if num is greater than 0
        # In this case we should find the max value in the array and then just return that
        maxSubsequenceSum = max(arr)
    
    return [maxSubArraySum, maxSubsequenceSum]


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        arr = list(map(int, input().rstrip().split()))

        result = maxSubarray(arr)

        fptr.write(' '.join(map(str, result)))
        fptr.write('\n')

    fptr.close()