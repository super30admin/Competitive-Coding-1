#time complexity:o(n) ite over actual ar and new arr
#space complexity:o(n) creating extra arr
#passed all cases on LeetCode: yes
#difficulty faced:-
# comments:
#https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
class Solution:
    def findDisappearedNumbers(self, nums: 'List[int]') -> 'List[int]':

        expected = set(i for i in range(1,len(nums)+1))
        actual = set(nums)

        return list(expected - actual)

        