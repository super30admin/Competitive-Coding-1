/* Problem Statement: Find the missing number in a sorted array
 *  
 *  Solution Approach:
 *    As the numbers are already sorted, we can use the sum of n numbers formula
 *    to find the missing number.
 *    step 1 Find sum of all numbers in array (1 to N with exception of 1 number missing), 
      step 2 find sum of numbers from 1 to N.
      step 3 subtract sum of step 1 from sum of step 2. You will get your answer
 *
 *    Time Complexity : O(n)
 *    Space Complexity : O(1)   
 */

#include<stdio.h>
#include<stdlib.h>

#define NO_NUMBER_MISSING -1000
/* This function returns the missing number from the array.
 *
 */
int get_missing_number_from_arr(char *argv[], int arr_len) {
	int sum_arr  = 0, arr_idx = 0;
	int expected_sum_arr = 0;

    /* Nth element here will be arr_len + 1 as one number is missing from
     * the list
     *   Sum(N) = (N * (N+1)) / 2;
     */
    expected_sum_arr = (((arr_len + 1) * (arr_len + 1 + 1)) / 2);
    for (arr_idx = 0; arr_idx < arr_len; arr_idx++) {
    	/* arr_idx + 2 as data starts from 3rd element */
    	printf("Processing element: %d\n", atoi(argv[arr_idx + 2]));
    	sum_arr += atoi(argv[arr_idx + 2]);
    }
    /* If there is no number missing, then we will get N as the output*/
    if ((expected_sum_arr - sum_arr) == (arr_len + 1)) {
    	printf("No number is missing in the list\n");
    	return NO_NUMBER_MISSING;
    } else {
    	return (expected_sum_arr - sum_arr);	
    }
}

/*
 * Main routine for the problem
 * Data should be start from 1 and be a positive number.
 * Gets inputs from arguments and processes it to get the desired output
 * Returns 0 on success, otherwise err_codes for different cases
 */
int main(int argc, char *argv[]) {
	int err_code = 1;
	int missing_num = -1;
	int num_of_elem = 0;

    /* Validate arguments */
	if (argc < 2) {
		printf("Usage: ./a.out <num_of_elem> <sorted_elem_1> <sorted_elem_2> ..... <sorted_elem_n>\n");
		return err_code;
	}
	/* Validate inputs only for total elements
	 * Not validating individual input
	 */
	num_of_elem = atoi(argv[1]);
	if (num_of_elem == 0) {
		printf("Nothing to do as the number of elements are 0 \n");
		return err_code + 1;
	}
	/* Determine the missing number */
	missing_num = get_missing_number_from_arr(argv, num_of_elem);
	if (missing_num != NO_NUMBER_MISSING) {
		printf("Missing number is %d\n", missing_num);
	}
	return (err_code - 1);
}
