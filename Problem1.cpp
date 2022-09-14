class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        hashmap = {}
        
        if len(s) != len(t) or len(set(s)) != len(set(t)):
            return False
        
        for i in range(len(s)):
            if s[i] not in hashmap:
                hashmap[s[i]] = t[i]
            elif hashmap[s[i]] != t[i]:
                return False
        return True
    
    # Time Complexity: O(n)
    # Space Complexity: O(n) because we used hashmap
