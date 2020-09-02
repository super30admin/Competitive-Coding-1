# Time Complexity : O(nlongn)
# Space Complexity : O(1)

# Any problem you faced while coding this : No

import unittest


def MissingNumber(nums):
    low = 1
    high = len(nums)-1
    while low <= high:
        mid = low + (high - low)//2
        if mid == nums[mid]-1:
            low = mid + 1
        else:
            high = mid - 1
    if nums[-1] == low:
        return None
    else:
        return low+1


class MissingNumberTest(unittest.TestCase):

    def testcase1(self):
        self.assertEqual(MissingNumber([1, 2, 3, 5, 6, 7]), 4)

    def testcase2(self):
        self.assertEqual(MissingNumber([1, 2, 3, 4, 5, 6, 7]), None)

    def testcase3(self):
        self.assertEqual(MissingNumber([1, 2, 3, 4, 5, 7]), 6)


if __name__ == "__main__":
    unittest.main(exit=False, verbosity=2)
