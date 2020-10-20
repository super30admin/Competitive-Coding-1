#The easy way to solve this problem is to find all permutation of word and then reverse them check if they are palindrome if yes then check length and return max length
#Time Complxity: O(n^2)
#Space Complexity: O(n)
from itertools import permutations 
def longestPalindrome(st):
    perm = list()
    mlen = 0
    for permutation in permutations(st):
        perm.append("".join(permutation))
    print(perm)
    for p in perm:
        print(p)
        print(p[::-1])
        if p == p[::-1] and len(p)>mlen:
            mlen = len(p)
    return mlen


st = "abccccdd"
l = longestPalindrome(st)
print(l)