/* Problem Statement: Given an array of integers and an integer k, 
 * you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Time Complexity : O(n) 
 * Space Complexity : O(k) where k is size of hash table 
 */

/* PART 1 : Helper functions to implement a C hash table with 
 *  collision handling in form of linked list
 *
 * TODO: Write function for freeing hash table 
 */
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
 
#define HT_SIZE 10000 //hash_array table

struct hash_array
{
    int key;
    int count;
    struct hash_array* next;
}hash_array[HT_SIZE];

/* Add entry in hash table. If entry exists, increment the count by 1
 * If collision occurs, then chain it in data using a linked list 
 *
 */
void add_entry_hash_table(int num)   
{
    int temp = abs(num % HT_SIZE);

    if(hash_array[temp].key==0) {
        hash_array[temp].key= num;
        hash_array[temp].count++;

    }else if(hash_array[temp].key==num) {
        hash_array[temp].count++;
        printf("increment: key: %d val: %d\n", temp, hash_array[temp].count);
    }else {

        struct hash_array *p = &hash_array[temp];

        while(p->key!=num&&p->next!=NULL) {
        	p=p->next;
        }

        if(p->key==num){
        	p->count++;
        }
        else
        {
            p->next=(struct hash_array*)malloc(sizeof(struct hash_array));
            p = p->next;
            p->key = num;
            p->count = 1;
            p->next = NULL;
        }
    }   
}

/* Check if entry is present in hash table for the key. If yes, then return the
 * count stored for that hash table */
int is_present_hash_table(int num) 
{

    int temp = abs(num%HT_SIZE);
    if(hash_array[temp].count==0)
    {
        return 0;
    }else if(hash_array[temp].key==num)
    {
        return hash_array[temp].count;     
    }else
    {
        struct hash_array *p=&hash_array[temp]; 
        while((p->key != num) && (p->next != NULL)) {
        	p = p->next;
        }
        if(p->key==num) {
        	return p->count;
        }
        else
        {
            return 0;
        }
    }
    return 0;
}

/* This function implements the functionality for finding the maximum
 * subarrays which can be formed to get the sum k */

int subarraySum(char *nums[], int nums_size, int k){
    
    int index = 0; /* for loop */
    int key_cnt = 0; /* count of value for the key*/
    int sum_cnt = 0; /* total sum of numbers */
    int subarr_cnt = 0; /* our final result */
    
    /* Initialize hash table */
    for (index = 0; index < HT_SIZE; index++) {
        hash_array[index].key = 0;
        hash_array[index].count = 0;
        hash_array[index].next = NULL;
    }
    /* Add entry for 0 as key and value as 1 */
    add_entry_hash_table(0);
    for (index = 2; index < (2 + nums_size); index++) {
        printf("Input : %d\n", atoi(nums[index]));
        sum_cnt += atoi(nums[index]);
        
        /* If key is already present, then we have found our subarray */
        if ((key_cnt = is_present_hash_table(sum_cnt - k))) {
            subarr_cnt += key_cnt;
        }
        /* keep updating the total sum at that index to the hash table */
        add_entry_hash_table(sum_cnt);
    }
    return subarr_cnt;
}

int main(int argc, char *argv[]) {
    if (argc < 3) {
        printf("Usage: ./a.out k <num1> ... <num n>\n");
        exit(1);
    }
    printf("Input length: %d , k = %s\n",argc - 2, argv[1]);

    printf("Total subarray count : %d\n", subarraySum(argv, argc - 2, atoi(argv[1])));
    return 0;
}

