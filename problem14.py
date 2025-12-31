from collections import defaultdict
from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if not strs:
            return None

        hashMap = defaultdict(list)
        res = []

        for str in strs:
            #26 length array initialize
            key = [0]*26

            for char in str:
                key[ord(char)-ord('a')] += 1

            hashMap[tuple(key)].append(str)

        for key,values in hashMap.items():
            res.append(values)

        return res
    
# Time Complexity: O(n*k + n)  = O(N*k)
# Space Complexity: O(nK + n + nk) = O(n*k) worse case: hashMap has n keys of O(1) and values it stores all
# the strings (nk)

# n = number of strings
# k = average length of each string