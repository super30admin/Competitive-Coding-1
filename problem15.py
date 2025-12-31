#can maintain mapping in LL and arry list also but for
#O(1) search complexity, we need hashMap
#we need s to t and t to s mapping to avoid breach of "No two characters may map to the same character". eg: egl and add , here g and l can map to d. To avoid this we need 2 hashmaps
#we can't have a single map for s->t and t->s mapping because we won't know from which string the chars are coming from. Else we have to maintain a flag (in a tuple with key) with keys to show distinction but its as good as having two hashmaps. space complexity will be 2 * no. of keys, if we use 2 hashmaps or two keys within a single hashmap. 

from collections import defaultdict

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        hashMap_s = defaultdict(str)
        hashMap_t = defaultdict(str)

        for i in range(len(s)):
            if hashMap_s[s[i]]:
                if hashMap_s[s[i]] != t[i]:
                    return False #breach
            else:
                hashMap_s[s[i]] = t[i]
            
            if hashMap_t[t[i]]:
                if hashMap_t[t[i]] != s[i]:
                    return False #breach
            else:
                hashMap_t[t[i]] = s[i]

        return True
    
# Time Complexity : O(N) length of string 
# Space Complexity : O(1) as worse case it will store only 26 characters O(26) is 1.