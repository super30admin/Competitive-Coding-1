/* Problem Statement: Implement MinHeap using array implementation
 * Operations on MinHeap can be 
 * 1. getMin() ie getting root element 	
 * 2. extractMin() : removes the min element from heap and then heapify it again
 * 3. insert() : based on minheap property, add the elements and heapify it.
 *
 *    Time Complexity : O(log n) for removal and insert operations
 *    Space Complexity: O(n)
 *
 *   Name: Manish Kumar
 *
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define UININITIALIZED_VAL 9999
/* Function declaration */
void heapify_after_insert(int *arr, int root_idx);
void heapify_after_remove(int *arr, int root_idx, int curr_size);
int insert_elem(int *curr_size, int *arr, int elem);
void extract_min(int *arr, int *curr_size);

/* Heapify after extract_min operation is performed
 * Here, after removing the top element from heap, we move the last element
 * of heap to the top and then call this function to go from top to bottom and
 * and find the correct place of the number and heapify it. 
 *
 */
void heapify_after_remove(int *arr, int root_idx, int curr_size) {
	int left_child = (root_idx * 2) + 1;
	int right_child = (root_idx * 2) + 2;
	int next_child_idx = 0;
	int temp_var = 0;

    /* Base terminating condition for function */
    if (right_child >= curr_size) {
    	return;
    }
    /* if root value is greater than any of the child, then swap the values
     * and continue with next child
     */
	if (arr[root_idx] > arr[left_child]) {
		next_child_idx = left_child;
	} else if (arr[root_idx > arr[right_child]]){
		next_child_idx = right_child;
	} else {
		/* task is over */
		return;
	}
	/* swap values */
	temp_var = arr[root_idx];
	arr[root_idx] = arr[next_child_idx];
	arr[next_child_idx] = temp_var;

	heapify_after_remove(arr, next_child_idx, curr_size);
}

/*
 * This function adds the new element in the array which
 * is adjusted again by calling heapify function for minheap property
 *
 */
int insert_elem(int *curr_size, int *arr, int elem) {
	int err_code = 0;

	if (arr == NULL || curr_size == NULL) {
		err_code = 1;
		return err_code;
	}
	arr[*curr_size] = elem;
	heapify_after_insert(arr, *curr_size);
	*curr_size = *curr_size + 1;
	return err_code;
}

/* This function starts from the last index where the element was inserted
 * and starts checking its value with the parent.
 * For min heap, its value should be greater than or equal to its parent.
 * If its not the case, swap the values and keep going to the parent in recursive
 * fashion till the root_idx 0 is reached.
 * 
 *
 */
void heapify_after_insert(int *arr, int root_idx) {
	int temp_var = 0;
	int parent_idx = (root_idx - 1) / 2;

    /* Intentional: Not checking for NULL ptr for arr */

    /* Terminating condition for the recursive function */
	if (root_idx == 0) {
		return;
	}
	/* If parent has higher value than child, time to swap it */
	if (arr[root_idx] < arr[parent_idx]) {
		temp_var = arr[root_idx];
		arr[root_idx] = arr[parent_idx];
		arr[parent_idx] = temp_var;
		heapify_after_insert(arr, parent_idx);	
	} else {
		/* Nothing to do, just return */
		return;
	}
}

/* This function removes the top element from the heap
 * and then readjusts using heapify function.
 */
void extract_min(int *arr, int *curr_size) {

	if (!arr || !curr_size || (*curr_size == 0)) {
		printf("Nothing to delete\n");
		return;
	}
	printf("Removing top element of heap: %d\n", arr[0]);
	/* Replace root value with last element in array and then heapify */
	if (*curr_size >= 1) {
	    arr[0] = arr[*curr_size - 1];
	    arr[*curr_size - 1] = UININITIALIZED_VAL;	
	} else {
		arr[0] = UININITIALIZED_VAL;
	}
	*curr_size = *curr_size - 1;
	heapify_after_remove(arr, 0, *curr_size);
}

/* For Debugging purpose */
void display_arr(int total_elem, int *arr) {
	int idx = 0;
	printf("\n** Display array **\n");
	for (idx = 0; idx < total_elem; idx++) {
		printf("%d -> ", arr[idx]);
	}
	printf("\n*************\n");
}

/*
 * Main routine for the problem
 * Gets inputs from arguments and processes it to get the desired output
 * Returns 0 on success, otherwise err_codes for different cases
 * Allocates memory 
 */

int main(int argc, char *argv[]) {
	int err_code = 1, curr_size = 0, elem_del_cnt = 0;
	int *arr = NULL;
	int num_of_elem = 0, idx = 0;

	/* Validate arguments */
	if (argc < 2) {
		printf("Usage: ./a.out <num_of_elem> <elem_1> <elem_2> ...\n");
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
    num_of_elem = atoi(argv[1]);

	arr = (int *)malloc(sizeof(int) * num_of_elem);

	if (arr == NULL) {
		printf("Failed to allocate memory \n");
		return err_code + 2;
	}
	/* Writing a random value 999 for all elements */
    for (idx = 0; idx < num_of_elem; idx++) {
    	arr[idx] = 999;
    }
	for (idx = 0; idx < num_of_elem; idx++) {
		printf("Inserting element : %d\n", atoi(argv[idx + 2]));
		err_code = insert_elem(&curr_size, arr, atoi(argv[idx + 2]));
		if (err_code) {
			printf("Inserting elem: %d failed \n", atoi(argv[idx + 2]));
			break;
		} else {
		    display_arr(num_of_elem, arr);
		}
	}
	printf("Total elements are  : %d\n", curr_size);
	elem_del_cnt = curr_size;
	for (idx = 0; idx < elem_del_cnt; idx++) {
	    extract_min(arr, &curr_size);
	    display_arr(num_of_elem, arr);
	}
	/* Free memory allocated for array */
	free(arr);

}