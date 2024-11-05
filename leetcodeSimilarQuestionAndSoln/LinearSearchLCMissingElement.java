package leetcodeSimilarQuestionAndSoln;

/*
Time Complexity: O(n)
The function iterates through the array once to calculate the missing numbers in each gap between consecutive elements.
The algorithm iterates through each gap between elements, which takes O(n) time.
Gap calculations: For each pair of consecutive elements, we calculate the number of missing numbers, which is a constant-time operation.

Space Complexity: O(1)
The algorithm only uses a constant amount of extra space:

Variables like missing_count, k, nums[i], and temporary variables are scalar values, which take O(1) space.
No additional data structures (e.g., arrays or lists) are used to store intermediate results.
 */
class LinearSearchLCMissingElement {
    public int missingElement(int[] nums, int k)
    {
        int missingCount = 0;

        for(int i=0; i<nums.length-1;i++)
        {
            int currentGap = nums[i+1] - nums[i] - 1; //eg: 4,7,8,10 => between 7 and 4 => 7-4-1 =2 missing elements

            if(missingCount+currentGap >= k)
            {
                return nums[i] + (k-missingCount);
            }

            missingCount += currentGap;
        }

        return nums[nums.length - 1] + (k - missingCount);
    }
}
/*
Input: nums = [4, 7, 9, 10], k = 3

Iteration 1 (i = 0):
Current Numbers: nums[0] = 4, nums[1] = 7
Gap Calculation:
There are 7 - 4 - 1 = 2 missing numbers between 4 and 7 (specifically, 5 and 6).
Update missing_count:
Add these 2 missing numbers to missing_count.
Now, missing_count = 0 + 2 = 2.

Since missing_count (2) is still less than 𝑘,we continue to the next gap.
Iteration 2 (i = 1):
Current Numbers: nums[1] = 7, nums[2] = 9
Gap Calculation:
There is 9 - 7 - 1 = 1 missing number between 7 and 9 (specifically, 8).
Update missing_count:
Add this 1 missing number to missing_count.
Now, missing_count = 2 + 1 = 3.
Check if We've Reached the k

Now, missing_count equals 𝑘
k (3), meaning the k-th missing number is within this gap.

Calculate the k-th Missing Number:
To find the exact
𝑘
k-th missing number, use the formula:
nums[i] + (k-missingCount)
Substituting values:
=7+(3−2)=8
*/