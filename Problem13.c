/* Problem Statement: Determine if two strings are isomorphic or not
 *  
 *  Solution Approach:
 *    Take the two strings s and t and start parsing both string at same time.
 *    Take first letter of string s as key and store value as the first letter of string t.
 *    Keep repeating it for each letter in string.
 *    If you get a different value for already existing key, then its not isomorphic.
 *    
 *    Assumption:
 *      1. Both strings are of same length
 *
 *    Time Complexity : O(n)
 *    Space Complexity : O(k) where k = 26 alphabet letters

 */

#include<stdio.h>
#include<stdbool.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>

#define NUM_ALPHABETS 26

/* This function assumes that strings are equal in length
 * It finds out the isomorphic property of str_s using hash table
 *  Hash Table's key is the ASCII value mapped to 97 as index.
 *  For eg : key : b value : c can be stored as 
 *     str_hash[('b' - 97)] = 'c'
 */

bool is_string_isomorphic(char *str_s, char *str_t) {
	char str_hash[NUM_ALPHABETS];
	int idx = 0, str_len = 0;

    /* Validations */
	if (!str_s || !str_t) {
		printf("One or both of strings are NULL\n");
		return false;
	}
	/* Assuming lengths are equal for both strings */
    if (!(str_len = strlen(str_s))) {
    	printf("String S is empty\n");
    	return false;
    }

    /* Clear out hash table for using it */
    memset(str_hash, 0, NUM_ALPHABETS);

    /* Check if letter is valid and for each letter check the hash table
     * See approach at top of program for more details
     */
    for (idx = 0; idx < str_len; idx++) {
    	if (isalpha(str_s[idx]) && isalpha(str_t[idx])) {

    		if (str_hash[str_s[idx] - 97] == '\0') {
    			str_hash[str_s[idx] - 97] = str_t[idx];
    		} else {
    			if (str_hash[str_s[idx] - 97] != str_t[idx]) {
    				/* Found a different letter for already existing hash key */
    				return false;
    			}
    		}
    	} else {
    		printf("The letter is not alphabet str_s: [%c] str_t: [%c]\n", str_s[idx], str_t[idx]);
    		return false;
    	}
    } /* end of for loop */
	return true;
}

/* Main routine for the program */
/* Validates the arguments and then calls the function to check for
 * isomorphic property */
int main(int argc, char *argv[]) {

    int err_code = 1;
    /* Validate arguments */
	if (argc != 3) {
		printf("Usage: ./a.out <string S> <string T>\n");
		return err_code;
	}
	printf("Is str1: %s isomorphic to str2: %s ? : %s\n", argv[1], argv[2],
		    is_string_isomorphic(argv[1], argv[2]) ? "TRUE":"FALSE");
	return 0;
}

/* Test Cases

(base) manish.kumar:Competitive-Coding-1 manish.kumar$ gcc -g -Wall Problem13.c
(base) manish.kumar:Competitive-Coding-1 manish.kumar$ ./a.out
Usage: ./a.out <string S> <string T>
(base) manish.kumar:Competitive-Coding-1 manish.kumar$ ./a.out bool tppd
Is str1: bool isomorphic to str2: tppd ? : TRUE
(base) manish.kumar:Competitive-Coding-1 manish.kumar$ ./a.out b b
Is str1: b isomorphic to str2: b ? : TRUE
(base) manish.kumar:Competitive-Coding-1 manish.kumar$ ./a.out c c
Is str1: c isomorphic to str2: c ? : TRUE
(base) manish.kumar:Competitive-Coding-1 manish.kumar$ ./a.out c d
Is str1: c isomorphic to str2: d ? : TRUE
(base) manish.kumar:Competitive-Coding-1 manish.kumar$ ./a.out cd dd
Is str1: cd isomorphic to str2: dd ? : TRUE
(base) manish.kumar:Competitive-Coding-1 manish.kumar$ ./a.out cd de
Is str1: cd isomorphic to str2: de ? : TRUE
(base) manish.kumar:Competitive-Coding-1 manish.kumar$ ./a.out cd dc
Is str1: cd isomorphic to str2: dc ? : TRUE
(base) manish.kumar:Competitive-Coding-1 manish.kumar$ ./a.out cdc ted
Is str1: cdc isomorphic to str2: ted ? : FALSE
(base) manish.kumar:Competitive-Coding-1 manish.kumar$ ./a.out paper title
Is str1: paper isomorphic to str2: title ? : TRUE
(base) manish.kumar:Competitive-Coding-1 manish.kumar$ ./a.out foo bar
Is str1: foo isomorphic to str2: bar ? : FALSE
*/