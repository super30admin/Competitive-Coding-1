/* Problem Statement: 
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

 *
 * Time Complexity : O(n) 
 * Space Complexity : O(k) where k is size of hash table 
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>


#define HT_SIZE 255

/* This function finds the maximum length of string which is a palindrome formed
 * using characters in the input array. */

int longestPalindrome(char *input_str){
    int final_cnt = 0; /* Final count */
    int ht_cnt = 0; /* Count number of elements with 1 occurence*/
    int ht[HT_SIZE]; /* HT for ASCII characters */
    
    /* Validation of input */
    if (!input_str) {
        printf("Data is empty \n");
        return final_cnt;
    }
    memset(ht, 0, sizeof(int)*HT_SIZE);
    
    while (*input_str != '\0') {
        /* increment count of occurence */
        ht[*input_str] = ht[*input_str] + 1;
        /* whenever first occurence is found, increment count of
         * hash table element */
        /* If even occurences are there, then remove it from HT and
         * increment final cnt by 2 as even elements can be directly used
         * for palindrome */
        if (ht[*input_str] == 1) {
            ht_cnt += 1;
        } else if (ht[*input_str] == 2) {
            ht[*input_str] = 0;
            final_cnt += 2;
            ht_cnt -= 1;
        }
        /* Iterate to next element */
        input_str++;
    }
    /* Now, there may be elements in HT which have 1 occurence, and we know
     * that those individual elements cannot be used to create palindrome,
     * so, just increment final cnt by 1 in those cases */
    if (ht_cnt) {
        return final_cnt + 1;        
    } else {
        return final_cnt;
    }   
}


int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Usage: ./a.out <string> \n");
        exit(1);
    }
    printf("Input string: %s \n",argv[1]);

    printf("Longest palindrome length: %d\n", longestPalindrome(argv[1]));
    return 0;
}


