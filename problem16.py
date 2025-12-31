class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split() #O(N) N is the length of string

        #M is the len of words or length of pattern

        if len(pattern) != len(words):
            return False

        char_to_word = {} #O(M)
        word_to_char = {} #O(M)

        for ch, word in zip(pattern, words): #O(M)
            if ch in char_to_word and char_to_word[ch] != word:
                return False
            
            if word in word_to_char and word_to_char[word] != ch:
                return False

            char_to_word[ch] = word
            word_to_char[word] = ch

        return True
    
# Time Complexity: O(N) + O(M) which is O(N) 
# Space Complexity: O(M) (list words) + O(M) + O(M)