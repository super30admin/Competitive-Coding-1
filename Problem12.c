/* Problem Statement: Given an array of strings, find all group of anagrams
 *  
 *  Solution Approach:
 *    Explained in function groups_anagram_together
 *    
 *    Assumption:
 *       The strings are in lower case.
 *       For grouping, as I am reading a read only data, I have printed the groups as when found by
  *       using a boolean array corresponding to the string array.
 *    Time Complexity : O(n^2) Worst case where there is no anagram found
 *    Space Complexity : O(k) where k = 26 alphabet letters
 *
 */

#include<stdio.h>
#include<stdbool.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>

#define NUM_ALPHABETS 26

/* This function does the following tasks
 * 1. Allocate memory for boolean based array for mapping which string are already
 *    identified as part of a angram group.
  * 2. For each string in the array, store the letters of the string in the hash table and
  *     then match it with other strings to see which one has the same match with hash table.
 *      Keep on marking string with this process so that we can avoid scanning other strings 
  *     unnecessarily at a later stage.
  */

void group_anagrams_together(char *arr_str[], int total_strings) {
	bool str_hash[NUM_ALPHABETS];
    bool *arr_str_mapped = NULL;
	int idx = 0, str_len = 0, idx2 = 0, str_pos = 0;

    /* Validations */
	if (!total_strings) {
		printf("String array is empty. Nothing to find\n");
		return;
	}

    /* The array maintains the strings in the source array which have been
     * already identified as part of group */
    arr_str_mapped = (bool *)malloc(sizeof(bool) * total_strings);
    if (!arr_str_mapped) {
        printf("Memory allocation failed for mapping\n");
        return;
    }

    /* For each string, fill the hash table and then go over the 
     * rest of the array and find the strings having same matching letters
     * by help of hash table lookup.
     */
    for (idx = 1; idx <= total_strings; idx++) {

        /* Clear out hash table for using it */
        memset(str_hash, 0, NUM_ALPHABETS);

        str_pos = 0;
        str_len = strlen(arr_str[idx]);

        do{
            str_hash[arr_str[idx][str_pos]- 97] = true;
        } while(str_pos++ < str_len);

        /* No need to go through the string again if it's already marked as
         * part of some group.
         */
        if (!arr_str_mapped[idx]) {
            arr_str_mapped[idx] = true;
        } else {
            continue;
        }

        printf("Anagram Set : %s ", arr_str[idx]);
        for (idx2 = idx + 1; idx2 <= total_strings; idx2++) {
            /* If the string is not yet part of anagram group and the lengths are same
             * then go over the hash table lookup and see if you get the same results
             */
            if (!arr_str_mapped[idx2] && strlen(arr_str[idx]) == strlen(arr_str[idx2])) {
                /* This code can be moved to a function as we have written it twice */
                str_len = strlen(arr_str[idx]);
                str_pos = 0;
                do{
                    if (str_hash[arr_str[idx2][str_pos]- 97] != true) {
                        break;
                    }       
                } while(++str_pos < str_len);

                /* Found anagram */
                if (str_pos == str_len) {
                    printf(" %s ",arr_str[idx2]);
                    arr_str_mapped[idx2] = true;
                }
            }/* end of if condition*/
        } /* end of inner for loop */
        printf("\n");
    } /* end of outer for loop */
}

/* Main routine for the program */
/* Validates the arguments and then calls the function to check for
 * isomorphic property */
int main(int argc, char *argv[]) {

    int err_code = 1;
    /* Validate arguments */
	if (argc < 2) {
		printf("Usage: ./a.out <string 1> ...<string n>\n");
		return err_code;
	}
    group_anagrams_together(argv, argc - 1);
	return 0;
}

/* Test Cases
(base) manish.kumar:Competitive-Coding-1 manish.kumar1$ ./a.out
Usage: ./a.out <string 1> ...<string n>
(base) manish.kumar:Competitive-Coding-1 manish.kumar1$ ./a.out eat ate
Anagram Set : eat  ate
(base) manish.kumar:Competitive-Coding-1 manish.kumar1$ ./a.out eat ate toor oort
Anagram Set : eat  ate
Anagram Set : toor  oort
(base) manish.kumar:Competitive-Coding-1 manish.kumar1$ ./a.out eat ate toor oort tep
Anagram Set : eat  ate
Anagram Set : toor  oort
Anagram Set : tep
(base) manish.kumar:Competitive-Coding-1 manish.kumar1$ ./a.out eat ate toor oort tep pe
Anagram Set : eat  ate
Anagram Set : toor  oort
Anagram Set : tep
Anagram Set : pe
(base) manish.kumar:Competitive-Coding-1 manish.kumar1$

*/