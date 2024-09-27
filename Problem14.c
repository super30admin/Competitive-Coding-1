/* Problem Statement: Determine if a pattern is followed or not
 *  
 *  Given a pattern and a string str, find if str follows the same pattern.

 *   Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *   
 *   Example 1:
 *   
 *   Input: pattern = "abba", str = "dog cat cat dog"
 *   Output: true
 *   
 *   Example 2:
 *   
 *   Input:pattern = "abba", str = "dog cat cat fish"
 *   Output: false
 *   
 *   Example 3:
 *   
 *   Input: pattern = "aaaa", str = "dog cat cat dog"
 *   Output: false
 *   
 *   Example 4:
 *   
 *   Input: pattern = "abba", str = "dog dog dog dog"
 *   Output: false
 *   
 *  Solution Approach:
 *    Take a hash table and then do two comparisons. first iteration should be with 
 *    pattern letters being taken as keys and then use it to store in hash table values as the
 *      strings from the str array.

 *   Second iteration should be with str strings being taken as keys and pattern letters as values
 *   and then use hash table to compare it.
 *
 *   If both iterations produce the true result then the final result will be returned as true.
 *
 *    Assumption:
 *      1. Both pattern and str have same number of elements for eg number of letters in pattern is
 *         same as number of strings in str array.
 *
 * KINDLY NOTE THIS CAN ONLY EXECUTE ON LINUX OS, Mac OS has different implementation of hdestroy.
 * The leetcode platform doesn't allow using hashtable APIs for C programming language. Need to see
 * if it can be enabled TODO
 *
 *     Name: MANISH KUMAR
 *
 *    Time Complexity : O(n)
 *    Space Complexity : O(k) where k = hash table size
 */

#include<search.h>
#include<stdlib.h>
#include<stdio.h>
#include<stdbool.h>
#include<string.h>

#define FORWARD_DIR 0
#define REVERSE_DIR 1
#define HT_SIZE 50000

/* See above for explanation *
 * Direction forward : check pattern with str
  * direction reverse: check str with pattern
  * Debug logs are present for understanding 
 */
bool wordPattern_helper(char * pattern, char *str, int direction){
    ENTRY *res_entry = NULL;
    char *save_ptr = NULL, *tokenized_str = NULL;
	int idx = 0, pattern_len = 0;
    char *str_copy = NULL;
 
    printf("Direction of matching : %d\n", direction);
    /* Validations */
    if (!(pattern_len = strlen(pattern))) {
        printf("Pattern length is 0\n");
        return false;
    }
    /* Create Hash table of size HT_SIZE*/
    if (!hcreate(HT_SIZE)) {
        printf("Memory allocation failed \n");
        return false;
    }
    /* Tokenize string*/
    str_copy = strdup(str);
    tokenized_str = strtok_r(str_copy, " ", &save_ptr);
    
    for (idx = 0; idx < pattern_len && (tokenized_str != NULL); idx++) {
        ENTRY ht_entry;
        char arr[2]; arr[0] = pattern[idx]; arr[1] = '\0';
        printf("Processing str now : %s, pattern: %s\n", tokenized_str, arr);
        if (direction == FORWARD_DIR) {
            ht_entry.key = arr;
            ht_entry.data = NULL;
            if ((res_entry = hsearch(ht_entry, FIND)) == NULL) {
                ht_entry.data = (void *)strdup(tokenized_str);
    		if (hsearch(ht_entry, ENTER)) {
                    printf("Successful entry in HT \n");
                } else {
                    printf("Failed entry in HT\n");
                    break;
                }
            } else {
                printf("Found entry in HT %s\n", (char *)res_entry->data );
                if (strcmp((char *)res_entry->data, tokenized_str)) {
                    printf("Didn't match. Ohh !!! %s - %s\n", (char *)res_entry->data, tokenized_str);
                    return false;
                }
            }
    	} else {
            ht_entry.key = tokenized_str;
            ht_entry.data = NULL;
    	    if ((res_entry = hsearch(ht_entry, FIND)) == NULL) {
                ht_entry.data = (void *)strdup(arr);
                if ((res_entry = hsearch(ht_entry, ENTER))) {
                    printf("Successful entry in HT for key:%s value:%s \n", res_entry->key, (char *)res_entry->data);
                } else {
                    printf("Failed entry in HT\n");
                    break;
                }
            } else {
                printf("Found entry in HT key:%s, value: %s\n", res_entry->key, (char *)res_entry->data );
                if (strcmp((char *)res_entry->data, arr)) {
                    printf("Didn't match. Ohh !!! %s - %s\n",(char *)res_entry->data, arr);
                    return false;
                }
            }
    	}           
        tokenized_str = strtok_r(NULL, " ", &save_ptr);
    } /* end of for loop */

    /* Clear memory for hash table */
    /* TODO: as per man page of hashtable C library, its user's responsibility to
     * free memory for hash table values which needs some book keeping.
      */
    hdestroy();
    free(str_copy);   
	return true;
}

/* Function which does the validations for the pattern and str and calls
 *  the helper functions to do our task
 */
bool wordPattern(char * pattern, char * str){
    bool result_1, result_2;
    
    /* Validations */
    if (!pattern || !str) {
        printf("One or both of strings are NULL\n");
        return false;
    }
    if (!strlen(pattern) || !strlen(str)) {
        return true;
    }

    /* Is  pattern same from pattern to str ?*/
    result_1 = wordPattern_helper(pattern, str, FORWARD_DIR);
    if (result_1 == false) {
        return false;
    }
 
    /* Is pattern same from str to pattern ?*/
    result_2 = wordPattern_helper(pattern, str, REVERSE_DIR);
    if (result_2 == false) {
        return false;
    }
    /* If both properties are satisfied we can say that it follows same pattern*/
    return true;
}

int main(int argc, char *argv[]) {
    bool result = 0;

    if (argc != 3) {
        printf("Usage: ./a.out pattern str \n");
        exit(1);
    }
    printf("Pattern: %s, Str: %s\n",argv[1], argv[2]);
    result = wordPattern(argv[1],argv[2]);

    printf("Is same pattern ? : %s\n",result ? "TRUE":"FALSE");
    return 0;
}

/* Test cases 
$gcc -g -Wall Problem14.c
manish.kumar1@manish.kumar ~/src
$./a.out abba "dog dog dog dog"
Pattern: abba, Str: dog dog dog dog
Direction of matching : 0
Processing str now : dog, pattern: a
Successful entry in HT
Processing str now : dog, pattern: b
Successful entry in HT
Processing str now : dog, pattern: b
Found entry in HT dog
Processing str now : dog, pattern: a
Found entry in HT dog
Direction of matching : 1
Processing str now : dog, pattern: a
Successful entry in HT for key:dog value:a
Processing str now : dog, pattern: b
Found entry in HT key:dog, value: a
Didn't match. Ohh !!! a - b
Is same pattern ? : FALSE

manish.kumar1@manish.kumar ~/src
$./a.out abbb "dog dog dog dog"
Pattern: abbb, Str: dog dog dog dog
Direction of matching : 0
Processing str now : dog, pattern: a
Successful entry in HT
Processing str now : dog, pattern: b
Successful entry in HT
Processing str now : dog, pattern: b
Found entry in HT dog
Processing str now : dog, pattern: b
Found entry in HT dog
Direction of matching : 1
Processing str now : dog, pattern: a
Successful entry in HT for key:dog value:a
Processing str now : dog, pattern: b
Found entry in HT key:dog, value: a
Didn't match. Ohh !!! a - b
Is same pattern ? : FALSE

manish.kumar1@manish.kumar ~/src
$./a.out aaaa "dog cat cat dog"
Pattern: aaaa, Str: dog cat cat dog
Direction of matching : 0
Processing str now : dog, pattern: a
Successful entry in HT
Processing str now : cat, pattern: a
Found entry in HT dog
Didn't match. Ohh !!! dog - cat
Is same pattern ? : FALSE

manish.kumar1@manish.kumar ~/src
$./a.out abba "dog cat cat fish"
Pattern: abba, Str: dog cat cat fish
Direction of matching : 0
Processing str now : dog, pattern: a
Successful entry in HT
Processing str now : cat, pattern: b
Successful entry in HT
Processing str now : cat, pattern: b
Found entry in HT cat
Processing str now : fish, pattern: a
Found entry in HT dog
Didn't match. Ohh !!! dog - fish
Is same pattern ? : FALSE
manish.kumar1@manish.kumar ~/src
$

*/
