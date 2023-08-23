#Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
#Examples:
#Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
#Output : 4
#Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]

def find_missing_number(arr):
    n = len(arr) + 1
    hash_set = set(arr)

    for i in range(1, n):
        if i not in hash_set:
            return i

    return n


arr = [1, 2, 4, 6, 3, 7, 8]
missing_number = find_missing_number(arr)
print("Missing number is:", missing_number)
